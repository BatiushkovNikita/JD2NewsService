package by.news.service.daoh;


import by.news.service.daoh.impl.UserDao;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.reflectionassert.ReflectionAssert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@DataSet("UserDaoTest.xml")
@RunWith(UnitilsJUnit4TestClassRunner.class)
public class UserDaoTest {
    private Logger Log = LogManager.getLogger(UserDaoTest.class.getName());

    @PersistenceContext
    @InjectIntoByType
    private EntityManager entityManager;

    @TestedObject
    private UserDao userDao;

    @JpaEntityManagerFactory(persistenceUnit = "test", configFile = "META-INF/persistence-test.xml")
    @Before
    public void setUp() {
        userDao = new UserDao();
        JpaUnitils.injectEntityManagerInto(userDao);
    }

    @After
    public void tearDown() {
        entityManager.close();
    }

    @Ignore
    @Test
    public void testGetByKey() {
        int id = 111;
        UserVO expectedUserVO = new UserVO("email1", null, "FirstName1", "LastName1", "1234567890");
        RoleVO roleVO = new RoleVO(1, "user");
        Set<RoleVO> rolesVO = new HashSet<>();
        rolesVO.add(roleVO);
        expectedUserVO.setRoles(rolesVO);
        expectedUserVO.setId(id);
        UserVO userVO = userDao.getByPK(id);
        ReflectionAssert.assertLenientEquals(expectedUserVO, userVO);
    }

    @Ignore
    @Test
    public void testGetByKeyNull() {
        UserVO userVO = userDao.getByPK(9922);
        ReflectionAssert.assertLenientEquals(null, userVO);
        Assert.assertNull(userVO);
    }

    @Ignore
    @Test
    public void testCreatingUser() {
        int expectedId = 12345;
        UserVO userVO = new UserVO("email1", "password1", "FirstName1", "LastName1", "1234567890");
        userVO.setId(expectedId);
        int id = userDao.create(userVO);
        Assert.assertEquals(expectedId, id);
    }
}
