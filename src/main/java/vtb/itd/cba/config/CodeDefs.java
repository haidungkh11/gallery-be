/**
 *
 */
package vtb.itd.cba.config;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author DuongNT
 * CODE DEFINATION for APPLICATION
 */
public enum CodeDefs {


    RETURN_CODE_SUCCEED("00", "XU LY THANH CONG"),
    RETURN_CODE_ACTIVE("01", "HOAT DONG"),
    RETURN_CODE_FIELD_NOT_VALID("07", "GIA TRI TRUONG KHONG HOP LE"),
    RETURN_CODE_EXCEPTION("02", "CO LOI XAY RA"),
    RETURN_CODE_DUPLICATE("03", "BAN GHI BI LAP"),
    RETURN_CODE_EXIST("04", "BAN GHI DA TON TAI"),
    RETURN_CODE_NOT_EXIST("05", "BAN GHI CHUA TON TAI"),
    RETURN_CODE_CHECK_DATA_INPUT("06", "DAU VAO KHONG HOP LE"),
    RETURN_CODE_STATUS_INVALID("09", "TRANG THAI KHONG HOP LE"),

    // JASYPT CONFIG
    JASYPT_AlGORITHM("PBEWITHHMACSHA512ANDAES_256", "THUAT TOAN"),
    JASYPT_PASSWORD("g7%#$Ghd$f609h7(%36#2fduyd!Xsdk1ax", "MAT KHAU"),

    JASYPT_INTERATION(1000, "INTERATION"),
    JASYPT_POOLSIZE(1, "POOLSIZE"),
    JASYPT_SALT_CLASSNAME("org.jasypt.salt.RandomSaltGenerator", "TEN CLASS GEN SALT"),
    JASYPT_IV_CLASSNAME("org.jasypt.iv.RandomIvGenerator", "IV CLASS NAME"),
    JASYPT_STRING_OUTPUT("base64", "MA HOA");


    private final String statusCode;
    private final String description;

    private final Integer parameter;

    // Constructor của enum
    CodeDefs(String statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
        this.parameter = null;
    }

    CodeDefs(Integer parameter, String description) {
        this.statusCode = String.valueOf(parameter);
        this.parameter = parameter;
        this.description = description;
    }

    public Integer getParameter() {
        return parameter;
    }

    // Getter cho status
    public String getStatusCode() {
        return statusCode;
    }

    // Getter cho description
    public String getDescription() {
        return description;
    }
}
