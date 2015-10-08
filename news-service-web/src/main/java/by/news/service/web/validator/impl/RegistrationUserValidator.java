package by.news.service.web.validator.impl;

import by.news.service.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.Errors;

import javax.inject.Inject;

public class RegistrationUserValidator extends UserValidator {

    @Inject
    UserDetailsService userDetailsService;

    public void validate(Object o, Errors errors) {
        UserVO userVO = (UserVO) o;
        String email = userVO.getEmail();
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        if (userDetails != null ) {
            errors.rejectValue("email", "frag.userdata.email.error.alreadyInUse");
        }
        super.validate(o, errors);
    }
}
