package by.news.service.web.controller;

import by.news.service.service.interf.UserLocalService;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
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
    private UserLocalService userLocalService;

    @Inject
    private Validator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        model.addAttribute("userAttribute", new UserVO());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("userAttribute") UserVO userVO,
                               BindingResult result, SessionStatus status) {

/*        if (result.hasErrors()) {

        }*/

        Log.debug("Validation form input");
        userValidator.validate(userVO, result);
        if (result.hasErrors()) {
            Log.debug("Validation failed");
            return new ModelAndView("registration", "userAttribute", userVO);
        } else {
            Log.debug("Validation passed");
            status.setComplete();
            Log.debug("Register user");
            userLocalService.registerUser(userVO);
        }
        Log.debug("Registration complete");
        return new ModelAndView("redirect:/newsfeed", "userAttribute", userVO);
    }
}