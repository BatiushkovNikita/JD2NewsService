package by.news.service.service.impl;

import java.util.List;

import by.news.service.dao.database.impl.UserDAOImpl;
import by.news.service.dao.database.interf.GenericDAO;
import by.news.service.dao.database.interf.UserDAO;
import by.news.service.entity.Role;
import by.news.service.entity.User;
import by.news.service.service.interf.UserService;

public class UserServiceImpl implements UserService {
	private static volatile UserServiceImpl instance;
	private GenericDAO<User, Integer> userDAO = UserDAOImpl.getInstance();

	private UserServiceImpl() {

	}

	public static synchronized UserServiceImpl getInstance() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	public int registerUser(User user) {
		return userDAO.create(user);
	}

	public void updateUser(User user) {
		userDAO.update(user);
	}

	public boolean isValidUser(String email, String password) {
		boolean validUser = false;
		UserDAO userDAO = UserDAOImpl.getInstance();
		User user = userDAO.getUserByEmail(email);
		if (user != null) {
			//return user.getEmail().equals(email) && user.getPassword() == password;
		}
		return validUser;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> getUserRoles(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}
}
