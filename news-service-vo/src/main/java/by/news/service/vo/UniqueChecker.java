package by.news.service.vo;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target( {ElementType.FIELD, ElementType.METHOD} )
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCheckerConstraintValidator.class)
@Documented
public @interface UniqueChecker {

    String message() default "{not unique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
