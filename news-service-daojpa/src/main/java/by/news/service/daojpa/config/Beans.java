package by.news.service.daojpa.config;

import by.news.service.daojpa.exp.BenchmarkMethodsAnnotationBeanPostProcessor;
import by.news.service.daojpa.service.impl.NewsServiceImpl;
import by.news.service.daojpa.service.interf.NewsService;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public NewsService newsServiceImpl() {
        return new NewsServiceImpl();
    }

    @Bean
    public BeanPostProcessor benchmarkMethodsAnnotationBeanPostProcessor() {
        return new BenchmarkMethodsAnnotationBeanPostProcessor();
    }
}
