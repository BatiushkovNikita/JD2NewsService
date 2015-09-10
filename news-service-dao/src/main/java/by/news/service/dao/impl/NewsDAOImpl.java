package by.news.service.dao.impl;

import by.news.service.entity.News;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDAOImpl extends AbstractDAO<News, Integer> {
	private static volatile NewsDAOImpl instance;

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
		return QUERIES.getString("insert.query.news");
	}

	@Override
	public String getSelectQuery() {
		return QUERIES.getString("select.query.news");
	}

	@Override
	public String getUpdateQuery() {
		return QUERIES.getString("update.query.news");
	}

	@Override
	public String getDeleteQuery() {
		return QUERIES.getString("delete.query.news");
	}

	@Override
	public void pStatementForInsert(PreparedStatement pStatement, News news) {
        try {
            pStatement.setString(1, news.getTopic());
            pStatement.setString(2, news.getPublicationDate());
            pStatement.setString(3, news.getNewsText());
            pStatement.setInt(4, news.getUserID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
	public List<News> parseResultSet(ResultSet resultSet) {
		Log.trace("Create news for insert");
		List<News> newsList = new ArrayList<News>();
		try {
			while (resultSet.next()) {
				News news = new News(
						resultSet.getInt("id"), 
						resultSet.getString("topic"),
						resultSet.getDate("publication_date").toString(), 
						resultSet.getString("news_text"),
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
