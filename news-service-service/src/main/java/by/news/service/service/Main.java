package by.news.service.service;

import by.news.service.service.config.ServiceConfig;
import by.news.service.service.interf.TagLocalService;
import by.news.service.vo.TagVO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        TagLocalService bean = context.getBean(TagLocalService.class);
        List<TagVO> allTags = bean.getAllTags();
        System.out.println(allTags);
    }
}
