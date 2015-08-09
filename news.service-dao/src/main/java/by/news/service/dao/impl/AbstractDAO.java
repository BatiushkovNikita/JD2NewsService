package by.news.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.dao.pool.ConnectionPool;

public abstract class AbstractDAO<T, PK> implements GenericDAO<T, PK> {
	public static final ResourceBundle QUERIES = ResourceBundle.getBundle("queries");

	public static Logger Log = LogManager.getLogger(AbstractDAO.class.getName());

	public abstract String getInsertQuery();

	public abstract String getSelectQuery();

	public abstract String getUpdateQuery();

	public abstract String getDeleteQuery();

	public abstract void pStatementForInsert(PreparedStatement pStatement, T object) throws DAOException;

	public abstract void pStatementForUpdate(PreparedStatement pStatement, T object) throws DAOException;

	public abstract List<T> parseResultSet(ResultSet resultSet) throws DAOException;

	public abstract PK parseResultSetKey(ResultSet resultSet) throws DAOException;

	public PK create(T object) throws DAOException {
		Log.info("Creating new " + object);
		PK key = null;
		String query = getInsertQuery();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			Log.trace("Open connection");
			connection = ConnectionPool.getInstance().getConnection();
			Log.trace("Create prepared statement");
			pStatement = connection.prepareStatement(query);
			pStatementForInsert(pStatement, object);
			pStatement.executeUpdate();
			Log.trace("Getting result set");
			resultSet = pStatement.executeQuery(QUERIES.getString("select.last.insert.id.query"));
			key = parseResultSetKey(resultSet);
		} catch (SQLException e) {
			Log.error("Cannot create " + object, e);
			throw new DAOException("Cannot create " + object, e);
		} finally {
			closeResources(connection, pStatement, resultSet);
		}
		Log.info(object + " was created");
		return key;
	}

	public T getByPK(PK key) throws DAOException {
		Log.info("Getting object by key: " + key);
		List<T> entities = new ArrayList<T>();
		String query = getSelectQuery();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			Log.trace("Open connection");
			connection = ConnectionPool.getInstance().getConnection();
			Log.trace("Create prepared statement");
			pStatement = connection.prepareStatement(query);
			pStatement.setObject(1, key);
			Log.trace("Getting result set");
			resultSet = pStatement.executeQuery();
			entities = parseResultSet(resultSet);
		} catch (SQLException e) {
			Log.error("Cannot get object by key: " + key, e);
			throw new DAOException("Cannot get object by key: " + key, e);
		} finally {
			closeResources(connection, pStatement, resultSet);
		}
		if (entities == null || entities.size() == 0) {
			return null;
		}
		T object = entities.iterator().next();
		Log.info("Returning " + object);
		return object;
	}

	public void update(T object) throws DAOException {
		Log.info("Updating " + object);
		String query = getUpdateQuery();
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			Log.trace("Open connection");
			connection = ConnectionPool.getInstance().getConnection();
			Log.trace("Create prepared statement");
			pStatement = connection.prepareStatement(query);
			pStatementForUpdate(pStatement, object);
			int count = pStatement.executeUpdate();
			if (count == 1) {
				Log.info("Object: " + object + " was updated");
			} else if (count > 1) {
				Log.warn("On update modify more then 1 record: " + count);
			} else {
				Log.warn("Object: " + object + " not found");
			}
		} catch (SQLException e) {
			Log.error("Cannot update " + object);
			throw new DAOException("Cannot update " + object, e);
		} finally {
			closeResources(connection, pStatement);
		}
	}

	public void delete(PK key) throws DAOException {
		Log.info("Deleting object by key: " + key);
		String query = getDeleteQuery();
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			Log.trace("Open connection");
			connection = ConnectionPool.getInstance().getConnection();
			Log.trace("Create prepared statement");
			pStatement = connection.prepareStatement(query);
			pStatement.setObject(1, key);
			int count = pStatement.executeUpdate();
			if (count == 1) {
				Log.info("Object with key: " + key + " was deleted");
			} else if (count > 1) {
				Log.warn("On delete modify more then 1 record: " + count);
			} else {
				Log.warn("Object not found");
			}
		} catch (SQLException e) {
			Log.error("Cannot delete object by key: " + key);
			throw new DAOException("Cannot delete object by key: " + key, e);
		} finally {
			closeResources(connection, pStatement);
		}
	}

	public List<T> getAll() throws DAOException {
		Log.info("Getting list of objects");
		List<T> entities = new ArrayList<T>();
		String query = getSelectQuery();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Log.trace("Open connection");
			connection = ConnectionPool.getInstance().getConnection();
			Log.trace("Create statement");
			statement = connection.createStatement();
			Log.trace("Getting result set");
			resultSet = statement.executeQuery(query);
			entities = parseResultSet(resultSet);
			if (entities.size() == 0) {
				Log.warn("Object not found");
			} else {
				Log.info("Returning list of objects");
			}
		} catch (SQLException e) {
			Log.error("Cannot get list of objects", e);
			throw new DAOException("Cannot get list of objects", e);
		} finally {
			closeResources(connection, statement, resultSet);
		}
		return entities;
	}

	public void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
				Log.trace("ResultSet closed");
			} catch (SQLException e) {
				Log.warn("Cannot close ResultSet", e);
			}
		}
		if (statement != null) {
			try {
				statement.close();
				Log.trace("Statement closed");
			} catch (SQLException e) {
				Log.warn("Cannot close Statement", e);
			}
		}
		if (connection != null) {
			try {
				connection.close();
				Log.trace("Connection closed");
			} catch (SQLException e) {
				Log.warn("Cannot close Connection", e);
			}
		}
	}

	public void closeResources(Connection connection, Statement statement) {
		closeResources(connection, statement, null);
	}

	public void closeResources(ResultSet resultSet) {
		closeResources(null, null, resultSet);
	}
}
