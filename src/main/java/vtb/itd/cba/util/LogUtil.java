/**==========================================================================
 * System name: VGold
 * Version: 1.0
 * Create date: JAN 15, 2020
 * Create by: DT.Luong
 * Copy right (c) 2019 VTB-ITC|STM-MID. All right reserved.
 ==========================================================================*/
package vtb.itd.cba.util;

import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LogUtil {

	/*
	 * Log level Info
	 */
	public static void Info(String message) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String msg = "Current thread not run, cannot get stacktrace.";
		
		if (stackTraceElements[2] != null) {
			
			String callerClass = stackTraceElements[2].getClassName();
			String callerMethod = stackTraceElements[2].getMethodName();
			String callerLine = "" + stackTraceElements[2].getLineNumber();
			msg = String.format("[Line %s][%s->%s] %s", callerLine, callerClass, callerMethod, message);
		}
		
		log.info(msg);
	}
	
	/*
	 * Log level Debug
	 */
	public static void Debug(String message) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String msg = "Current thread not run, cannot get stacktrace.";
		
		if (stackTraceElements[2] != null) {
			
			String callerClass = stackTraceElements[2].getClassName();
			String callerMethod = stackTraceElements[2].getMethodName();
			String callerLine = "" + stackTraceElements[2].getLineNumber();
			msg = String.format("[Line %s][%s->%s] %s", callerLine, callerClass, callerMethod, message);
		}
		
		log.debug(msg);
	}
	
	/*
	 * Log level Error
	 */
	public static void Error(String message) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String msg = "Current thread not run, cannot get stacktrace.";
		
		if (stackTraceElements[2] != null) {
			
			String callerClass = stackTraceElements[2].getClassName();
			String callerMethod = stackTraceElements[2].getMethodName();
			String callerLine = "" + stackTraceElements[2].getLineNumber();
			msg = String.format("[Line %s][%s->%s] %s", callerLine, callerClass, callerMethod, message);
		}
		
		log.error(msg);
	}

}
