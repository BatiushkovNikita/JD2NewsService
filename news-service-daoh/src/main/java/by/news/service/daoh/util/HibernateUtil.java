package by.news.service.daoh.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public enum HibernateUtil {
    INSTANCE;

    private static Logger Log = LogManager.getLogger(HibernateUtil.class.getName());

    public SessionFactory getSessionFactory() {
        Log.info("Creating SessionFactory");
        SessionFactory sessionFactory;
        try {
            Log.debug("Creating new configuration");
            Configuration configuration = new AnnotationConfiguration();
            Log.debug("Configuring ORM");
            sessionFactory = configuration.configure().buildSessionFactory();
        } catch (Throwable e) {
            Log.error("Initial SessionFactory creation failed", e);
            throw new ExceptionInInitializerError(e);
        }
        Log.info("Returning SessionFactory");
        return sessionFactory;
    }
}
