package by.news.service.daoh;

import by.news.service.daoh.impl.UserDaoImpl;
import by.news.service.daoh.interf.GenericDao;
import by.news.service.daoh.pojos.User;
import by.news.service.daoh.pojos.UserDetail;
import by.news.service.daoh.util.Hibernate3Util;
import by.news.service.daoh.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main {

    private static Logger Log = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.setProperty("org.jboss.logging.provider", "log4j2");

        //create();
        oneToOne();
    }

    public static void oneToOne() {
        User user = new User("email1", "pass1");
        UserDetail userDetail = new UserDetail("firstname1", "lastname1", "phone1");

        GenericDao<User, Integer> userDao = new UserDaoImpl();
        //GenericDao<UserDetail, Integer> userDetailDao = new UserDetailDaoImpl();
        userDao.setSessionFactory(HibernateUtil.INSTANCE.getSessionFactory());

        user.setUserDetail(userDetail);
        userDetail.setUser(user);
        userDao.create(user);

    }

    public static void create() {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        userDao.setSessionFactory(HibernateUtil.INSTANCE.getSessionFactory());
        User user = new User();
        user.setEmail("dsewegfgfwds");
        user.setPassword("dewgfgfewsds");
        userDao.create(user);
    }

    public static User get(int id) {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        userDao.setSessionFactory(HibernateUtil.INSTANCE.getSessionFactory());
        //userDao.setSessionFactory(Hibernate3Util.getSessionFactory());
        return userDao.getByPK(id);
    }

    public static void getUsers() {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        userDao.setSessionFactory(HibernateUtil.INSTANCE.getSessionFactory());
        for (User user : userDao.getAll()) {
            System.out.println(user);
        }
    }


    public static void delete() {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        userDao.setSessionFactory(Hibernate3Util.getSessionFactory());
        userDao.delete(11);
    }

    private static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
