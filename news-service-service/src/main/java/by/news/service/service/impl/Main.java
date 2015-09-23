package by.news.service.service.impl;


import by.news.service.service.config.ServiceConfig;
import by.news.service.service.security.UserSecurityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        UserSecurityService bean = context.getBean(UserSecurityService.class);
        UserDetails email1 = bean.loadUserByUsername("email1");
        System.out.println(email1);
    }
}
