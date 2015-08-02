package by.news.service.dao.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.news.service.dao.database.interf.GenericDAO;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.dao.utils.Queries;
import by.news.service.dao.utils.ResourceManager;

public abstract class AbstractDAO<T, PK> implements GenericDAO<T, PK> {

	public abstract String getInsertQuery();

	public abstract String getSelectQuery();

	public abstract String getUpdateQuery();

	public abstract String getDeleteQuery();

	public abstract void pStatementForInsert(PreparedStatement pStatement, T object);

	public abstract List<T> parseResultSet(ResultSet resultSet);

	public abstract PK parseResultSetKey(ResultSet resultSet);

	public abstract void setEntityParam();

	public abstract T readRole();

	public PK create(T object) {
		PK key = null;
		String quary = getInsertQuery();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			pStatement = connection.prepareStatement(quary);
			pStatementForInsert(pStatement, object);
			resultSet = pStatement.executeQuery(Queries.getSelectLastInsertIdQuery());
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
		String query = getSelectQuery() + " " + Queries.getWhereId();
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
		// TODO Auto-generated method stub

	}

	public void delete(T object) {
		// TODO Auto-generated method stub

	}

	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
