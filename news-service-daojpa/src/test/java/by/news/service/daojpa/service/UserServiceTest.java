package by.news.service.daojpa.service;

import by.news.service.daojpa.pojos.Role;
import by.news.service.daojpa.pojos.User;
import by.news.service.daojpa.pojos.UserDetail;
import by.news.service.daojpa.repository.interf.UserRepository;
import by.news.service.daojpa.service.impl.UserServiceImpl;
import by.news.service.daojpa.service.interf.UserService;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserServiceTest.UserServiceTestContextConfiguration.class)
public class UserServiceTest {

    private Logger Log = LogManager.getLogger(UserServiceTest.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private UserVO userVO;
    private User user;

    @Before
    public void setUp() {
        int userDetailId = 1;
        String firstName = "FirstName";
        String lastName = "LastName";
        String cellphone = "1234567890";
        UserDetail userDetail = new UserDetail(userDetailId, firstName, lastName, cellphone);

        int userId = 12345;
        String email = "email1";
        String pass = "";
        user = new User(userId, email, pass);

        RoleVO roleVO = new RoleVO(3, "user");
        Set<RoleVO> rolesVO = new HashSet<>();
        rolesVO.add(roleVO);

        Role role = new Role(3, "user");
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        user.setUserDetail(userDetail);
        user.setRoles(roles);
        userVO = new UserVO(userId, email, pass, firstName, lastName, cellphone, rolesVO);
    }

    @Test
    public void testGetUserByPK() {
        Mockito.when(userRepository.findOne(user.getId())).thenReturn(user);
        UserVO userVO1 = userService.getUserByPK(user.getId());
        Assert.assertThat(userVO, new ReflectionEquals(userVO1));
    }

    @Test
    public void testCreateUser() {
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        int actual = userService.createUser(userVO);
        Assert.assertEquals(userVO.getId(), actual);
    }

    @Test
    public void testUpdateUser() {
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        userService.createUser(userVO);
    }

    @Configuration
    public class UserServiceTestContextConfiguration {
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
        @Bean
        public UserRepository userRepository() {
            return Mockito.mock(UserRepository.class);
        }
    }
}
