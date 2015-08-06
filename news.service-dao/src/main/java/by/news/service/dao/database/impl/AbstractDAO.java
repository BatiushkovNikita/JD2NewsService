package by.news.service.dao.database.impl;

import static by.news.service.dao.utills.Constants.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.news.service.dao.database.interf.GenericDAO;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.dao.utills.ResourceManager;

public abstract class AbstractDAO<T, PK> implements GenericDAO<T, PK> {
	public abstract String getInsertQuery();

	public abstract String getSelectQuery();

	public abstract String getUpdateQuery();

	public abstract String getDeleteQuery();

	public abstract void pStatementForInsert(PreparedStatement pStatement, T object);

	public abstract void pStatementForUpdate(PreparedStatement pStatement, T object);

	public abstract List<T> parseResultSet(ResultSet resultSet);

	public abstract PK parseResultSetKey(ResultSet resultSet);

	/*
	 * public abstract void setEntityParam();
	 * 
	 * public abstract T readRole();
	 */

	public PK create(T object) {
		PK key = null;
		String query = getInsertQuery();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatementForInsert(pStatement, object);
			pStatement.executeUpdate();
			resultSet = pStatement.executeQuery(QUERIES.getString("select.last.insert.id.query"));
			key = parseResultSetKey(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceManager.closeResources(connection, pStatement, resultSet);
		}
		return key;
	}

	public T getByPK(PK key) {
		List<T> entities = new ArrayList<T>();
		String query = getSelectQuery();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setObject(1, key);
			resultSet = pStatement.executeQuery();
			entities = parseResultSet(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceManager.closeResources(connection, pStatement, resultSet);
		}
		if (entities == null || entities.size() == 0) {
			return null;
		}
		return entities.iterator().next();
	}

	public void update(T object) {
		String query = getUpdateQuery();
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatementForUpdate(pStatement, object);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceManager.closeResources(connection, pStatement);
		}
	}

	public void delete(PK key) {
		String query = getDeleteQuery();
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setObject(1, key);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceManager.closeResources(connection, pStatement);
		}
	}

	public List<T> getAll() {
		List<T> entities = new ArrayList<T>();
		String query = getSelectQuery();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			entities = parseResultSet(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceManager.closeResources(connection, statement, resultSet);
		}
		return entities;
	}
}
