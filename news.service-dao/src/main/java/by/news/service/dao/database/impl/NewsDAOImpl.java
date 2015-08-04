package by.news.service.dao.database.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.news.service.dao.database.interf.NewsDAO;
import static by.news.service.dao.utils.Queries.*;
import by.news.service.entity.News;

public class NewsDAOImpl extends AbstractDAO<News, Integer>implements NewsDAO {
	private static NewsDAOImpl instance;

	private NewsDAOImpl() {

	}

	public static synchronized NewsDAOImpl getInstance() {
		if (instance == null) {
			instance = new NewsDAOImpl();
		}
		return instance;
	}

	@Override
	public String getInsertQuery() {
		return INSERT_QUERY_NEWS;
	}

	@Override
	public String getSelectQuery() {
		return SELECT_QUERY_NEWS;
	}

	@Override
	public String getUpdateQuery() {
		return UPDATE_QUERY_NEWS;
	}

	@Override
	public String getDeleteQuery() {
		return DELETE_QUERY_NEWS;
	}

	@Override
	public void pStatementForInsert(PreparedStatement pStatement, News news) {
		pStatementSetFields(pStatement, news);
	}

	@Override
	public void pStatementForUpdate(PreparedStatement pStatement, News news) {
		try {
			pStatementSetFields(pStatement, news);
			pStatement.setInt(5, news.getNewsID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pStatementForDelete(PreparedStatement pStatement, News news) {
		try {
			pStatement.setInt(1, news.getNewsID());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<News> parseResultSet(ResultSet resultSet) {
		List<News> newsList = new ArrayList<News>();
		try {
			while (resultSet.next()) {
				News news = new News(resultSet.getInt("id"), resultSet.getString("topic"),
						resultSet.getDate("publication_date").toString(), resultSet.getString("news_text"),
						resultSet.getInt("user_id"));
				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsList;
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

	private void pStatementSetFields(PreparedStatement pStatement, News news) {
		try {
			pStatement.setString(1, news.getTopic());
			pStatement.setString(2, news.getPublicationDate());
			pStatement.setString(3, news.getNewsText());
			pStatement.setInt(4, news.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
