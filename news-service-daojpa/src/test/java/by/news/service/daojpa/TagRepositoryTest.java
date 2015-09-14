package by.news.service.daojpa;

import by.news.service.daojpa.pojos.News;
import by.news.service.daojpa.repository.interf.TagRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:TagRepoTest.xml")
public class TagRepositoryTest {

    private Logger Log = LogManager.getLogger(UserRepositoryTest.class.getName());

    @Autowired
    TagRepository tagRepository;

    @Test
    public void testGetNewsByTag() {
        List newses1 = tagRepository.findByTag("sport");
        Assert.assertEquals(3, newses1.size());
        List newses2 = tagRepository.findByTag("finance");
        Assert.assertEquals(0, newses2.size());
    }
}

