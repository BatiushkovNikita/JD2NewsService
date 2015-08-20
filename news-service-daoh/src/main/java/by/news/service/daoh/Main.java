package by.news.service.daoh;


import by.news.service.daoh.impl.UserDaoImpl;
import by.news.service.to.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static Logger Log1 = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.setProperty("org.jboss.logging.provider", "log4j2");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getUser(1);
        System.out.println(user);
        Log1.error("error");
        Log1.debug("debug");

    }
}
