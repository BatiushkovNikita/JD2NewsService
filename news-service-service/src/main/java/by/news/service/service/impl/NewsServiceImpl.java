package by.news.service.service.impl;

import java.util.List;

import by.news.service.dao.database.impl.NewsDAOImpl;
import by.news.service.dao.database.interf.GenericDAO;
import by.news.service.entity.News;
import by.news.service.service.interf.NewsService;

public class NewsServiceImpl implements NewsService {
	private static volatile NewsServiceImpl instance;
	private GenericDAO<News, Integer> newsDao = NewsDAOImpl.getInstance();

	private NewsServiceImpl() {
	
	}

	public static synchronized NewsServiceImpl getInstance() {
		if (instance == null) {
			instance = new NewsServiceImpl();
		}
		return instance;
	}

	public int addNews(News news) {
		return newsDao.create(news);
	}

	public void deleteNews(int id) {
		// TODO Auto-generated method stub

	}

	public void updateNews(News news) {
		// TODO Auto-generated method stub

	}

	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return null;
	}

	public News getNews(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
