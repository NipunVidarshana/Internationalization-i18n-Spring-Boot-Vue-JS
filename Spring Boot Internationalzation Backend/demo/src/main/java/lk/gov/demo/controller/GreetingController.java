package lk.gov.demo.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GreetingController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/greeting", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    @JsonIgnore
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model, Locale locale) {
        String greetingMessage = messageSource.getMessage("greeting.message", new Object[]{name}, locale);
        return greetingMessage;
    }
}
