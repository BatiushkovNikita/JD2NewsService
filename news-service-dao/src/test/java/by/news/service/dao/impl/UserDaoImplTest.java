package by.news.service.dao.impl;

import by.news.service.entity.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.dbunit.annotation.DataSet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    @Ignore
    @Test
    public void testMethod() throws SQLException {
        Connection cnnx = dataSource.getConnection();
        Statement stmt = cnnx.createStatement();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM users");
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        stmt.close();
        cnnx.close();
    }

/*    @Test
    public void testGettingUserByPK() throws DAOException {
        User result = userDao.getByPK(777);
        User user = new User(777, "aaa@gmail.com", "d8578edf8458ce06fbc5bb76a58c5ca4", "Sergey", "Katabin");
        assertEquals(result, user);
    }*/

/*    @Test
    public void testCreatingUser() throws DAOException {
        User user = new User("aaa@gmail.com", "d8578edf8458ce06fbc5bb76a58c5ca4", "AAA", "BBB");
        int id = userDao.create(user);
        assertEquals(0, id);
    }*/
}
