package by.news.service.daoh;

import by.news.service.daoh.impl.DaoFactory;
import by.news.service.daoh.impl.UserDaoImpl;
import by.news.service.daoh.interf.GenericDao;
import by.news.service.daoh.pojos.News;
import by.news.service.daoh.pojos.User;
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
        System.out.println(get(1));
        User user = new User();
        System.out.println("Main.main: " + user.getClass().getSimpleName());


        //getUsers();
        delete();
        News news = new News();
        news.setTopic("GDHSGDhsgdhsgdhsgh");
        news.setNewsText("dsdsdsds");
        news.setPublicationDate("2015-08-17 23:33:29");
        news.setUserID(1);
        DaoFactory.NEWS_DAO.getDao().create(news);


    }

    public static User get(int key) {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        return userDao.getByPK(key);
    }

    public static void getUsers() {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        for (User user : userDao.getAll()) {
            System.out.println(user);
        }
    }


    public static void delete() {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        userDao.setSessionFactory(HibernateUtil.getSessionFactory());
        userDao.delete(11);
    }

    private static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
