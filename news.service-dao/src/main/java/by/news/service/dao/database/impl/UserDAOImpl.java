package by.news.service.dao.database.impl;

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
	public Integer getSQLKey() {

		return null;
	}

	@Override
	public String getSQLQuery() {
		return Queries.getSelectFromUsers();
	}

	@Override
	public void setEntityParam() {

	}

	@Override
	public User readRole() {
		// TODO Auto-generated method stub
		return null;
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
}
