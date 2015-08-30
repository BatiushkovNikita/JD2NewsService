package by.news.service.daoh.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public enum JpaUtil {
    INSTANCE;

    private Logger Log = LogManager.getLogger(JpaUtil.class.getName());

    public EntityManager getEntityManager() {
        Log.info("Creating EntityManagerFactory");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewsService");
        Log.info("Returning EntityManager");
        return entityManagerFactory.createEntityManager();
    }

    public void closeResources(EntityManager entityManager) {
        EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();
        Log.info("Closing resources");
        if (entityManager != null) {
            try {
                entityManager.close();
                Log.debug("EntityManager closed");
            } catch (PersistenceException e) {
                Log.warn("Cannot close EntityManager", e);
            }
        }
        if (entityManagerFactory != null) {
            try {
                entityManagerFactory.close();
                Log.debug("EntityManagerFactory closed");
            } catch (PersistenceException e) {
                Log.warn("Cannot close EntityManagerFactory", e);
            }
        }
    }
}
