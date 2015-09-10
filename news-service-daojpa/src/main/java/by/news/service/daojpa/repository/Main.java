package by.news.service.daojpa.repository;

import by.news.service.daojpa.config.AppInitializer;
import by.news.service.daojpa.config.DataConfig;
import by.news.service.daojpa.pojos.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Main {
    public static void main(String[] args) {
/*        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);*/

        UserRepository userRepository = new UserRepository();
        userRepository.findUser(1);

    }
}
