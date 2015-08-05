package by.news.service.dao.database.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.news.service.dao.utils.Constants.*;
import by.news.service.entity.Role;

public class RoleDAOImpl extends AbstractDAO<Role, Integer> {
	private static volatile RoleDAOImpl instance;

	private RoleDAOImpl() {

	}

	public static synchronized RoleDAOImpl getInstance() {
		if (instance == null) {
			instance = new RoleDAOImpl();
		}
		return instance;
	}

	@Override
	public String getInsertQuery() {
		return QUERIES.getString("insert.query.role");
	}

	@Override
	public String getSelectQuery() {
		return QUERIES.getString("select.query.role");
	}

	@Override
	public String getUpdateQuery() {
		return QUERIES.getString("update.query.role");
	}

	@Override
	public String getDeleteQuery() {
		return QUERIES.getString("delete.query.role");
	}

	@Override
	public void pStatementForInsert(PreparedStatement pStatement, Role role) {
		try {
			pStatement.setString(1, role.getRole());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pStatementForUpdate(PreparedStatement pStatement, Role role) {
		try {
			pStatement.setString(1, role.getRole());
			pStatement.setInt(2, role.getRoleID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pStatementForDelete(PreparedStatement pStatement, Role role) {
		try {
			pStatement.setInt(1, role.getRoleID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Role> parseResultSet(ResultSet resultSet) {
		List<Role> roles = new ArrayList<Role>();
		try {
			while (resultSet.next()) {
				Role role = new Role(resultSet.getInt("id"), resultSet.getString("role"));
				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

	@Override
	public Integer parseResultSetKey(ResultSet resultSet) {
		int key = 0;
		try {
			while (resultSet.next()) {
				key = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
	}
}
