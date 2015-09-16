package by.news.service.dao.exception;

import java.sql.SQLException;

public class DAOException extends SQLException {

	public DAOException() {

	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
}
