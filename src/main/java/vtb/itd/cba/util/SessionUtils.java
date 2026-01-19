/**
 * 
 */
package vtb.itd.cba.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DuongNT
 *
 * 
 */
public class SessionUtils {

	//Store String name in session
	public static void storeString(HttpServletRequest request, String attributeName ,String str) {
		request.getSession().setAttribute(attributeName, str);		
	}
	
	public static String getString(HttpServletRequest request, String attributeName) {
		String str  = request.getSession().getAttribute(attributeName).toString();
		return str;
	}
    
}