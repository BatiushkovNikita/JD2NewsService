package by.news.service.daojpa;

import by.news.service.daojpa.config.DataConfig;
import by.news.service.daojpa.pojos.Role;
import by.news.service.daojpa.pojos.User;
import by.news.service.daojpa.pojos.UserDetail;
import by.news.service.daojpa.repository.interf.UserRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import javassist.expr.Cast;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dbunit.dataset.ITable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.HashSet;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:UserRepoTest.xml")
public class UserRepositoryTest {

    private Logger Log = LogManager.getLogger(UserRepositoryTest.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {

    }

    @Test
    public void testGetUserByPK() {
        User user = userRepository.findOne(111);
        Assert.assertNotNull(user);
        UserDetail userDetail = new UserDetail(1, "FirstName1", "LastName1", "1234567890");
        Assert.assertEquals(userDetail, user.getUserDetail());
        Set<Role> roles = new HashSet<>();
        Role role1 = new Role(1, "user");
        Role role2 = new Role(2, "moderator");
        roles.add(role1);
        roles.add(role2);
        Assert.assertEquals(roles, user.getRoles());
    }

    @Test
    public void testCreateUser() {
        UserDetail userDetail = new UserDetail("FirstName3", "LastName3", "12345");
        User user = new User(333, "email3", "password3");
        Role role = new Role(1, "user");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setUserDetail(userDetail);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Test
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT,
            value = "classpath:UserRepoTestExpected.xml")
    public void testUpdateUser() {
        User user = userRepository.findOne(222);
        user.setEmail("updatedEmail");
        user.setPassword("updatedPassword");
        UserDetail userDetail = user.getUserDetail();
        userDetail.setLastName("updatedLastName");
        user.setUserDetail(userDetail);
        userRepository.save(user);
    }

    @Test
    public  void testGetAllUsers() {
        Iterable<User> users = userRepository.findAll();
        int count = 0;
        for (User user : users) {
            count++;
        }
        Assert.assertEquals(2, count);
    }
}
