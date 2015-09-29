package by.news.service.web.validator;

import by.news.service.vo.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private String passwordRegExp = "((?=.*\\d).{3,20})";
    private String cellPhoneRegExp = "(\\d+)";

    @Override
    public boolean supports(Class<?> aClass) {
        return UserVO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserVO userVO = (UserVO) o;
        if (!userVO.getPassword().matches(passwordRegExp)) {
            errors.rejectValue("password", "frag.userdata.password.error.not.secure");
        } else {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "frag.userdata.password.error.input");
        }
        if (!userVO.getCellPhone().matches(cellPhoneRegExp)) {
            errors.rejectValue("cellPhone", "frag.userdata.cellPhone.error.not.valid");
        } else {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cellPhone", "frag.userdata.cellPhone.error.input");
        }
       /* if (!userVO.getEmail().;)*/
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "frag.userdata.email.error.input");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "frag.userdata.firstName.error.input");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "frag.userdata.lastName.error.input");
    }
}
