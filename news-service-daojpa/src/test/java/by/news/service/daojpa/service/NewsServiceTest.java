package by.news.service.daojpa.service;

import by.news.service.daojpa.pojos.News;
import by.news.service.daojpa.pojos.Tag;
import by.news.service.daojpa.pojos.User;
import by.news.service.daojpa.pojos.UserDetail;
import by.news.service.daojpa.repository.NewsRepository;
import by.news.service.daojpa.service.impl.NewsServiceImpl;
import by.news.service.daojpa.service.interf.NewsService;
import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NewsServiceTest.NewsServiceTestContextConfiguration.class)
public class NewsServiceTest {

    private Logger Log = LogManager.getLogger(NewsServiceTest.class.getName());

    @Inject
    private NewsService newsService;

    @Inject
    private NewsRepository newsRepository;

    private News news;
    private NewsVO newsVO;

    @Before
    public void setUp() {
        int userId = 12345;
        String email = "email1";
        String pass = "";
        User user = new User(userId, email, pass);

        int userDetailId = 1;
        String firstName = "FirstName";
        String lastName = "LastName";
        String cellphone = "1234567890";
        UserDetail userDetail = new UserDetail(userDetailId, firstName, lastName, cellphone);
        user.setUserDetail(userDetail);

        int newsId = 54321;
        String topic = "Topic1";
        String publicationDate = "2015-09-01 16:37:00";
        String newsText = "Text1";
        news = new News(newsId, topic, publicationDate, newsText, user.getId());

        Tag tag1 = new Tag(1, "tag1");
        Tag tag2 = new Tag(2, "tag2");
        Set<Tag> tags = new HashSet<>();
        tags.add(tag1);
        tags.add(tag2);

        news.setTags(tags);
        news.setUser(user);

        TagVO tagVO1 = new TagVO(1, "tag1");
        TagVO tagVO2 = new TagVO(2, "tag2");
        Set<TagVO> tagsVO = new HashSet<>();
        tagsVO.add(tagVO1);
        tagsVO.add(tagVO2);

        String authorFirstName = user.getUserDetail().getFirstName();
        String authorLastName = user.getUserDetail().getLastName();

        newsVO = new NewsVO(newsId, topic, publicationDate, newsText, authorFirstName, authorLastName, tagsVO);
    }

    @Test
    public void testGetNewsByPK() {
        Mockito.when(newsRepository.findOne(news.getId())).thenReturn(news);
        NewsVO newsVO1 = newsService.getNewsByPK(news.getId());
        Assert.assertThat(newsVO, new ReflectionEquals(newsVO1));
    }

    @Test
    public void testCreateNews() {
        Mockito.when(newsRepository.save(Mockito.any(News.class))).thenReturn(news);
        int actual = newsService.createNews(newsVO);
        Assert.assertEquals(newsVO.getId(), actual);
    }

    @Test
    public void testUpdateNews() {
        Mockito.when(newsRepository.save(Mockito.any(News.class))).thenReturn(news);
        newsService.updateNews(newsVO);
    }

    @Test
    public void testDeleteNews() {
        newsService.deleteNews(newsVO.getId());
    }

    @Test
    public void testGetAll() {
        List<News> newses = new ArrayList<>();
        newses.add(news);
        newses.add(news);
        Mockito.when(newsRepository.findAll()).thenReturn(newses);
        List<NewsVO> newsVOs = newsService.getAll();
        Assert.assertEquals(newses.size(), newsVOs.size());
    }

    @Configuration
    static class NewsServiceTestContextConfiguration {
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
