package by.news.service.dao.impl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.dbunit.annotation.DataSet;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.interf.UserDAO;
import by.news.service.entity.User;

@DataSet
public class UserDaoImplTest extends UnitilsJUnit4 {
	
	@TestDataSource
	private DataSource dataSource;
	
	private AbstractDAO<User, Integer> userDao;
	
	@Before
    public void setUp() throws SQLException {
		userDao = UserDAOImpl.getInstance();
		userDao.setConnection(dataSource.getConnection());
    }
    
    @DataSet
    @Test
    public void testMethod() throws SQLException {
    	 Connection cnnx = dataSource.getConnection();
         Statement stmt = cnnx.createStatement();
         ResultSet rs = null;
         try {
             // check that the GG_LANGUAGES1 table exists
             rs = stmt.executeQuery("SELECT * FROM users");


             System.out.println("testGetLanguages succeeded");
         } finally {
             if (rs != null) {
                 rs.close();
             }
         }
         stmt.close();
         cnnx.close(); 
    }
    
    @Test
    public void testDao() throws DAOException {
    	User result = userDao.getByPK(777);
    	User user = new User(777, "aaa@gmail.com", "d8578edf8458ce06fbc5bb76a58c5ca4", "Sergey", "Katabin");
    	assertEquals(result, user);
    }

}














