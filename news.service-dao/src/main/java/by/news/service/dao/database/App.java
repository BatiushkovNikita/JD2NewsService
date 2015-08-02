package by.news.service.dao.database;

import by.news.service.dao.database.impl.UserDAOImpl;
import by.news.service.dao.database.interf.GenericDAO;
import by.news.service.entity.User;

public class App {
	public static void main(String[] args) {
		GenericDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
		User user = userDAO.getByPK(3);
		System.out.println(user);
	}
}
