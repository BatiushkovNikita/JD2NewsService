package by.news.service.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.entity.Role;
import by.news.service.entity.User;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.interf.UserService;

public class UserServiceImpl implements UserService {
	private GenericDAO<User, Integer> userDAO;
	public static Logger Log = LogManager.getLogger(AbstractDAO.class.getName());

	public UserServiceImpl(GenericDAO<User, Integer> userDAO) {
		super();
		this.userDAO = userDAO;
	}

	public int registerUser(User user) throws ServiceException {
		Log.info("Registering user");
		int id = 0;
		try {
			id = userDAO.create(user);
		} catch (DAOException e) {
			Log.error("Cannot register user", e);
			throw new ServiceException("Cannot register user", e);
		}
		Log.info("User was registered with id: " + id);
		return id;
	}

	public void updateUser(User user) throws ServiceException {
		Log.info("Updating user profile");
		try {
			userDAO.update(user);
		} catch (DAOException e) {
			Log.error("Cannot update user profile", e);
			throw new ServiceException("Cannot update user profile", e);
		}
		Log.info("User profile was updated");
	}

	public List<User> getAllUsers() throws ServiceException {
		Log.info("Getting all users");
		List<User> users;
		try {
			users = userDAO.getAll();
		} catch (DAOException e) {
			Log.error("Cannot get all users", e);
			throw new ServiceException("Cannot get all users", e);
		}
		Log.info("Returning all users");
		return users;
	}

	public List<Role> getUserRoles(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User authorizationUser(String email, String Password) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
}
