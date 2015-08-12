package by.news.service.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.record.chart.BarRecord;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.entity.User;

public class App {
	public static Logger Log = LogManager.getLogger(App.class.getName());

	public static void main(String[] args) throws DAOException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		
		System.out.println(System.getProperty("user.home"));

		AbstractDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
		userDAO.setConnection(connection);
		
		User user = new User("ZZZZZZZZZZZZ", "dsds", "sdsd", "dsdsds");
		int s = userDAO.create(user);
		System.out.println("User was added: " + s);
	

/*		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		System.out.println("Done");
	}
}
