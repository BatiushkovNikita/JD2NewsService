package by.news.service.service.database.interf;

import java.util.List;

public interface GenericService<T, PK> {
	PK create(T object);

	T getByPK(PK key);

	void update(T object);

	void delete(T object);

	List<T> getAll();
}
