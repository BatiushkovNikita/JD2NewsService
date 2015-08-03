package by.news.service.dao.database.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.news.service.dao.database.interf.UserDAO;
import by.news.service.dao.utils.Queries;
import by.news.service.entity.User;

public class UserDAOImpl extends AbstractDAO<User, Integer>implements UserDAO {
	private static UserDAOImpl instance = new UserDAOImpl();

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
		return Queries.getInsertQueryUser();
	}

	@Override
	public String getSelectQuery() {
		return Queries.getSelectQueryUser();
	}

	@Override
	public String getUpdateQuery() {
		return Queries.getUpdateQueryUser();
	}

	@Override
	public String getDeleteQuery() {
		return Queries.getDeleteQueryUser();
	}

	@Override
	public void pStatementForInsert(PreparedStatement pStatement, User user) {
		try {
			pStatement.setString(1, user.getEmail());
			pStatement.setInt(2, user.getPassword());
			pStatement.setString(3, user.getFirstName());
			pStatement.setString(4, user.getLastName());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pStatementForUpdate(PreparedStatement pStatement, User user) {
		try {
			pStatement.setString(1, user.getEmail());
			pStatement.setInt(2, user.getPassword());
			pStatement.setString(3, user.getFirstName());
			pStatement.setString(4, user.getLastName());
			pStatement.setInt(5, user.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> parseResultSet(ResultSet resultSet) {
		List<User> users = new ArrayList<User>();
		try {
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("id"), resultSet.getString("email"), resultSet.getInt("password"),
						resultSet.getString("first_name"), resultSet.getString("last_name"));
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

	@Override
	public void setEntityParam() {

	}

	@Override
	public User readRole() {
		// TODO Auto-generated method stub
		return null;
	}
}
