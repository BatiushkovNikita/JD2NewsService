package by.news.service.web.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    private Logger Log = LogManager.getLogger(ErrorController.class.getName());

    @RequestMapping(value="/error")
    public String handle(HttpServletRequest request, ModelAndView model) {
        Object statusCode = request.getAttribute("javax.servlet.error.status_code");
        Log.error("Server return error: " + statusCode.toString());
        request.setAttribute("status", statusCode);
        request.setAttribute("reason", request.getAttribute("javax.servlet.error.message"));
        request.setAttribute("errorUri", request.getAttribute("javax.servlet.error.request_uri"));
        return "/errors/error";
    }
}
