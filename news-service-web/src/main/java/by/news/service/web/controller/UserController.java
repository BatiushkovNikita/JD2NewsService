package by.news.service.web.controller;

import by.news.service.service.interf.UserLocalService;
import by.news.service.vo.UserVO;
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

    @Inject
    private UserLocalService userLocalService;

    @Inject
    private Validator validator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        model.addAttribute("userAttribute", new UserVO());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("userAttribute") UserVO userVO,
                               BindingResult result, SessionStatus status) {
        validator.validate(userVO, result);
        if (result.hasErrors()) {
            return new ModelAndView("registration", "userAttribute", userVO);
        } else {
            status.setComplete();
            userLocalService.registerUser(userVO);
        }
        return new ModelAndView("redirect:/newsfeed", "userAttribute", userVO);
    }
}