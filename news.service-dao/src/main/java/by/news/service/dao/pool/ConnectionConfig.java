package by.news.service.dao.pool;

import java.util.ResourceBundle;

import by.news.service.dao.utils.Constants;

public final class ConnectionConfig {

	public static String dbConfigPath = Constants.DB_CONFIG_PATH;

	public static String getDriver() {
		return ResourceBundle.getBundle(dbConfigPath).getString("driver");
	}

	public static String getDBURL() {
		return ResourceBundle.getBundle(dbConfigPath).getString("DBURL");
	}

	public static String getUserName() {
		return ResourceBundle.getBundle(dbConfigPath).getString("username");
	}

	public static String getPassword() {
		return ResourceBundle.getBundle(dbConfigPath).getString("password");
	}
}
