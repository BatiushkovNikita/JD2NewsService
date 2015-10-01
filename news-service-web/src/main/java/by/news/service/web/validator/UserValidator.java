package by.news.service.web.validator;

import by.news.service.daojpa.service.interf.UserService;
import by.news.service.service.interf.UserLocalService;
import by.news.service.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.inject.Inject;

@Component
public class UserValidator implements Validator {

    @Inject
    private UserLocalService userLocalService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserVO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserVO userVO = (UserVO) o;
        validateEmail(userVO, errors);
        validatePassword(userVO, errors);
        validateFirstName(userVO, errors);
        validateLastName(userVO, errors);
        validateCellPhone(userVO, errors);
    }

    private void validateEmail(UserVO userVO, Errors errors) {
        String email = userVO.getEmail();
        if (userLocalService.getUserByEmail(email) != null) {
            errors.rejectValue("email", "frag.userdata.email.error.alreadyInUse");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "frag.userdata.email.error.input");
    }

    private void validatePassword(UserVO userVO, Errors errors) {
        String passwordRegExp = "(?=.*\\d)(?=.*[A-z]).{6,20}";
        String password = userVO.getPassword();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "frag.userdata.password.error.input");
        if (!password.matches(passwordRegExp) && !StringUtils.isBlank(password)) {
            errors.rejectValue("password", "frag.userdata.password.error.not.secure");
        }
    }

    private void validateFirstName(UserVO userVO, Errors errors) {
        String firstName = userVO.getFirstName();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "frag.userdata.firstName.error.input");
    }

    private void validateLastName(UserVO userVO, Errors errors) {
        String lastName = userVO.getFirstName();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "frag.userdata.lastName.error.input");
    }

    private void validateCellPhone(UserVO userVO, Errors errors) {
        String cellPhoneRegExp = "(\\d+)";
        String cellPhone = userVO.getCellPhone();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cellPhone", "frag.userdata.cellPhone.error.input");
        if (!cellPhone.matches(cellPhoneRegExp) && !StringUtils.isBlank(cellPhone)) {
            errors.rejectValue("cellPhone", "frag.userdata.cellPhone.error.not.valid");
        }
    }
}
