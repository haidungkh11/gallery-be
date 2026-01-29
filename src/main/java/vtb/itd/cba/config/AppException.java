package vtb.itd.cba.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class AppException extends RuntimeException{
    private final CodeDefs codeDefs;

    public AppException(CodeDefs codeDefs){
        super(codeDefs.getDescription());
        this.codeDefs = codeDefs;
    }
}
