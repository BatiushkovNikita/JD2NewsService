package by.news.service.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
/*        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Initializer.class);
        TagLocalService bean = context.getBean(TagLocalService.class);
        Set<TagVO> allTags = bean.getAllTags();
        System.out.println(allTags);*/

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String user = bCryptPasswordEncoder.encode("root");
        System.out.println(user);
    }
}
