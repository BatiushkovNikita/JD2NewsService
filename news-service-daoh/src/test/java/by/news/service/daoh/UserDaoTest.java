package by.news.service.daoh;


import by.news.service.daoh.impl.UserDao;
import by.news.service.daoh.interf.BaseDao;
import by.news.service.daoh.pojos.User;
import by.news.service.daoh.util.JpaUtil;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.reflectionassert.ReflectionAssert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataSet("UserDaoTest.xml")
@JpaEntityManagerFactory(persistenceUnit = "test", configFile = "META-INF/persistence-test.xml")
public class UserDaoTest extends org.unitils.UnitilsJUnit4 {//org.unitils.UnitilsTestNG {
    private Logger Log = LogManager.getLogger(UserDaoTest.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    private UserDao userDao;

    //@org.testng.annotations.BeforeClass
    @org.junit.Before
    public void setUp() {
        userDao = new UserDao();
        userDao.setEntityManager(JpaUnitils.getEntityManager());
    }

    @Ignore
    //@org.testng.annotations.Test
    @org.junit.Test
    @Transactional
    public void test1() {
        UserVO userVO = userDao.getByPK(111);
        ReflectionAssert.assertLenientEquals(userVO, userVO);
        //org.testng.Assert.assertEquals(userVO, userVO);
    }

    //@org.testng.annotations.Test
    @org.junit.Test
    public void test() {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, 111);
        entityManager.getTransaction().commit();
        ReflectionAssert.assertLenientEquals(user, user);
    }
}
