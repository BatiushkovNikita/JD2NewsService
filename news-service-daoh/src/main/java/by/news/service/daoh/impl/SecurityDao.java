package by.news.service.daoh.impl;

import by.news.service.daoh.exception.DaoException;
import by.news.service.daoh.interf.BaseDao;
import by.news.service.daoh.pojos.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;

public class SecurityDao implements BaseDao<Role, Integer>{

    private Logger Log = LogManager.getLogger(UserDao.class.getName());
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            Log.error("Cannot configured DAO. EntityManager is not submitted.");
            throw new DaoException("Cannot configured DAO. EntityManager is not submitted.");
        }
        return entityManager;
    }

    @Override
    public Integer create(Role object) throws DaoException {
        return null;
    }

    @Override
    public Role getByPK(Integer key) throws DaoException {
        return null;
    }

    @Override
    public boolean update(Role object) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Integer key) throws DaoException {
        return false;
    }

    @Override
    public List<Role> getAll() throws DaoException {
        return null;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
