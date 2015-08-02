package by.news.service.dao.utils;

import java.util.ResourceBundle;

public final class Queries {

	public static String queriesPath = Constants.QUERIES_PATH;

	private Queries() {

	}

	public static String getUserByEmail() {
		return ResourceBundle.getBundle(queriesPath).getString("userByEmail");
	}
	
	public static String getSelectFromUsers() {
		return ResourceBundle.getBundle(queriesPath).getString("select.from.users");
	}
	
	public static String getWhereId() {
		return ResourceBundle.getBundle(queriesPath).getString("where.column.name");
	}
}