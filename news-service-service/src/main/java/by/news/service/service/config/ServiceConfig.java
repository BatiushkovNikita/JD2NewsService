package by.news.service.service.config;

import by.news.service.daojpa.config.DataConfig;
import by.news.service.service.annotations.BenchmarkMethodsAnnotationBeanPostProcessor;
import by.news.service.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@ComponentScan(basePackages = {"by.news.service.service"})
@Import(DataConfig.class)
public class ServiceConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BeanPostProcessor benchmarkMethodsAnnotationBeanPostProcessor() {
        return new BenchmarkMethodsAnnotationBeanPostProcessor();
    }
}
