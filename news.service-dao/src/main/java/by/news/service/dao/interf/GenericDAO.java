package by.news.service.dao.interf;

import java.util.List;

public interface GenericDAO<T, PK> {

	PK create(T object);

	T getByPK(PK key);

	void update(T object);

	void delete(PK key);

	List<T> getAll();
}
