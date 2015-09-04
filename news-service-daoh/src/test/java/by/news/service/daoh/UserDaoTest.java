package by.news.service.daoh;


import by.news.service.daoh.impl.UserDao;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.reflectionassert.ReflectionAssert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataSet("UserDaoTest.xml")
@JpaEntityManagerFactory(persistenceUnit = "test2", configFile = "META-INF/persistence-test2.xml")
public class UserDaoTest extends org.unitils.UnitilsJUnit4 {
    private Logger Log = LogManager.getLogger(UserDaoTest.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    private UserDao userDao;


    @Before
    public void setUp() {
        userDao = new UserDao();
        userDao.setEntityManager(JpaUnitils.getEntityManager());
        //JpaUnitils.injectEntityManagerInto(userDao);
    }

    @After
    public void tearDown() {
        entityManager.close();
    }


    @Test
    public void test1() {
        UserVO userVO = userDao.getByPK(111);
        ReflectionAssert.assertLenientEquals(userVO, userVO);
    }


    @Test
    public void test3() {
        UserVO userVO = userDao.getByPK(111);
        ReflectionAssert.assertLenientEquals(userVO, userVO);
    }
}
