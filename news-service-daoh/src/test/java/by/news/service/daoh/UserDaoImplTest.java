package by.news.service.daoh;


import by.news.service.daoh.impl.AbstractDao;
import by.news.service.daoh.impl.UserDaoImpl;
import by.news.service.daoh.pojos.User;
import by.news.service.daoh.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.orm.hibernate.annotation.HibernateSessionFactory;

import static junit.framework.Assert.assertEquals;

@HibernateSessionFactory("hibernate.cfg.xml")
public class UserDaoImplTest extends UnitilsJUnit4 {

    @HibernateSessionFactory
    private SessionFactory sessionFactory;

    private AbstractDao<User, Integer> userDao;

    @Before
    public void setUp() {
        userDao = new UserDaoImpl();
        userDao.setSessionFactory(HibernateUtil.INSTANCE.getSessionFactory());
    }

/*    @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }*/

    @Test
    public void testGettingUserByKey() {
        User user = userDao.getByPK(111);
        User expectUser = new User();
        expectUser.setUserID(111);
        expectUser.setEmail("email1");
        expectUser.setPassword("password1");
        assertEquals(expectUser, user);
    }
}
