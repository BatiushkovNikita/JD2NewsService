package by.news.service.service.impl;


import by.news.service.service.config.ServiceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        SecurityServiceImpl bean = context.getBean(SecurityServiceImpl.class);
        bean.getUser(1);
    }
}
