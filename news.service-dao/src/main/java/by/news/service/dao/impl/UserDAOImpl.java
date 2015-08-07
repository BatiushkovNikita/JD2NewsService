package by.news.service.dao.impl;

import static by.news.service.dao.utills.Constants.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.interf.UserDAO;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.dao.utills.ResourceManager;
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
	public void pStatementForInsert(PreparedStatement pStatement, User user) {
		pStatementSetFields(pStatement, user);
	}

	@Override
	public void pStatementForUpdate(PreparedStatement pStatement, User user) {
		try {
			pStatementSetFields(pStatement, user);
			pStatement.setInt(5, user.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> parseResultSet(ResultSet resultSet) {
		List<User> users = new ArrayList<User>();
		try {
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("id"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("first_name"),
						resultSet.getString("last_name"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public Integer parseResultSetKey(ResultSet resultSet) {
		int key = 0;
		try {
			while (resultSet.next()) {
				key = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
	}

	private void pStatementSetFields(PreparedStatement pStatement, User user) {
		try {
			pStatement.setString(1, user.getEmail());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.getFirstName());
			pStatement.setString(4, user.getLastName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User getUserByEmail(String email) {
		User user = null;
		String query = QUERIES.getString("get.user.by.email");
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, email);
			resultSet = pStatement.executeQuery();
			user = parseResultSet(resultSet).get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new DAOException("");
		} finally {
			ResourceManager.closeResources(connection, pStatement, resultSet);
		}
		return user;
	}
}