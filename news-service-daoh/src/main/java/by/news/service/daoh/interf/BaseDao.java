package by.news.service.daoh.interf;

import by.news.service.daoh.exception.DaoException;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, PK extends Serializable> {

    PK create(T object) throws DaoException;

    T getByPK(PK key) throws DaoException;

    boolean update(T object) throws DaoException;

    boolean delete(PK key) throws DaoException;

    List<T> getAll() throws DaoException;

  /*  void setEntityManager(EntityManager entityManager);*/
}
