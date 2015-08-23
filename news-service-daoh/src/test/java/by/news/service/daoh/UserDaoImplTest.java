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
        userDao.setSessionFactory(HibernateUtil.getSessionFactory());
    }

    @Test
    public void testGettingUserByKey() {
        User user = userDao.getByPK(777);
        User expectUser = new User();
        expectUser.setUserID(777);
        expectUser.setEmail("aaa@gmail.com");
        expectUser.setPassword("d8578edf8458ce06fbc5bb76a58c5ca4");
        expectUser.setFirstName("Sergey");
        expectUser.setLastName("Katabin");
        assertEquals(expectUser, user);
    }
}
