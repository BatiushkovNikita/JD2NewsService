package by.news.service.daoh;


import by.news.service.daoh.impl.UserDao;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.reflectionassert.ReflectionAssert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@DataSet("UserDaoTest.xml")
@RunWith(UnitilsJUnit4TestClassRunner.class)
public class SimpleTest {
    private Logger Log = LogManager.getLogger(SimpleTest.class.getName());

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private UserDao userDao;

    @Before
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test2");
        entityManager = entityManagerFactory.createEntityManager();
        userDao = new UserDao();
        userDao.setEntityManager(entityManager);
    }

    @After
    public void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test1() {
        UserVO userVO = userDao.getByPK(111);
        ReflectionAssert.assertLenientEquals(userVO, userVO);
    }

    @Test
    public void test3() {
        UserVO userVO = userDao.getByPK(222);
        ReflectionAssert.assertLenientEquals(userVO, userVO);
    }
}

