package dasturlash.uz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/simple")
    public String simpleTest() {
        return messageSource.getMessage("user.not.found", null, new Locale("uz"));
    }

    @RequestMapping("/using")
    public String usingLocal(@RequestHeader(value = "Accept-Language", defaultValue = "UZ") AppLanguage language) {
        return messageSource.getMessage("user.not.found", null, new Locale(language.name()));
    }

}
