package by.news.service.daoh;


import by.news.service.daoh.impl.UserDao;
import by.news.service.daoh.interf.BaseDao;
import by.news.service.vo.UserVO;
import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertNotNull;

@DataSet("UserDaoTest.xml")
@JpaEntityManagerFactory(persistenceUnit = "test", configFile = "META-INF/persistence-test.xml")
public class UserDaoImplTest extends UnitilsJUnit4 {

    @PersistenceContext
    private EntityManager entityManager;
    private BaseDao<UserVO, Integer> userDao;

    @Before
    public void setUp() {
        userDao = new UserDao();
        //entityManager = JpaUtil.INSTANCE.getEntityManager();
        userDao.setEntityManager(JpaUnitils.getEntityManager());
        //JpaUnitils.injectEntityManagerInto(userDao);

    }

    @Test
    public void testTest() {
        UserVO userVO = userDao.getByPK(111);
        assertNotNull(userVO);
    }
}
