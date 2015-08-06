package by.news.service.services.impl;

import java.util.List;

import by.news.service.dao.impl.NewsDAOImpl;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.entity.News;
import by.news.service.services.interf.NewsService;

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

	public int addNews(String topic, String newsText, int userID) {
		String publicationDate = Utills.getCurrentDate();
		return newsDao.create(new News(topic, publicationDate, newsText, userID));
	}

	public void deleteNews(int id) {
		newsDao.delete(id);
	}

	public void updateNews(News news) {
		String publicationDate = Utills.getCurrentDate();
		news.setPublicationDate(publicationDate);
		newsDao.update(news);
	}

	public List<News> getAllNews() {
		return newsDao.getAll();
	}

	public News getNews(int id) {
		return newsDao.getByPK(id);
	}
}
