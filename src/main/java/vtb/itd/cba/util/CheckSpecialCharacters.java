/**
 * 
 */
package vtb.itd.cba.util;

//import java.util.ArrayList;
//import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author DuongNT
 * Check String contain any Special character ("-" is allowed)
 * 
 */
public class CheckSpecialCharacters {

	public CheckSpecialCharacters() {
		super();
		
	}

	public boolean getSpecialCharacter(String str)
	 {
		boolean result = false; 
		
		if (str == null || str.trim().isEmpty()) {
	         System.out.println("format of string is Incorrect ");
	         return false;
	    }
	    //This character is allowed
		String specialAllowCharacter = "-";
		str = str.replaceAll(specialAllowCharacter, "");  //"-" is allowed
 		
		str = str.replaceAll("_", "");  ////"_" is allowed
		
	    Pattern pattern = Pattern.compile("[^A-Za-z0-9.]");
	    Matcher matcher = pattern.matcher(str);
	 
	    result = matcher.find();
	     	     
	    return result;
	 }
	
	public boolean checkSpecialCharacter(String strSource, String strPattern ,String strSpcialAllow) //"[^A-Za-z0-9.]"
	 {
		boolean result = false; 
		
		if (strSource == null || strSource.trim().isEmpty()) {
	         System.out.println("format of string is Incorrect ");
	         return false;
	    }
	 
		strSource = strSource.replaceAll(strSpcialAllow, "");  //"strSpcialAllow" is allowed
						
	    Pattern pattern = Pattern.compile(strPattern);
	    Matcher matcher = pattern.matcher(strSource);
	 
	    
	   // result = matcher.find();
	    result = matcher.matches();
	            	     
	    return result;
	 }
	
	
	 /*
	 public static void main(String[] args) {
		 
		CheckSpecialCharacters FSC = new  CheckSpecialCharacters() ;
	    String str ="  076 66 1   		4   2";
	    System.out.println(str.replaceAll(" ", ""));
	    System.out.println( FSC.checkSpecialCharacter(str,"^[0-9]*$","")); //"[^A-Za-z0-9.]" "[0-9]+"
	      	    
	}
	*/
	  
}