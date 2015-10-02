package by.news.service.web.validator;

import by.news.service.vo.UserVO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class CustomUserValidator implements InitializingBean, org.springframework.validation.Validator {

    private Validator validator;

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserVO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserVO userVO = (UserVO) o;
        Set<ConstraintViolation<UserVO>> constraintViolations = validator.validate(userVO);
        for (ConstraintViolation<UserVO> constraintViolation : constraintViolations) {
            String propertyPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.rejectValue(propertyPath, message);
        }
       /* for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            String propertyPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.rejectValue(propertyPath, "", message);
        }*/
    }
}
