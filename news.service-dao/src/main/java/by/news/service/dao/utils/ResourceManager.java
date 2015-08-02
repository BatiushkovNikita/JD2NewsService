package by.news.service.dao.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class ResourceManager {

	private ResourceManager() {
	}

	public static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeResources(Connection connection, Statement statement) {
		closeResources(connection, statement, null);
	}

	public static void closeResources(ResultSet resultSet) {
		closeResources(null, null, resultSet);
	}
}
