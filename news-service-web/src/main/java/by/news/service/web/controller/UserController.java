package by.news.service.web.controller;

import by.news.service.daojpa.pojos.User;
import by.news.service.service.interf.UserLocalService;
import by.news.service.vo.UserVO;
import by.news.service.web.validator.impl.AbstractValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class UserController {

    private Logger Log = LogManager.getLogger(UserController.class.getName());

    @Inject
    private AbstractValidator userValidator;

    @Inject
    private AbstractValidator registrationUserValidator;

    @Inject
    private UserLocalService userLocalService;

    @Inject
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        model.addAttribute("userVOParam", new UserVO());
        return "registration";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("userVOParam") UserVO userVO,
                                     BindingResult result, SessionStatus status, Errors errors) {
        registrationUserValidator.validate(userVO, errors);
        if (result.hasErrors()) {
            return new ModelAndView("registration", "userVOParam", userVO);
        } else {
            String encodePassword = passwordEncoder.encode(userVO.getPassword());
            userVO.setPassword(encodePassword);
            userLocalService.registerUser(userVO);
            status.setComplete();
        }
        return new ModelAndView("redirect:/login", "userVOParam", userVO);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String viewUserProfile(Model model, @AuthenticationPrincipal UserVO userVO) {
        model.addAttribute("userVOParam", userVO);
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("userVOParam") UserVO userVO,
                                     BindingResult result, SessionStatus status, Errors errors,
                                     @AuthenticationPrincipal UserVO currentUser) {
        String field = errors.getFieldError().getField();
        Log.error("Field: " + field);
        //userVO.setEmail(currentUser.getEmail());
        Log.error("email: " + currentUser.getEmail());
        //userVO.setPassword(currentUser.getPassword());
        Log.error("pass" + currentUser.getPassword());
/*        currentUser.setFirstName(userVO.getFirstName());
        currentUser.setLastName(userVO.getLastName());
        currentUser.setCellPhone(userVO.getCellPhone());*/
        userValidator.validate(userVO, errors);
        if (result.hasErrors()) {
            Log.error("Errors: " + errors.getAllErrors());
            return new ModelAndView("profile", "userVOParam", userVO);
        } else {
            userLocalService.editUser(userVO);
            status.setComplete();
        }
        return new ModelAndView("redirect:/newsfeed", "userVOParam", userVO);
    }

    @RequestMapping(value = "/userslist", method = RequestMethod.GET)
    public String viewAllUsers(Model model) {
        model.addAttribute("usersList", userLocalService.getAllUsers());
        return "userslist";
    }
}