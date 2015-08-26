package by.news.service.daoh.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Hibernate3Util {
    private static SessionFactory sessionFactory;

    private static Logger Log = LogManager.getLogger(Hibernate3Util.class.getName());

    private Hibernate3Util() {

    }

    static {
        try {
            //Configuration configuration = new AnnotationConfiguration();
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
