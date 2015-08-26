package by.news.service.daoh.impl;


import by.news.service.daoh.exception.DaoException;
import by.news.service.daoh.interf.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> implements GenericDao<T, PK> {
    private Logger Log = LogManager.getLogger(AbstractDao.class.getName());
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Log.error("Cannot configured DAO. SessionFactory is not submitted");
            throw new DaoException("Cannot configured DAO. SessionFactory is not submitted");
        }
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected abstract Class getPersistentClass();

    @Override
    public PK create(T object) throws DaoException {
        Log.info("Creating new object: " + object.getClass().getSimpleName());
        PK key;
        Session session = null;
        Transaction transaction = null;
        try {
            Log.debug("Opening session");
            session = getSessionFactory().openSession();
            Log.debug("Beginning transaction");
            transaction = session.beginTransaction();
            Log.debug("Saving object: " + object.getClass().getSimpleName());
            key = (PK) session.save(object);
            Log.debug("Committing transaction");
            transaction.commit();
        } catch (HibernateException e) {
            Log.error("Cannot complete transaction ", e);
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Cannot complete transaction", e);
        } finally {
            Log.debug("Closing session");
            closeSession(session);
        }
        Log.info("Object with id: " + key + " was created");
        return key;
    }

    @Override
    public T getByPK(PK key) throws DaoException {
        Log.info("Getting object by key: " + key);
        T object;
        Session session = null;
        Transaction transaction = null;
        try {
            Log.debug("Opening session");
            session = getSessionFactory().openSession();
            Log.debug("Beginning transaction");
            transaction = session.beginTransaction();
            Log.debug("Getting object");
            object = (T) session.get(getPersistentClass(), key);
            Log.debug("Committing transaction");
            transaction.commit();
        } catch (HibernateException e) {
            Log.error("Cannot complete transaction", e);
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Cannot complete transaction", e);
        } finally {
            closeSession(session);
        }
        Log.info("Returning object");
        return object;
    }

    @Override
    public boolean update(T object) throws DaoException {
        Log.info("Updating object: " + object.getClass().getSimpleName());
        Session session = null;
        Transaction transaction = null;
        try {
            Log.debug("Opening session");
            session = getSessionFactory().openSession();
            Log.debug("Beginning transaction");
            transaction = session.beginTransaction();
            Log.debug("Updating object: " + object.getClass().getSimpleName());
            session.update(object);
            Log.debug("Committing transaction");
            transaction.commit();
        } catch (HibernateException e) {
            Log.error("Cannot complete transaction", e);
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Cannot complete transaction", e);
        } finally {
            closeSession(session);
        }
        Log.info("Updated successfully");
        return true;
    }

    @Override
    public boolean delete(PK key) throws DaoException {
        Log.info("Deleting object by key");
        Session session = null;
        Transaction transaction = null;
        try {
            Log.debug("Opening session");
            session = getSessionFactory().openSession();
            Log.debug("Beginning transaction");
            transaction = session.beginTransaction();
            Log.debug("Getting object by key");
            T t = (T) session.get(getPersistentClass(), key);
            Log.debug("Deleting object");
            session.delete(t);
            Log.debug("Committing transaction");
            transaction.commit();
        } catch (HibernateException e) {
            Log.error("Cannot complete transaction", e);
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Cannot complete transaction", e);
        } finally {
            closeSession(session);
        }
        Log.info("Updated successfully");
        return true;
    }

    @Override
    public List<T> getAll() throws DaoException {
        Log.info("Getting list of objects");
        List<T> list = null;
        Session session = null;
        try {
            Log.debug("Opening session");
            session = getSessionFactory().openSession();
            Log.debug("Getting objects from session");
            list = session.createCriteria(getPersistentClass()).list();
        } catch (HibernateException e) {
            Log.error("Cannot get list of objects", e);
            throw new DaoException("Cannot get list of objects", e);
        } finally {
            closeSession(session);
        }
        Log.info("Returning list of objects");
        return list;
    }

    private void closeSession(Session session) throws DaoException {
        if ((session != null) && (session.isOpen())) {
            try {
                session.close();
                Log.debug("Session closed");
            } catch (Exception e) {
                Log.error("Cannot close session", e);
                throw new DaoException("Cannot close session", e);
            }
        }
    }
}
