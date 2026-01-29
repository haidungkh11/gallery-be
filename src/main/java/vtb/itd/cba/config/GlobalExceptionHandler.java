package vtb.itd.cba.config;

import ch.qos.logback.core.spi.ErrorCodes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import vtb.itd.cba.explorerItem.ExplorerItem;
import vtb.itd.cba.response.ResponseObject;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ResponseObject> listAllItemRoot(AppException exception){
        ResponseObject responseObject = new ResponseObject<>();

        CodeDefs codeDefs = exception.getCodeDefs();

        responseObject.setStatus(codeDefs.getCode());
        responseObject.setMessage(codeDefs.getDescription());

        return ResponseEntity.status(codeDefs.getStatusCode()).body(responseObject);
    }
}
