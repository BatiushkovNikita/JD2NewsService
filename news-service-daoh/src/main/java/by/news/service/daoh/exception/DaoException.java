package by.news.service.daoh.exception;

import org.hibernate.HibernateException;

import java.sql.SQLException;

public class DaoException extends HibernateException {

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
