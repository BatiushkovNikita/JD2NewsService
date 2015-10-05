package by.news.service.web;

import by.news.service.service.impl.TagLocalServiceImpl;
import by.news.service.service.interf.TagLocalService;
import by.news.service.vo.TagVO;
import by.news.service.web.config.Beans;
import by.news.service.web.config.Initializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Initializer.class);
        TagLocalService bean = context.getBean(TagLocalService.class);
        Set<TagVO> allTags = bean.getAllTags();
        System.out.println(allTags);
    }
}
