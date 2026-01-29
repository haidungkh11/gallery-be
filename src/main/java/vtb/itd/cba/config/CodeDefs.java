/**
 *
 */
package vtb.itd.cba.config;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum CodeDefs {


    RETURN_CODE_SUCCEED("00", "XỬ LÝ THÀNH CÔNG", HttpStatus.OK),

    RETURN_CODE_EXCEPTION("02", "CÓ LỖI XẢY RA",HttpStatus.BAD_REQUEST),

    RETURN_CODE_EXIST_CHILDREN_ITEM("03", "CHỈ CÓ THỂ XÓA THƯ MỤC TRỐNG",HttpStatus.BAD_REQUEST),

    RETURN_CODE_NOT_FOUND("04","KHÔNG TÌM THẤY BẢN GHI",HttpStatus.NOT_FOUND),



    // JASYPT CONFIG
    JASYPT_AlGORITHM("PBEWITHHMACSHA512ANDAES_256", "THUAT TOAN", HttpStatus.OK),
    JASYPT_PASSWORD("g7%#$Ghd$f609h7(%36#2fduyd!Xsdk1ax", "MAT KHAU", HttpStatus.OK),

    JASYPT_INTERATION("1000", "INTERATION",HttpStatus.OK),
    JASYPT_POOLSIZE("1", "POOLSIZE",HttpStatus.OK),
    JASYPT_SALT_CLASSNAME("org.jasypt.salt.RandomSaltGenerator", "TEN CLASS GEN SALT", HttpStatus.OK),
    JASYPT_IV_CLASSNAME("org.jasypt.iv.RandomIvGenerator", "IV CLASS NAME", HttpStatus.OK),
    JASYPT_STRING_OUTPUT("base64", "MA HOA", HttpStatus.OK);


    private final String code;
    private final String description;

    private final HttpStatusCode statusCode;




}
