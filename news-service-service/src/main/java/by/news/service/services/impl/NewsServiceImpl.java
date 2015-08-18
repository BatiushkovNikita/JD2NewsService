package by.news.service.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.entity.News;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.interf.NewsService;

public class NewsServiceImpl implements NewsService {
	private static volatile NewsServiceImpl instance;
	private GenericDAO<News, Integer> newsDAO;
	
	private NewsServiceImpl() {
		
	}
	
	public static synchronized NewsServiceImpl getInstance() {
		if (instance == null) {
			instance = new NewsServiceImpl();
		}
		return instance;
	}

    @Override
	public int addNews(News news) throws ServiceException {
		Log.info("Adding News to news feed");
		int key = 0;
		try {
			key = getNewsDAO().create(news);
		} catch (DAOException e) {
			Log.error("Cannot add news to the news feed", e);
			throw new ServiceException("Cannot add news to the news feed", e);
		}
		Log.info("News was added with key: " + key);
		return key;
	}

    @Override
	public void deleteNews(int id) throws ServiceException {
		Log.info("Deleting News by id: " + id);
		try {
			getNewsDAO().delete(id);
		} catch (DAOException e) {
			Log.error("Cannot delete News with id: " + id, e);
			throw new ServiceException("Cannot delete News with id: " + id, e);
		}
		Log.info("News with id: " + id + " was deleted");
	}

    @Override
	public void updateNews(News news) throws ServiceException {
		Log.info("Updating News with id " + news.getNewsID());
		String publicationDate = Utills.getCurrentDate();
		news.setPublicationDate(publicationDate);
		try {
			getNewsDAO().update(news);
		} catch (DAOException e) {
			Log.error("Cannot update News with id: " + news.getNewsID(), e);
			throw new ServiceException("Cannot update News with id: " + news.getNewsID(), e);
		}
		Log.info("News with id " + news.getNewsID() + " was updated");
	}

    @Override
	public List<News> getNewsFeed() throws ServiceException {
		Log.info("Getting news feed");
		List<News> newsFeed;
		try {
			newsFeed = getNewsDAO().getAll();
		} catch (DAOException e) {
			Log.error("Cannot get news feed", e);
			throw new ServiceException("Cannot get news feed", e);
		}
		Log.info("Returning news feed");
		return newsFeed;
	}

    @Override
	public News getNews(int id) throws ServiceException {
		Log.info("Getting News by id: " + id);
		News news = null;
		try {
			news = getNewsDAO().getByPK(id);
		} catch (DAOException e) {
			Log.error("Cannot get News with id: " + id, e);
			throw new ServiceException("Cannot get News with id: " + id, e);
		}
		Log.info("Returning News with id: " + id);
		return news;
	}

    @Override
	public GenericDAO<News, Integer> getNewsDAO() throws ServiceException {
		if (newsDAO == null) {
			Log.error("Cannot configured NewsService. NewsDAO is not submitted.");
			throw new ServiceException("Cannot configured NewsService. NewsDAO is not submitted.");
		}
		return newsDAO;
	}

	public void setNewsDAO(GenericDAO<News, Integer> newsDAO) {
		this.newsDAO = newsDAO;
	}
}
