package by.news.service.services.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.dao.interf.UserDAO;
import by.news.service.entity.Role;
import by.news.service.entity.User;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.interf.UserService;

public class UserServiceImpl implements UserService {
	private static volatile UserServiceImpl instance;
	private GenericDAO<User, Integer> userGenericDAO;
	private UserDAO userDAO;
	public static Logger Log = LogManager.getLogger(AbstractDAO.class.getName());

	private UserServiceImpl() {

	}

	public static synchronized UserServiceImpl getInstance() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	public int registerUser(User user) throws ServiceException {
		Log.info("Registering user");
		int id = 0;
		try {
			id = getUserGenericDAO().create(user);
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
			getUserGenericDAO().update(user);
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
			users = getUserGenericDAO().getAll();
		} catch (DAOException e) {
			Log.error("Cannot get all users", e);
			throw new ServiceException("Cannot get all users", e);
		}
		Log.info("Returning all users");
		return users;
	}

	public List<Role> getUserRoles(int user_id) throws ServiceException {
		Log.info("Getting user roles");
		List<Role> roles;
		try {
			roles = getUserDAO().getUserRoles(user_id);
		} catch (DAOException e) {
			Log.error("Cannot get user roles", e);
			throw new ServiceException("Cannot get user roles", e);
		}
		Log.info("Returning user roles");
		return roles;
	}

	public User authorizeUser(User user) throws ServiceException {
		Log.info("Authorizing user");
		User authorizedUser;
		try {
			String email = user.getEmail();
			String password = user.getPassword();
			String passwordMD5 = DigestUtils.md5Hex(password);
			authorizedUser = getUserDAO().getUserByEmailAndPassword(email, passwordMD5);
		} catch (DAOException e) {
			Log.error("Cannot authorize user", e);
			throw new ServiceException("Cannot authorize user", e);
		}
		Log.info("Returning user");
		return authorizedUser;
	}

	public GenericDAO<User, Integer> getUserGenericDAO() throws ServiceException {
		if (userGenericDAO == null) {
			Log.error("Cannot configured UserService. UserDAO is not submitted.");
			throw new ServiceException("Cannot configured UserService. UserDAO is not submitted.");
		}
		return userGenericDAO;
	}

	public void setUserGenericDAO(GenericDAO<User, Integer> userGenericDAO) {
		this.userGenericDAO = userGenericDAO;
	}

	public UserDAO getUserDAO() throws ServiceException {
		if (userDAO == null) {
			Log.error("Cannot configured UserService. UserDAO is not submitted.");
			throw new ServiceException("Cannot configured UserService. UserDAO is not submitted.");
		}
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
