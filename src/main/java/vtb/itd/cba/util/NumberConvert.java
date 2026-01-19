/**==========================================================================
 * System name: VGold
 * Version: 1.0
 * Create date: Dec 5, 2019
 * Create by: CBA-MID
 * Copy right (c) 2019 VTB-ITC|STM-MID. All right reserved.
 ==========================================================================*/
package vtb.itd.cba.util;

//import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberConvert {

	/**
	 * Gets the order.
	 *
	 * @param j the j
	 * @return the order
	 */
	private String getOrder(int j) {
		String strResult = "";
		switch (j) {
		case 6:
			strResult = "tri\u1EC7u"; // trieu
			break;
		case 5:
			strResult = "tri\u1EC7u"; // tram
			break;
		case 4:
			strResult = "ng\u00E0n"; // ngan
			break;
		case 3:
			strResult = "t\u1EF7"; // ty
			break;
		case 2:
			strResult = "tri\u1EC7u"; // trieu
			break;
		case 1:
			strResult = "ng\u00E0n"; // ngan
			break;
		case 0:
			strResult = ""; // dong
			break;
		}
		return strResult;
	}


	private String getString(int in) {
		switch (in) {
		case 0:
			return "kh\u00F4ng";// khong.
		case 1:
			return "m\u1ED9t";// 1
		case 2:
			return "hai";
		case 3:
			return "ba";
		case 4:
			return "b\u1ED1n";
		case 5:
			return "n\u0103m";
		case 6:
			return "s\u00E1u";
		case 7:
			return "b\u1EA9y";
		case 8:
			return "t\u00E1m";
		default:
			return "ch\u00EDn";
		}
	}

	public String read2Num(String in) {
		String strResult = "";
		strResult = in.substring(0, 1);
		if (strResult.equals("1")) {
			if ((in.substring(1, 2).equals("0"))) {
				strResult = "m\u01B0\u1EDDi";// 10
			} else if (in.substring(1, 2).equals("5")) {
				strResult = "m\u01B0\u1EDDi l\u0103m"; // 15
			} else // 11
			{
				strResult = "m\u01B0\u1EDDi" + " " + getString(Integer.parseInt(in.substring(1, 2)));
			}
		} else {
			if ((in.substring(1, 2).equals("0"))) {
				strResult = getString(Integer.parseInt(in.substring(0, 1))) + " " + "m\u01B0\u01A1i"; // mu*o*i
			} else {
				if (in.substring(1, 2).equals("1")) {
					strResult = getString(Integer.parseInt(in.substring(0, 1))) + " " + "m\u01B0\u01A1i m\u1ED1t"; // mu*o*i mo^'t
				} else if (in.substring(1, 2).equals("5")) {
					strResult = getString(Integer.parseInt(in.substring(0, 1))) + " " + "m\u01B0\u01A1i l\u0103m"; // mu*o*i la(m
				} else {
					strResult = getString(Integer.parseInt(in.substring(0, 1))) + " " + "m\u01B0\u01A1i" + " " + getString(Integer.parseInt(in.substring(1, 2)));
				}
			}
		}
		return strResult;
	}

	public String read3Num(String in) {
		String strResult = "";

		if (in.substring(0, 1).equals("0") && in.substring(1, 2).equals("0") && in.substring(2, 3).equals("0"))// 000
		{
			strResult = "";
		} else if (!in.substring(0, 1).equals("0") && in.substring(1, 2).equals("0") && in.substring(2, 3).equals("0"))// X00
		{
			strResult = getString(Integer.parseInt(in.substring(0, 1))) + " tr\u0103m";// tram
		} else if (in.substring(0, 1).equals("0") && !in.substring(1, 2).equals("0"))// 0X0 hoac 0XX
		{
			strResult = "kh\u00F4ng tr\u0103m" + " " + read2Num(in.substring(1, 3));// khong tram
		} else if (in.substring(0, 1).equals("0") && in.substring(1, 2).equals("0") && !in.substring(2, 3).equals("0"))// 00X
		{// khogn tram linh
			strResult = "kh\u00F4ng tr\u0103m linh" + " " + getString(Integer.parseInt(in.substring(2, 3)));
		} else if (!in.substring(0, 1).equals("0") && !in.substring(1, 2).equals("0"))// XX0 hoac XXX
		{
			strResult = getString(Integer.parseInt(in.substring(0, 1))) + " tr\u0103m " + read2Num(in.substring(1, 3));
		} else if (!in.substring(0, 1).equals("0") && in.substring(1, 2).equals("0") && !in.substring(2, 3).equals("0"))// X0X
		{
			if (in.substring(2, 3).equals("5"))// linh la(m
			{
				strResult = getString(Integer.parseInt(in.substring(0, 1))) + " tr\u0103m linh " + getString(Integer.parseInt(in.substring(2, 3)));
			} else {
				strResult = getString(Integer.parseInt(in.substring(0, 1))) + " tr\u0103m linh " + getString(Integer.parseInt(in.substring(2, 3)));
			}
		}
		return strResult;
	}

	public String getStringnum(String iNum, int iOrder) {
		String result = "";

		int len = iNum.length();
		switch (len) {
		case 1:
			result = getString(Integer.parseInt(iNum)) + " " + getOrder(iOrder);
			break;
		case 2:
			result = read2Num(iNum) + " " + getOrder(iOrder);
			break;
		case 3:
			result = read3Num(iNum);
			result = (result.trim().equals("") ? "" : result + " " + getOrder(iOrder));
			if (iOrder == 3 && iNum.trim().equals("000")) {
				result = getOrder(iOrder);
			}
			break;
		}
		return result;
	}

	// convert number into words ENGLISH

	private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen" };

	private static String convertLessThanOneThousand(int number) {
		String soFar;

		if (number % 100 < 20) {
			soFar = numNames[number % 100];
			number /= 100;
		} else {
			soFar = numNames[number % 10];
			number /= 10;

			soFar = tensNames[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0)
			return soFar;
		return numNames[number] + " hundred" + soFar;
	}

	public String ConvertEN(String number) {

		// 0 to 9 999 999 999 999 999 999
		number = this.Del0(number);
		if (number == "") {
			return "";
		}

		String snumber = number;

		// pad with "0"
		String mask = "0000000000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(Long.parseLong(number));
		
		// X nnn nnn nnn nnn nnn nnn
		int quintillions = Integer.parseInt(snumber.substring(0, 1));
		
		// n XXX nnn nnn nnn nnn nnn
		int quadrillions = Integer.parseInt(snumber.substring(1, 4));
		
		// n nnn XXX nnn nnn nnn nnn
		int trillions = Integer.parseInt(snumber.substring(4, 7));

		// n nnn nnn XXX nnn nnn nnn
		int billions = Integer.parseInt(snumber.substring(7, 10));

		// n nnn nnn nnn XXX nnn nnn
		int millions = Integer.parseInt(snumber.substring(10, 13));
		
		// n nnn nnn nnn nnn XXX nnn
		int hundredThousands = Integer.parseInt(snumber.substring(13, 16));
		
		// n nnn nnn nnn nnn nnn XXX
		int thousands = Integer.parseInt(snumber.substring(16, 19));

		String result = "";

		String tradQuintillions;
		switch (quintillions) {
		case 0:
			tradQuintillions = "";
			break;
		case 1:
			tradQuintillions = convertLessThanOneThousand(quintillions) + " quintillion, ";
			break;
		default:
			tradQuintillions = convertLessThanOneThousand(quintillions) + " quintillion, ";
		}
		result = result + tradQuintillions;

		String tradQuadrillions;
		switch (quadrillions) {
		case 0:
			tradQuadrillions = "";
			break;
		case 1:
			tradQuadrillions = convertLessThanOneThousand(quadrillions) + " quadrillion, ";
			break;
		default:
			tradQuadrillions = convertLessThanOneThousand(quadrillions) + " quadrillion, ";
		}
		result = result + tradQuadrillions;

		String tradTrillions;
		switch (trillions) {
		case 0:
			tradTrillions = "";
			break;
		case 1:
			tradTrillions = convertLessThanOneThousand(trillions) + " trillion, ";
			break;
		default:
			tradTrillions = convertLessThanOneThousand(trillions) + " trillion, ";
		}
		result = result + tradTrillions;
		
		String tradBillions;
		switch (billions) {
		case 0:
			tradBillions = "";
			break;
		case 1:
			tradBillions = convertLessThanOneThousand(billions) + " billion, ";
			break;
		default:
			tradBillions = convertLessThanOneThousand(billions) + " billion, ";
		}
		result = result + tradBillions;

		String tradMillions;
		switch (millions) {
		case 0:
			tradMillions = "";
			break;
		case 1:
			tradMillions = convertLessThanOneThousand(millions) + " million, ";
			break;
		default:
			tradMillions = convertLessThanOneThousand(millions) + " million, ";
		}
		result = result + tradMillions;

		String tradHundredThousands;
		switch (hundredThousands) {
		case 0:
			tradHundredThousands = "";
			break;
		case 1:
			tradHundredThousands = "one thousand, ";
			break;
		default:
			tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " thousand, ";
		}
		result = result + tradHundredThousands;

		String tradThousand;
		tradThousand = convertLessThanOneThousand(thousands);
		result = result + tradThousand;

		// rove extra spaces!
		String strResult = result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
		if (strResult.trim().substring(strResult.length() - 2, strResult.length() - 1).equals(","))
			strResult = strResult.substring(0, strResult.length() - 2);

		return strResult;
	}

	public String ConvertNumber2Words(String number, String language) {
		String strResult = "";

		if (language.trim().equals("en_us")) {
			strResult = ConvertEN(number.trim());
		} else if (language.trim().equals("vi")) {
			strResult = ConvertVI(number.trim());
		}

		return strResult;
	}

	public String ConvertNumber2WordsAll(String strNumber, String language, String currCode) {
		System.out.println("strNumber = " + strNumber);
		String strResult = "";
		try {
			int index = strNumber.indexOf(".");
			String name = "";
			String subname = "";
			String midand = "";

			if (language.trim().equals("en_us")) {

				midand = " and ";
			} else {

				midand = " v\u00E0 ";
			}

			String preDec = "";
			String posDec = "";
			String strEnd = "";
			if (index < 0) {
				preDec = ConvertNumber2Words(strNumber, language);

				if (strNumber.length() >= 4 && strNumber.substring(strNumber.length() - 3, strNumber.length()).equals("000")) {
					if (language.equals("vi")) {
						strEnd = " ch\u1EB5n./.";
					} else {
						strEnd = " only./.";
					}
				} else if (strNumber.length() == 3 && strNumber.substring(strNumber.length() - 2, strNumber.length()).equals("00")) {
					if (language.equals("vi")) {
						strEnd = " ch\u1EB5n./.";
					} else {
						strEnd = " only./.";
					}
				} else if (strNumber.length() == 2 && strNumber.substring(strNumber.length() - 1, strNumber.length()).equals("0")) {
					if (language.equals("vi")) {
						strEnd = " ch\u1EB5n./.";
					} else {
						strEnd = " only./.";
					}
				} else {
					strEnd = "./.";
				}
			} else {
				preDec = ConvertNumber2Words(strNumber.substring(0, index), language);
				posDec = strNumber.substring(index + 1, strNumber.length());
				posDec = (posDec.length() >= 2 ? posDec : posDec + "0");
				posDec = ConvertNumber2Words(posDec, language);

				strEnd = "./.";
			}

			preDec = preDec.substring(0, 1).toUpperCase() + preDec.substring(1, preDec.length());

			if (posDec == null || posDec.trim().equals("")) {
				strResult = "%s%s";
				strResult = String.format(strResult, preDec, name + strEnd);
			} else {
				if (subname == null || subname.trim().equals("") || subname.trim().equals("null")) {
					strResult = "%s%s";
					strResult = String.format(strResult, preDec + ", ", name + strEnd);
				} else {
					strResult = "%s%s";
					strResult = String.format(strResult, preDec, name);
					strResult += "%s%s";
					strResult = String.format(strResult, midand + posDec, subname + strEnd);
				}
			}
		} catch (Exception ex) {
			//logger.error(ex.getMessage());
		}
		//
		return strResult;
	}

	// end convert number into words ENGLISH
	public String Del0(String in) {
		String strResult = "";

		int i = 0;
		while (i < in.length()) {
			if (in.charAt(i) != '0')
				break;
			i++;
		}
		strResult = in.substring(i, in.length());
		return strResult;
	}

	public String ConvertVI(String in) {
		String strResult = "";
		in = this.Del0(in);

		if (in.trim().equals("")) {
			return "";
		}

		try {
			int nguyen = in.length() / 3;
			int le = in.length() % 3;
			NumberConvert oNum = new NumberConvert();

			int index = 0;
			if (le != 0) {
				strResult += oNum.getStringnum(in.substring(index, le), nguyen) + ", ";
				index = le;
			}
			String temp = "";
			for (int i = nguyen - 1; i >= 0; i--) {
				temp = oNum.getStringnum(in.substring(index, index + 3), i);
				if (!temp.equals("")) {
					strResult += temp + ", ";
				}
				index += 3;
			}
		} catch (Exception ex) {
			strResult = in;
		}

		strResult = strResult.trim();

		strResult = ((strResult.charAt(strResult.length() - 1) == ',') ? strResult.substring(0, strResult.length() - 1) + " " : strResult + " ");

		return strResult;
	}
	
	public String ConvertNumber2WordsAllVND(String strNumber) {
		System.out.println("strNumber = " + strNumber);
		String strResult = "";
		try {
			int index = strNumber.indexOf(".");
			String name = "";
			String subname = "";
			String midand = " v\u00E0 ";
			
			String preDec = "";
			String posDec = "";
			String strEnd = "";
			if (index < 0) {
				preDec = ConvertNumber2Words(strNumber, "vi");
				preDec = preDec.trim() + " ";

				if (strNumber.length() >= 4 && strNumber.substring(strNumber.length() - 3, strNumber.length()).equals("000")) {
					
					strEnd = "đồng ch\u1EB5n/.";
					
				} else {
					strEnd = "đồng/.";
				}
			} else {
				preDec = ConvertNumber2Words(strNumber.substring(0, index), "vi");
				posDec = strNumber.substring(index + 1, strNumber.length());
				posDec = (posDec.length() >= 2 ? posDec : posDec + "0");
				strEnd = "đồng/.";
			}

			preDec = preDec.substring(0, 1).toUpperCase() + preDec.substring(1, preDec.length());

			if (posDec == null || posDec.trim().equals("")) {
				strResult = "%s%s";
				strResult = String.format(strResult, preDec, name + strEnd);
			} else {
				if (subname == null || subname.trim().equals("") || subname.trim().equals("null")) {
					strResult = "%s%s";
					strResult = String.format(strResult, preDec + ", ", name + strEnd);
				} else {
					strResult = "%s%s";
					strResult = String.format(strResult, preDec, name);
					strResult += "%s%s";
					strResult = String.format(strResult, midand + posDec, subname + strEnd);
				}
			}
		} catch (Exception ex) {
			//logger.error(ex.getMessage());
		}
		
		return strResult;
	}

	
	/*
	 * public static void main(String[] art) { String currency="13.23"; BigDecimal
	 * bigDecimalCurrency=new BigDecimal(currency);
	 * System.out.println("Converted String currency to bigDecimalCurrency: "
	 * +bigDecimalCurrency);
	 * 
	 * NumberConvert n = new NumberConvert();
	 * System.out.println(n.ConvertNumber2WordsAllVND("12131234567000"));
	 * System.out.println(n.ConvertNumber2WordsAll("12131234567891", "vi", "VND"));
	 * System.out.println(n.ConvertNumber2WordsAll("1234567890123456789.12",
	 * "en_us", "VND"));
	 * System.out.println(n.ConvertNumber2WordsAll("12000100.50","vi","USA"));
	 * 
	 * System.out.println(n.ConvertNumber2WordsAll("53053213", "en_us", "USD")); }
	 */
	 
}