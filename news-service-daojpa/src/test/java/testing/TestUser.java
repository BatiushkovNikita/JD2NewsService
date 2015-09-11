package testing;

import by.news.service.daojpa.config.DataConfig;
import by.news.service.daojpa.pojos.User;
import by.news.service.daojpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@Transactional
public class TestUser {

    @Autowired
    private UserRepository userRepository;

/*    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Before
    @Rollback(false)
    public void setUp() {
        User user = new User();
        user.setId(1);
        user.setEmail("email");
        user.setPassword("pass");
        userRepository.save(Arrays.asList(user));
    }

    @Test
    public void test() {
        User user = userRepository.findUser(1);
        Assert.assertNotNull(user);
    }


}
