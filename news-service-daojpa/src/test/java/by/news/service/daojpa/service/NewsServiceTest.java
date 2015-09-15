package by.news.service.daojpa.service;

import by.news.service.daojpa.repository.interf.NewsRepository;
import by.news.service.daojpa.service.impl.NewsServiceImpl;
import by.news.service.daojpa.service.interf.NewsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NewsServiceTest.NewsServiceTestContextConfiguration.class)
public class NewsServiceTest {

    private Logger Log = LogManager.getLogger(NewsServiceTest.class.getName());

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsRepository newsRepository;

    @Configuration
    private class NewsServiceTestContextConfiguration {
        @Bean
        public NewsService newsService() {
            return new NewsServiceImpl();
        }
        @Bean
        public NewsRepository newsRepository() {
            return Mockito.mock(NewsRepository.class);
        }
    }
}
