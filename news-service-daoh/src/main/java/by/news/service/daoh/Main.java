package by.news.service.daoh;

import by.news.service.daoh.impl.UserDaoImpl;
import by.news.service.daoh.interf.GenericDao;
import by.news.service.daoh.pojos.User;
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

        User user = get(222);
        System.out.println(user);
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
