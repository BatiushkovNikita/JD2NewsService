package by.news.service.dao;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.dao.utills.Constants;
import by.news.service.entity.User;

public class App {
	public static void main(String[] args) {
		GenericDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
		User user = new User("ZZZZZZZZZZZZ", "dsds", "sdsd", "dsdsds");
		int s = userDAO.create(user);
		System.out.println("User was added: " + s);

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
