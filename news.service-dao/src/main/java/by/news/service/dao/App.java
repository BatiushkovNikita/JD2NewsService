package by.news.service.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.record.chart.BarRecord;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.entity.User;

public class App {
	public static Logger Log = LogManager.getLogger(App.class.getName());

	public static void main(String[] args) throws DAOException {


/*		GenericDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
		User user = new User("ZZZZZZZZZZZZ", "dsds", "sdsd", "dsdsds");
		int s = userDAO.create(user);
		System.out.println("User was added: " + s);*/
		
		GenericDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
		userDAO.update(new User("asas", "dsds", "sdsd", "dsdsds"));

/*		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		System.out.println("Done");
	}
}
