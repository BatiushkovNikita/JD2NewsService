package by.news.service.daojpa.service;

import by.news.service.daojpa.pojos.News;
import by.news.service.daojpa.pojos.Tag;
import by.news.service.daojpa.pojos.User;
import by.news.service.daojpa.pojos.UserDetail;
import by.news.service.daojpa.repository.TagRepository;
import by.news.service.daojpa.service.impl.TagServiceImpl;
import by.news.service.daojpa.service.interf.TagService;
import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TagServiceTest.TagServiceTestContextConfiguration.class)
public class TagServiceTest {

    private Logger Log = LogManager.getLogger(TagServiceTest.class.getName());

    @Inject
    private TagService tagService;

    @Inject
    private TagRepository tagRepository;

    private List<News> newsList = new ArrayList<>();

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
        News news = new News(newsId, topic, publicationDate, newsText, user.getId());
        news.setUser(user);
        newsList.add(news);
        newsList.add(news);
    }

    @Test
    public void testGetAllTags() {
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(1, "tagName1"));
        tags.add(new Tag(2, "tagName2"));
        Mockito.when(tagRepository.findAll()).thenReturn(tags);
        List<TagVO> tagsListVO = tagService.getAll();
        Assert.assertEquals(tagsListVO.size(), 2);
    }

    @Test
    public void testGetNewsByTag() {
        String tagName = "tagName1";
        Mockito.when(tagRepository.findByTag(Mockito.anyString())).thenReturn(newsList);
        List<NewsVO> newsVOs = tagService.getNewsByTag(tagName);
        Assert.assertEquals(newsList.size(), newsVOs.size());
    }

    @Configuration
    static class TagServiceTestContextConfiguration {
        @Bean
        public TagService newsService() {
            return new TagServiceImpl();
        }

        @Bean
        public TagRepository tagRepository() {
            return Mockito.mock(TagRepository.class);
        }
    }
}
