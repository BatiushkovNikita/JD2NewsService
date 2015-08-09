package by.news.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.interf.UserDAO;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.entity.User;

public class UserDAOImpl extends AbstractDAO<User, Integer>implements UserDAO {
	private static volatile UserDAOImpl instance;

	private UserDAOImpl() {

	}

	public static synchronized UserDAOImpl getInstance() {
		if (instance == null) {
			instance = new UserDAOImpl();
		}
		return instance;
	}

	@Override
	public String getInsertQuery() {
		return QUERIES.getString("insert.query.user");
	}

	@Override
	public String getSelectQuery() {
		return QUERIES.getString("select.query.user");
	}

	@Override
	public String getUpdateQuery() {
		return QUERIES.getString("update.query.user");
	}

	@Override
	public String getDeleteQuery() {
		return QUERIES.getString("delete.query.user");
	}

	@Override
	public void pStatementForInsert(PreparedStatement pStatement, User user) throws DAOException {
		Log.trace("Creating prepared statement for User insert");
		try {
			pStatement.setString(1, user.getEmail());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.getFirstName());
			pStatement.setString(4, user.getLastName());
		} catch (SQLException e) {
			Log.error("Cannot create prepared statement for User insert", e);
			throw new DAOException("Cannot create prepared statement for User insert", e);
		}
	}

	@Override
	public void pStatementForUpdate(PreparedStatement pStatement, User user) throws DAOException {
		Log.trace("Creating prepared statement for User update");
		try {
			pStatement.setString(1, user.getEmail());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.getFirstName());
			pStatement.setString(4, user.getLastName());
			pStatement.setInt(5, user.getUserID());
		} catch (SQLException e) {
			Log.error("Cannot create prepared statement for User update", e);
			throw new DAOException("Cannot create prepared statement for User update", e);
		}
	}

	public List<User> parseResultSet(ResultSet resultSet) throws DAOException {
		List<User> users = new ArrayList<User>();
		try {
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("id"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("first_name"),
						resultSet.getString("last_name"));
				users.add(user);
			}
		} catch (SQLException e) {
			Log.error("Cannot parse result set for User", e);
			throw new DAOException("Cannot parse result set for User", e);
		}
		return users;
	}

	@Override
	public Integer parseResultSetKey(ResultSet resultSet) throws DAOException {
		int key = 0;
		try {
			while (resultSet.next()) {
				key = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			Log.error("Cannot parse result set for User", e);
			throw new DAOException("Cannot parse result set for User", e);
		}
		return key;
	}

	public User getUserByEmail(String email) throws DAOException {
		Log.info("Getting User by email: " + email);
		User user = null;
		String query = QUERIES.getString("get.user.by.email");
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			Log.trace("Open connection");
			connection = ConnectionPool.getInstance().getConnection();
			Log.trace("Create prepared statement");
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, email);
			Log.trace("Getting result set");
			resultSet = pStatement.executeQuery();
			user = parseResultSet(resultSet).get(0);
		} catch (SQLException e) {
			Log.error("Cannot get User by email: " + email, e);
			throw new DAOException("Cannot get User by email: " + email, e);
		} finally {
			closeResources(connection, pStatement, resultSet);
		}
		Log.info("Returning User: " + user);
		return user;
	}
}
