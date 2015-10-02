package by.news.service.web.controller;

import by.news.service.vo.UserVO;
import by.news.service.web.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class UserController {

    private Logger Log = LogManager.getLogger(UserController.class.getName());

    @Inject
    private UserValidator userValidator;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        model.addAttribute("userAttribute", new UserVO());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("userAttribute") UserVO userVO,
                               BindingResult result, SessionStatus status, Errors errors) {
        userValidator.validate(userVO, errors);
        if (result.hasErrors()) {
            return new ModelAndView("registration", "userAttribute", userVO);
        }
        status.setComplete();
        return new ModelAndView("redirect:/newsfeed", "userAttribute", userVO);

    }
}