package by.news.service.dao.interf;

import java.util.List;

import by.news.service.dao.exception.DAOException;

public interface GenericDAO<T, PK> {

	PK create(T object) throws DAOException;

	T getByPK(PK key) throws DAOException;

	void update(T object) throws DAOException;

	void delete(PK key) throws DAOException;

	List<T> getAll() throws DAOException;
}
