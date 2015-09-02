package by.news.service.daoh;


import by.news.service.daoh.impl.UserDao;
import by.news.service.daoh.interf.BaseDao;
import by.news.service.daoh.pojos.Role;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@DataSet("UserDaoTest.xml")
@JpaEntityManagerFactory(persistenceUnit = "test", configFile = "META-INF/persistence-test.xml")
public class UserDaoImplTest extends UnitilsJUnit4 {
    private Logger Log = LogManager.getLogger(UserDao.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    private BaseDao<UserVO, Integer> userDao;


    @Before
    public void setUp() {
        userDao = new UserDao();
        userDao.setEntityManager(JpaUnitils.getEntityManager());
        //JpaUnitils.injectEntityManagerInto(userDao);
        //entityManager.getTransaction().begin();

    }

    @After
    public void closeRes() {
        //entityManager.getTransaction().commit();
    }

    @Test
    public void test1() {
        UserVO userVO = userDao.getByPK(111);
        assertNotNull(userVO);
    }

    @Test
    public void test2() {
        UserVO userVO = userDao.getByPK(222);
        assertNotNull(userVO);
    }


 /*   @Test
    public void testTest() {
       UserVO userVO = null;
        try {
            entityManager.getTransaction().begin();
            userVO = userDao.getByPK(111);
            assertNotNull(userVO);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            Log.error("err111");
            entityManager.getTransaction().rollback();
        }
        //assertNotNull(userVO);
    }


    @Test
    public void testTest2() {
        UserVO userVO = null;
        try {
            entityManager.getTransaction().begin();
            userVO = userDao.getByPK(222);
            assertNotNull(userVO);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            Log.error("err222");
            entityManager.getTransaction().rollback();
        }
        //assertNotNull(userVO);
    }*/

/*    @Test
    public void testTest2() {
        UserVO userVO = userDao.getByPK(222);
        assertNotNull(userVO);
    }*/

/*    @Test
    //@Transactional(TransactionMode.DISABLED)
    public void testCreateUserVO() {
        UserVO userVO1 = new UserVO("email1", "password1", "firstname1", "lastname1", "1234567890");
        int result = 0;
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            entityManager.getTransaction().begin();
            result = userDao.create(userVO1);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Log.error("err");
        } finally {
            entityManager.close();
        }

        //result = userDao.create(userVO1);
        assertEquals(result, 0);
    }*/
}
