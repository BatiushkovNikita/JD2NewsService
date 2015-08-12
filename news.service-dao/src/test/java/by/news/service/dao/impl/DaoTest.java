package by.news.service.dao.impl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.reflectionassert.ReflectionAssert;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.interf.UserDAO;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.entity.User;

@DataSet
public class DaoTest extends UnitilsJUnit4 {
	public static Logger Log = LogManager.getLogger(AbstractDAO.class.getName());

	@TestDataSource
	private DataSource dataSource;

	private AbstractDAO<User, Integer> userDao;
	
	@Before
	 public void setUp() throws SQLException {
        userDao = UserDAOImpl.getInstance();
        userDao.setConnection(ConnectionPool.getInstance().getConnection());;
    }
	
	@Test
	public void testGetUserById() throws DAOException {
		User result = userDao.getByPK(1);
		ReflectionAssert.assertLenientEquals(result, new User(1, "ds", "ds", "ds", "ds"));
	}

}
