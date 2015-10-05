package by.news.service.service.config;

import by.news.service.daojpa.config.DataConfig;
import by.news.service.service.annotations.BenchmarkMethodsAnnotationBeanPostProcessor;
import by.news.service.service.impl.NewsLocalServiceImpl;
import by.news.service.service.impl.TagLocalServiceImpl;
import by.news.service.service.impl.UserLocalServiceImpl;
import by.news.service.service.impl.UserDetailsServiceImpl;
import by.news.service.service.interf.NewsLocalService;
import by.news.service.service.interf.TagLocalService;
import by.news.service.service.interf.UserLocalService;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan(basePackages = {"by.news.service.service"})
@Import(DataConfig.class)
public class ServiceConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public NewsLocalService newsLocalService() {
        return new NewsLocalServiceImpl();
    }

    @Bean
    public UserLocalService userLocalService() {
        return new UserLocalServiceImpl();
    }

    @Bean
    public TagLocalService tagLocalService() {
        return new TagLocalServiceImpl();
    }

    @Bean
    public BeanPostProcessor benchmarkMethodsAnnotationBeanPostProcessor() {
        return new BenchmarkMethodsAnnotationBeanPostProcessor();
    }
}
