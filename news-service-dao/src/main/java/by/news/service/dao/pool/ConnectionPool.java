package by.news.service.dao.pool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {
	private static volatile ConnectionPool instance;
	private BasicDataSource basicDataSource;

	private ConnectionPool() {
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(ConnectionConfig.getDriver());
		basicDataSource.setUrl(ConnectionConfig.getDBURL());
		basicDataSource.setUsername(ConnectionConfig.getUserName());
		basicDataSource.setPassword(ConnectionConfig.getPassword());
	}

	public static synchronized ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = basicDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
