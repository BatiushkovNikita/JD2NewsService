package by.news.service.web.validator;

import by.news.service.vo.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserVO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "frag.userdata.first.name.error.input");
    }
}
