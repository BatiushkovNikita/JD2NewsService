/*package by.news.service.daoh.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate3Util {
    private static SessionFactory sessionFactory;

    private Hibernate3Util() {

    }

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}*/
