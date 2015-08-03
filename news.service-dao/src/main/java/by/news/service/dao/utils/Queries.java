package by.news.service.dao.utils;

import java.util.ResourceBundle;

public final class Queries {

	public static ResourceBundle bundle = ResourceBundle.getBundle(Constants.QUERIES_PATH);

	// AbstractDAO
	public static final String WHERE_ID_QUERY = bundle.getString("where.column.name");
	public static final String SELECT_LAST_INSERT_ID_QUERY = bundle.getString("select.last.insert.id.query");

	// UserDAOImpl
	public static final String INSERT_QUERY_USER = bundle.getString("insert.query.user");
	public static final String SELECT_QUERY_USER = bundle.getString("select.query.user");
	public static final String UPDATE_QUERY_USER = bundle.getString("update.query.user");
	public static final String DELETE_QUERY_USER = bundle.getString("delete.query.user");

	// NewsDAOImpl
	public static final String INSERT_QUERY_NEWS = bundle.getString("insert.query.news");
	public static final String SELECT_QUERY_NEWS = bundle.getString("select.query.news");
	public static final String UPDATE_QUERY_NEWS = bundle.getString("update.query.news");
	public static final String DELETE_QUERY_NEWS = bundle.getString("delete.query.news");

	// RoleDAOImpl
	public static final String INSERT_QUERY_ROLE = bundle.getString("insert.query.role");
	public static final String SELECT_QUERY_ROLE = bundle.getString("select.query.role");
	public static final String UPDATE_QUERY_ROLE = bundle.getString("update.query.role");
	public static final String DELETE_QUERY_ROLE = bundle.getString("delete.query.role");


	private Queries() {

	}
}