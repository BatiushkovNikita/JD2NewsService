package by.news.service.web.config;

import by.news.service.web.service.DefaultRolesPrefixPostProcessor;
import by.news.service.web.validator.impl.AbstractValidator;
import by.news.service.web.validator.impl.NewsValidator;
import by.news.service.web.validator.impl.UserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Validator;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

@Configuration
public class Beans {

    @Bean
    public AbstractValidator userValidator() {
        return new UserValidator();
    }

    @Bean
    public AbstractValidator newsValidator() {
        return new NewsValidator();
    }

    @Bean
    public javax.validation.Validator validator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.usingContext().getValidator();
    }

    @Bean
    public DefaultRolesPrefixPostProcessor defaultRolesPrefixPostProcessor() {
        return new DefaultRolesPrefixPostProcessor();
    }

    @Bean(name = "passwordEncoder")
    public BCryptPasswordEncoder passwordEncoder() throws Exception {
        return new BCryptPasswordEncoder();
    }
}
