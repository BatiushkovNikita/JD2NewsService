package by.news.service.service.database.impl;

import java.util.List;

import by.news.service.dao.database.impl.UserDAOImpl;
import by.news.service.entity.User;
import by.news.service.service.database.interf.GenericService;

public class UserServiceImpl implements GenericService<User, Integer>{
	private UserDAOImpl userDao;

	public UserServiceImpl() {
		this.userDao = UserDAOImpl.getInstance();
	}

	public Integer create(User user) {
		return userDao.create(user);
	}

	public User getByPK(Integer key) {
		return userDao.getByPK(key);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void delete(User user) {
		userDao.delete(user);
		
	}

	public List<User> getAll() {
		return userDao.getAll();
	}
}
