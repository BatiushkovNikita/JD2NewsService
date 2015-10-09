package by.news.service.daojpa;


import by.news.service.daojpa.config.DataConfig;
import by.news.service.daojpa.service.interf.UserService;
import by.news.service.vo.UserVO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        context.refresh();
        /*UserRepository bean = context.getBean(UserRepository.class);
        Iterable<User> all = bean.findAll();
        System.out.println(all);*/
        UserService bean = context.getBean(UserService.class);
        List<UserVO> all = bean.getAll();
        System.out.println(all);

    }
}
