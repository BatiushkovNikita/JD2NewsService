package by.news.service.daoh;


import by.news.service.daoh.impl.DaoFactory;
import by.news.service.daoh.impl.UserDaoImpl;
import by.news.service.daoh.interf.GenericDao;
import by.news.service.to.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class Main {

    private static Logger Log = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.setProperty("org.jboss.logging.provider", "log4j2");
/*        System.out.println(get(1));
        User user = new User();
        System.out.println("Main.main: " + user.getClass().getSimpleName());*/

        //getUsers();
        delete();

    }

/*    public static User get(int key) {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        return userDao.getByPK(key);
    }

    public static void getUsers() {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        for (User user : userDao.getAll()) {
            System.out.println(user);
        }
    }*/

    public static void delete() {
        GenericDao<User, Integer> userDao = new UserDaoImpl();
        userDao.delete(21);
    }
}
