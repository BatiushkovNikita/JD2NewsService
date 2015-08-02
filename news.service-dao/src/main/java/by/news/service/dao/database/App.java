package by.news.service.dao.database;

import java.io.IOException;

import by.news.service.dao.database.impl.UserDAOImpl;
import by.news.service.dao.database.interf.GenericDAO;
import by.news.service.entity.User;

public class App {
	public static void main(String[] args) {
		GenericDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
		System.out.println(userDAO.getByPK(3));
		User user = new User("email@", "dsds", "sdsd", "dsdsds");
		int s = userDAO.create(user);
		System.out.println(s);
	}
}
