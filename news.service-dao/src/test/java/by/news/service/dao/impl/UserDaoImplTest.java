package by.news.service.dao.impl;

import javax.sql.DataSource;

import org.junit.Before;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.TestDataSource;

import by.news.service.dao.interf.UserDAO;

public class UserDaoImplTest extends UnitilsJUnit4 {
	
	@TestDataSource
	private DataSource dataSource;
	
	private UserDAO userDAO;
	
	@Before
    public void setUp() {
		userDAO = UserDAOImpl.getInstance();
        UserDAOImpl.setDataSource(dataSource);
    }
    
    @DataSet
    @Test
    public void testFindUserByLastName() {
        List<User> users = userDao.findByLastName("Doe");
        ReflectionAssert.assertPropertyLenientEquals("firstName", Arrays.asList("John", "Jane"), users);
    }

}
