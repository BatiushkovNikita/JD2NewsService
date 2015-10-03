package by.news.service.web.config;

import by.news.service.web.validator.impl.AbstractValidator;
import by.news.service.web.validator.impl.UserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

@Configuration
public class Beans {

    @Bean
    public AbstractValidator userValidator() {
        return new UserValidator();
    }

    @Bean
    public javax.validation.Validator validator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.usingContext().getValidator();
    }
}
