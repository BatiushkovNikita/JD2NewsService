package by.news.service.daojpa.config;

import by.news.service.daojpa.exp.BenchmarkMethodsAnnotationBeanPostProcessor;
import by.news.service.daojpa.service.impl.NewsServiceImpl;
import by.news.service.daojpa.service.impl.UserServiceImpl;
import by.news.service.daojpa.service.interf.NewsService;
import by.news.service.daojpa.service.interf.UserService;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class Beans {

    @Bean
    public NewsService newsServiceImpl() {
        return new NewsServiceImpl();
    }

/*    @Bean
    public UserService userServiceImpl() {
        return new UserServiceImpl();
    }*/

    @Bean
    public BeanPostProcessor benchmarkMethodsAnnotationBeanPostProcessor() {
        return new BenchmarkMethodsAnnotationBeanPostProcessor();
    }
}
