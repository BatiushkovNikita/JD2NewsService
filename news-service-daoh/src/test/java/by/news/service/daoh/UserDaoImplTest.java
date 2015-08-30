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

@DataSet
@JpaEntityManagerFactory(persistenceUnit = "test", configFile = "META-INF/persistence-test.xml")
public class UserDaoImplTest extends UnitilsJUnit4 {

    @PersistenceContext
    EntityManager entityManager;

    BaseDao<UserVO, Integer> userDao;


    @Before
    public void setUp() {
        userDao = new UserDao();
        //entityManager = JpaUtil.INSTANCE.getEntityManager();
        //userDao.setEntityManager(JpaUnitils.getEntityManager());
        JpaUnitils.injectEntityManagerInto(userDao);

    }


    @Test
    public void testMappingToDatabase() {
        JpaUnitils.assertMappingWithDatabaseConsistent();
    }

}
