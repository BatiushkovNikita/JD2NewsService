package by.news.service.web.controller;

import by.news.service.service.interf.UserLocalService;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Controller
public class UserController {

    private Logger Log = LogManager.getLogger(UserController.class.getName());


    private javax.validation.Validator validator;

    public UserController() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Inject
    private UserLocalService userLocalService;

/*    @Inject
    private Validator userValidator;*/

/*    @Inject
    private CustomUserValidator customUserValidator;*/

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        model.addAttribute("userAttribute", new UserVO());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userAttribute") UserVO userVO,
                               BindingResult result, SessionStatus status) {

        Set<ConstraintViolation<UserVO>> violations = validator.validate(userVO);
        Log.error("Find " + violations.size() + " errrors");
        for (ConstraintViolation<UserVO> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            result.addError(new FieldError("userAttribute", propertyPath, message));
        }

        if (result.hasErrors()) {
            return "registration";
        }
        status.setComplete();
        return "redirect:/newsfeed";

        //customUserValidator.validate(userVO, result);

        //userValidator.validate(userVO, result);
       /* if (result.hasErrors()) {
            return new ModelAndView("registration", "userAttribute", userVO);
        } else {
            status.setComplete();
            userLocalService.registerUser(userVO);
        }
        return new ModelAndView("redirect:/newsfeed", "userAttribute", userVO);*/

       /* Log.debug("Validation form input");
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
        return new ModelAndView("redirect:/newsfeed", "userAttribute", userVO);*/
    }
}