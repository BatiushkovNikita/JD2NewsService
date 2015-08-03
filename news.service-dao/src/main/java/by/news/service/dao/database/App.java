package by.news.service.dao.database;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import by.news.service.dao.database.impl.UserDAOImpl;
import by.news.service.dao.database.interf.GenericDAO;
import by.news.service.dao.utils.Constants;
import by.news.service.entity.User;

public class App {
	public static void main(String[] args) {
		GenericDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
/*		User user = new User("email@", 12345, "sdsd", "dsdsds");
		int s = userDAO.create(user);
		System.out.println(s);*/
		
	/*	userDAO.delete(new User(13, "email@", 12345, "sdsd", "dsdsds"));*/

		
		

		
		
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
