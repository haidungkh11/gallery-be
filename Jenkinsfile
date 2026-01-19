pipeline {
	
	environment {
	    // The app name
	    APP_NAME = 'swapcom'
	    
	    // The registry of image
	    REGISTRY_IMAGE = 'dockernode1.hq.icbv.com:5000'
	    
	    // The path of uat/prod image
	    PATH_IMAGE = 'uat-stm/swapcom'
	    
	    // K8S
	    K8S_CREDENTIAL = 'k8s_credential_cbuatcicd'
	    K8S_SERVER = 'https://lb-k8s:6443'
	    K8S_NAMESPACE = 'cbuat'
	    K8S_DEPLOYMENT_APP = 'swapcom'
	    
	     // CI Admin
	    MAIL_DEFAULT = 'chinh.nd@vietinbank.vn;thanhnt20@vietinbank.vn'
	    // Dev team.
	    MAIL_RECEIVE = 'CBA-MID@vietinbank.vn'
	    
	    // Flag
	    ENV = 'UAT'
	    FLAG_SCANCODE = 'FALSE'
	  }
	  
	agent { label 'master' }
	
	tools {
		// Add needed tools for CI build
		maven 'MVN3'
		jdk 'JDK17'
	}
	
	stages {
		stage('Check the environment'){
			steps {
				// Precheck the system variables
				echo "java -version"
				echo "maven -version"
			}
		}
		
		stage('Deploy package'){
			parallel {
				stage('Clean and install package') {
					steps {
						sh "mvn clean install -X -DskipTests=true -Dmaven.test.failure.ignore=true"
					}
				}
			}
		}
		
		stage('Build image') {
			// This builds the actual image; synonymous to docker build on the command line
			steps {
				sh "docker build -t $APP_NAME ."
			}
		}
		
		stage('Push image to Harbor') {
			// Tag and push image to registry docker
			steps {
				sh "docker tag $APP_NAME $REGISTRY_IMAGE/$PATH_IMAGE:v$BUILD_NUMBER"
				sh "docker push $REGISTRY_IMAGE/$PATH_IMAGE:v$BUILD_NUMBER"
			}
		}
		
		stage('Deploy to K8S') {
			// Deploy Container to K8s
			steps {	
					/* Deploy with k8s new with serverUrl https://lb-k8s:6443 and namespace stm-uat */	
					withKubeConfig(credentialsId: K8S_CREDENTIAL, serverUrl: K8S_SERVER){
						//sh 'kubectl config set-context $(kubectl config current-context) --user=cbuatcicd'
						sh 'kubectl config set-context --current --namespace=$K8S_NAMESPACE'
						sh 'kubectl set image deployment.app/$K8S_DEPLOYMENT_APP $K8S_DEPLOYMENT_APP=$REGISTRY_IMAGE/$PATH_IMAGE:v$BUILD_NUMBER'
				 	}

				 	/* Deploy with OpenShift with serverUrl https://api.uatops.hq.icbv.com:6443 and namespace stmapi-uat  */	
				 	/* withKubeConfig(credentialsId: '5ce9d91c-beab-4ddb-8ab8-cb83371459e3',serverUrl: 'https://api.uatops.hq.icbv.com:6443'){
						sh 'oc config set-context --current --namespace=stmapi-uat'	    
						sh 'oc set image deployment.app/$APP_NAME $APP_NAME=$REGISTRY_IMAGE/$PATH_IMAGE:v$BUILD_NUMBER'
				 	}*/
			 		
				}
		}
		
		stage('Purging'){
			parallel {
				stage('Clean package') {
					steps {
						sh "mvn clean"
					}
				}
			}
		}
	}
	
	post { 
        always { 
			 script {
				def jobName = currentBuild.fullDisplayName
				emailext body: '''${SCRIPT, template="groovy-html.template"}''',
				mimeType: 'text/html',
				subject: "[ITC CI/CD $ENV] ${jobName}",
				to: "${MAIL_DEFAULT}, ${MAIL_RECEIVE}",
				replyTo: "${MAIL_RECEIVE}",
				recipientProviders: [[$class: 'CulpritsRecipientProvider']]
        	}
            echo 'CI/CD DONE'
        }
    }

}
