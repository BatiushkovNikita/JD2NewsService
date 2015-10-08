package by.news.service.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

    private Logger Log = LogManager.getLogger(SecurityController.class.getName());

    @RequestMapping(value = "/accessdenied", method = {RequestMethod.GET, RequestMethod.POST})
    public String viewAccessDeniedPage() {
        return "errors/accessdenied";
    }
}
