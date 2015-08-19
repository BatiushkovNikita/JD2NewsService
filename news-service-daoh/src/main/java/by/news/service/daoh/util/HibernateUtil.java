package by.news.service.daoh.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
	private static SessionFactory sessionFactory;
	//private static StandardServiceRegistryBuilder serviceRegistry;
	private static Logger Log = LogManager.getLogger(HibernateUtil.class.getName());

	private HibernateUtil() {
		getSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		Log.debug("Creating SessionFactory");
		Configuration configuration;
		try {
			configuration = new Configuration();
			Log.debug("Configuring ORM");
			configuration.configure();
		} catch (Throwable e) {
			Log.error("Initial SessionFactory creation failed", e);
			throw new ExceptionInInitializerError(e);
		}
		Log.debug("Creating ServiceRegistry");
		StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder();
		serviceRegistry.applySettings(configuration.getProperties());
		Log.debug("Creating SessionFactory");
		sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
		Log.debug("Returning SessionFactory");
		return sessionFactory;
	}

	public Session getSession() {
		Log.debug("Returning ORM Session");
		return sessionFactory.openSession();
	}

}
