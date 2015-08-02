package by.news.service.dao.pool;

import java.sql.Connection;

import junit.framework.TestCase;

public class ConnectionPoolTest extends TestCase {
	public void testConnection() {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = connectionPool.getConnection();
		assertNotNull(connection);
	}
}
