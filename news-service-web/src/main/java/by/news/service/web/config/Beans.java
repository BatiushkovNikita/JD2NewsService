package by.news.service.web.config;

import by.news.service.web.validator.UserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public UserValidator userValidator() {
        return new UserValidator();
    }
}
