package by.news.service.service.impl;


import by.news.service.service.config.ServiceConfig;
import by.news.service.service.interf.SecurityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        SecurityService bean = context.getBean(SecurityService.class);
        bean.getUser(1);
    }
}
