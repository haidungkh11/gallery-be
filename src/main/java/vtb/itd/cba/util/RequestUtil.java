/**
 * 
 */
package vtb.itd.cba.util;

/**
 * @author DuongNT
 *
 * 
 */
//import java.util.Date;
import java.util.Map;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequestUtil {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static boolean getBoolean(Map<String, String> requestParams, String name, boolean defaultValue) {
		boolean value = defaultValue;
		if (requestParams.get(name) != null) {
			value = Boolean.valueOf(requestParams.get(name));
		}
		return value;
	}

	public static int getInteger(Map<String, String> requestParams, String name, int defaultValue) {
		int value = defaultValue;
		if (requestParams.get(name) != null) {
			value = Integer.valueOf(requestParams.get(name));
		}
		return value;
	}

	public static String[] getArray(Map<String, String> requestParams, String name) {
		String[] value = new String[] {};
		if (requestParams.get(name) != null) {
			value = requestParams.get(name).split(",");
		}
		return value;
	}

	public static LocalDate getDate(Map<String, String> requestParams, String name) {
		LocalDate value = null;

		if (requestParams.get(name) != null) {

			String input = requestParams.get(name).trim();
			
			try {
				value = LocalDate.parse(input,formatter);
			} catch (Exception e) {
				throw new RuntimeException("Failed to parse date " + input);
			}
		}
		return value;
	}

	public static String dateToString(LocalDate date) {
		String dateString = null;
		if (date != null) {
			dateString = date.format(formatter);
		}

		return dateString;
	}

	public static Integer parseToInteger(String integer) {
		Integer parsedInteger = null;
		try {
			parsedInteger = Integer.parseInt(integer);
		} catch (Exception e) {
		}
		return parsedInteger;
	}

	public static LocalDate parseToDate(String date) {
		LocalDate parsedDate = null;
		try {
			parsedDate = LocalDate.parse(date,formatter);
		} catch (Exception e) {
		}
		return parsedDate;
	}
}