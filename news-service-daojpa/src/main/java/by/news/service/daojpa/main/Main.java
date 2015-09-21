package by.news.service.daojpa.main;

import by.news.service.daojpa.config.Beans;
import by.news.service.daojpa.config.DataConfig;
import by.news.service.daojpa.service.interf.NewsService;
import by.news.service.vo.NewsVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class, Beans.class);
        NewsService bean = context.getBean(NewsService.class);
        NewsVO newsByPK = bean.getNewsByPK(1);
        System.out.println(newsByPK);
    }
}
