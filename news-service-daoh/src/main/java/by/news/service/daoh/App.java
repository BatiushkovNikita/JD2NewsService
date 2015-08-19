package by.news.service.daoh;

import by.news.service.daoh.impl.UserDaoImpl;
import by.news.service.to.User;

public class App {
	public static void main(String[] args) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.getUser(1);
		System.out.println(user);
		
	}

}
