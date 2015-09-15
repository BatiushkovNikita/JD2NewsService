package by.news.service.daojpa;

import by.news.service.daojpa.service.impl.UserServiceImpl;
import by.news.service.daojpa.service.interf.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ComponentScan("by.news.service.daojpa")
public class TestService {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }


}
