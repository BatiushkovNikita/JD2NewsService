package by.news.service.vo;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCheckerConstraintValidator implements ConstraintValidator<UniqueChecker, String> {

    @Override
    public void initialize(UniqueChecker uniqueChecker) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return true;
    }
}
