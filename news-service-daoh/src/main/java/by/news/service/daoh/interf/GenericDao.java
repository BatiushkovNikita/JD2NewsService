package by.news.service.daoh.interf;

import by.news.service.daoh.exception.DaoException;

import java.util.List;

public interface GenericDao<T, PK> {

    PK create(T object) throws DaoException;

    T getByPK(PK key) throws DaoException;

    int update(T object) throws DaoException;

    int delete(PK key) throws DaoException;

    List<T> getAll() throws DaoException;
}
