/**==========================================================================
 * System name: swapcom
 * Version: 1.0
 * Create date: Apr 18, 2022
 * Create by: CBA-MID
 * Copy right (c) 2023 VTB-ITD | CBA-MID. All right reserved.
 ==========================================================================*/
package vtb.itd.cba.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtil.
 */
public class DateUtil {
	
	/** The Constant sdf. */
	private static final SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	
	public static String getCurrentDate() {
		Date date = new Date();
		return sdf.format(date);
	}
	
	public static Date getTransDateByFormat(String dateToFormat, String stringFormat) throws ParseException {
		SimpleDateFormat sdf = new java.text.SimpleDateFormat(stringFormat);
		return sdf.parse(dateToFormat);
	}

	public String getCurrentTime() {
		String strFormat = "dd/MM/yyyy hh:mm a";
		DateTimeFormatter formatterdatetime = DateTimeFormatter.ofPattern(strFormat);
		LocalDateTime datetime = LocalDateTime.now();
		return formatterdatetime.format(datetime);
	}
	
	public static String getCurrentDateByFormat(String strFormat) {
		SimpleDateFormat sdf = new java.text.SimpleDateFormat(strFormat);
		Date date = new Date();
		return sdf.format(date);
	}

	/**
	 * Gets the formatted time.
	 *
	 * @param strDateTime the str date time
	 * @return the formatted time
	 */
	public String getFormattedTime(String strDateTime) {
		String year = strDateTime.substring(0, 4);
		String month = strDateTime.substring(5, 7);
		String date = strDateTime.substring(8, 10);
		String time = strDateTime.substring(11, 16);
		return date + '/' + month + '/' + year + ' ' + time;
	}

	
	/**
	 * Verify input.
	 *
	 * @param input the input
	 * @return the java.util. date
	 */
	public static java.util.Date verifyInput(String input) {
		if (input != null && !input.trim().isEmpty()) {
			try {
				java.util.Date ret = sdf.parse(input.trim());
				if (sdf.format(ret).equals(input.trim())) {
					return ret;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * DateUtil dateUtil = new DateUtil();
	 * System.out.println(dateUtil.getCurrentTimeDateByFormat("dd/MM/yyyy hh:mm a"))
	 * ; }
	 */

}
