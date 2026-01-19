/**==========================================================================
 * System name: swapcom
 * Version: 1.0
 * Create date: Nov 16, 2022
 * Create by: CBA-MID
 * Copy right (c) 2023 VTB-ITD | CBA-MID. All right reserved.
 ==========================================================================*/
package vtb.itd.cba.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * The Class JasyptConfig for custom the encrypt
 */
@Configuration
public class JasyptConfig {
 
    public static SimpleStringPBEConfig getSimpleStringPBEConfig() {
        
    	final SimpleStringPBEConfig pbeConfig = new SimpleStringPBEConfig();
        
    	pbeConfig.setAlgorithm(CodeDefs.JASYPT_AlGORITHM.getStatusCode());
        pbeConfig.setPassword(CodeDefs.JASYPT_PASSWORD.getStatusCode());  // Encrypt private key.
        pbeConfig.setKeyObtentionIterations(CodeDefs.JASYPT_INTERATION.getStatusCode());
        pbeConfig.setPoolSize(CodeDefs.JASYPT_POOLSIZE.getStatusCode());
        pbeConfig.setProviderName(null);
        pbeConfig.setProviderClassName(null);
        pbeConfig.setSaltGeneratorClassName(CodeDefs.JASYPT_SALT_CLASSNAME.getStatusCode());
        pbeConfig.setIvGeneratorClassName(CodeDefs.JASYPT_IV_CLASSNAME.getStatusCode());
        pbeConfig.setStringOutputType(CodeDefs.JASYPT_STRING_OUTPUT.getStatusCode());
 
        return pbeConfig;
    }
 
    /**
     * Encryptor.
     *
     * @return the string for encrypt
     */
    @Bean(name = "jasyptStringEncryptor")
    StringEncryptor encryptor() {
        
    	final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        
    	pbeStringEncryptor.setConfig(getSimpleStringPBEConfig());
 
        return pbeStringEncryptor;
    }
}