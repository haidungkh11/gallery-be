/**
 * 
 */
package vtb.itd.cba.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author DuongNT
 * Helper to simplify accessing i18n messages in code.
 * This finds messages automatically found from src/main/resources/i18n/* (files named messages_*.properties)
 * 
 */
@Component
public class Messagei18n {

    @Autowired
    private MessageSource messageSource;
    public String get(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

}