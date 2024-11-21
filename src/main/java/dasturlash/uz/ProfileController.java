package dasturlash.uz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ResourceBundleService messageService;

    @RequestMapping("/not-found")
    public String usingLocal(@RequestHeader(value = "Accept-Language", defaultValue = "UZ") AppLanguage language) {
        return messageService.getMessage("user.not.found", language);
    }
}
