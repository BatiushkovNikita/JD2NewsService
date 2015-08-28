/*package by.news.service.daoh;


import by.news.service.daoh.impl.AbstractDao;
import by.news.service.daoh.impl.DaoFactory;
import by.news.service.daoh.impl.UserDaoImpl;
import by.news.service.daoh.pojos.User;
import by.news.service.daoh.util.Hibernate3Util;
import by.news.service.daoh.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.orm.hibernate.HibernateUnitils;
import org.unitils.orm.hibernate.annotation.HibernateSessionFactory;

import static junit.framework.Assert.assertEquals;

@DataSet
@HibernateSessionFactory("hibernate.cfg.xml")
public class UserDaoImplTest extends UnitilsJUnit4 {

    private AbstractDao<User, Integer> userDao;

    @Before
    public void setUp() {
        userDao = new UserDaoImpl();
        SessionFactory sessionFactory = HibernateUtil.INSTANCE.getSessionFactory();
        userDao.setSessionFactory(sessionFactory);


    }

 *//*   final User user1 = new User(111, "email1", "password1");
    final User user2 = new User(222, "email2", "password2");
    final User user3 = new User(333, "email3", "password3");*//*


    @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }

*//*    @Test
    public void testGettingUserByKey() {
        User user = userDao.getByPK(111);
        User expectUser = user1;
        assertEquals(expectUser, user);
    }*//*

*//*    @Test
    public void testUpdatingUser() {
        boolean expected = userDao.update(user1);
        assertEquals(expected, true);
    }*//*

*//*    @Test
    public void testCreatingUser() {
        User user = new User();
        user.setUserID(0);
        user.setPassword("pass");
        user.setEmail("dsds");
        int id = userDao.create(user);
        int expectedId = 0;
        assertEquals(expectedId, id);
    }*//*

}*/
