package by.news.service.daoh.impl;


import by.news.service.daoh.exception.DaoException;
import by.news.service.daoh.interf.GenericDao;

import java.util.List;

public class AbstractDao<T, PK> implements GenericDao<T, PK> {
    @Override
    public PK create(T object) throws DaoException {
        return null;
    }

    @Override
    public T getByPK(PK key) throws DaoException {
        return null;
    }

    @Override
    public int update(T object) throws DaoException {
        return 0;
    }

    @Override
    public int delete(PK key) throws DaoException {
        return 0;
    }

    @Override
    public List<T> getAll() throws DaoException {
        return null;
    }
}
