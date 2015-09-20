package by.news.service.daojpa.repository;

import by.news.service.daojpa.config.TestConfig;
import by.news.service.daojpa.pojos.News;
import by.news.service.daojpa.pojos.Tag;
import by.news.service.daojpa.pojos.User;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:NewsRepoTest.xml")
public class NewsRepositoryTest {

    private Logger Log = LogManager.getLogger(NewsRepositoryTest.class.getName());

    @Inject
    private NewsRepository newsRepository;

    @Test
    public void testGetNewsByPK() {
        News news = newsRepository.findOne(2);
        Assert.assertNotNull(news);
        int expectedUserId = 111;
        Set<Tag> tags = new HashSet<>();
        tags.add(new Tag(1, "TagName1"));
        tags.add(new Tag(2, "TagName2"));
        tags.add(new Tag(3, "TagName3"));
        Assert.assertEquals(tags, news.getTags());
        Assert.assertSame(expectedUserId, news.getUser().getId());
    }

    @Test
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT,
            value = "classpath:NewsRepoTestExpected.xml")
    public void testUpdateNews() {
        News news = newsRepository.findOne(1);
        news.setTopic("updatedTopic");
        news.setNewsText("updatedText");
        Set<Tag> tags = news.getTags();
        tags.add(new Tag(2, "TagName2"));
        Log.error(tags);
        news.setTags(tags);
        newsRepository.save(news);
    }

    @Test
    public void testCreateNews() {
        User user = new User(111, "email1", "password1");
        Set<Tag> tags = new HashSet<>();
        tags.add(new Tag(1, "TagName1"));
        tags.add(new Tag(2, "TagName2"));
        News news = new News(3, "Topic3", "2013-03-03 13:33:33", "Text3", 111);
        news.setTags(tags);
        news.setUser(user);
        newsRepository.save(news);
    }

    @Test
    public void testGetAllNews() {
        Iterator<News> iterator = newsRepository.findAll().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        Assert.assertEquals(2, count);
    }

    @Test
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT,
            value = "classpath:NewsRepoTestExpectedDel.xml")
    public void testDeleteNews() {
        News news = newsRepository.findOne(2);
        newsRepository.delete(news);
    }
}
