package by.news.service.dao;

import by.news.service.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	
	public static Logger Log = LogManager.getLogger(App.class.getName());

	public static void main(String[] args) throws DAOException {
/*		Connection connection = ConnectionPool.getInstance().getConnection();

		System.out.println(System.getProperty("user.home"));

		AbstractDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
		userDAO.setConnection(connection);
        System.out.println(userDAO.getByPK(1));

		*//*User user = new User("ZZZZZZZZZZZZ", "dsds", "sdsd", "dsdsds");
		int s = userDAO.create(user);
		System.out.println("User was added: " + s);*//*



		System.out.println("Done");*/
        Log.debug("test");
	}
}
