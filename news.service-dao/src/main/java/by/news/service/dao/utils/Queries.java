package by.news.service.dao.utils;

import java.util.ResourceBundle;

public final class Queries {

	public static String queriesPath = Constants.QUERIES_PATH;

	private Queries() {

	}
	
	// AbstractDAO
	public static String getWhereId() {
		return ResourceBundle.getBundle(queriesPath).getString("where.column.name");
	}
	
	public static String getSelectLastInsertIdQuery() {
		return ResourceBundle.getBundle(queriesPath).getString("select.last.insert.id.query");
	}
	
	//UserDAOImpl
	public static String getInsertQueryUser() {
		return ResourceBundle.getBundle(queriesPath).getString("insert.query.user");
	}
	
	public static String getSelectQueryUser() {
		return ResourceBundle.getBundle(queriesPath).getString("select.query.user");
	}
	
	public static String getUpdateQueryUser() {
		return ResourceBundle.getBundle(queriesPath).getString("update.query.user");
	}
	
	public static String getDeleteQueryUser() {
		return ResourceBundle.getBundle(queriesPath).getString("delete.query.user");
	}

	
	

	public static String getUserByEmail() {
		return ResourceBundle.getBundle(queriesPath).getString("userByEmail");
	}
}