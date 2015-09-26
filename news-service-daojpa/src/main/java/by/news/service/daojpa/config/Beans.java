package by.news.service.daojpa.config;

import by.news.service.daojpa.service.impl.NewsServiceImpl;
import by.news.service.daojpa.service.impl.TagServiceImpl;
import by.news.service.daojpa.service.impl.UserServiceImpl;
import by.news.service.daojpa.service.interf.NewsService;
import by.news.service.daojpa.service.interf.TagService;
import by.news.service.daojpa.service.interf.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public NewsService newsService() {
        return new NewsServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public TagService tagService() {
        return new TagServiceImpl();
    }
}
