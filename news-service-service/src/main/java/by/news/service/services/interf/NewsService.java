package by.news.service.services.interf;

import java.util.List;

import by.news.service.dao.exception.DAOException;
import by.news.service.entity.News;
import by.news.service.services.exception.ServiceException;

public interface NewsService {
	int addNews(News news) throws ServiceException;

	void deleteNews(int id) throws ServiceException;

	void updateNews(News news) throws ServiceException;

	List<News> getNewsFeed() throws ServiceException;

	News getNews(int id) throws ServiceException;
}
