package by.news.service.daojpa.exception;

import javax.persistence.PersistenceException;

public class DaoException extends PersistenceException {

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
}
