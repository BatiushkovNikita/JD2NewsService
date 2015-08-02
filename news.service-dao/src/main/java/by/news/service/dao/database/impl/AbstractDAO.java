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

	public abstract String getSQLQuery();

	public abstract void setEntityParam();

	public abstract List<T> parseResultSet(ResultSet resultSet);

	public abstract T readRole();

	public abstract PK getSQLKey();

	public PK create(T object) {
		// TODO Auto-generated method stub
		return null;
	}

	public T getByPK(PK key) {
		List<T> list = new ArrayList<T>();
		String query = getSQLQuery() + " " + Queries.getWhereId();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setObject(1, key);
			resultSet = pStatement.executeQuery();
			list = parseResultSet(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceManager.closeResources(connection, pStatement, resultSet);
		}
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.iterator().next();
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
