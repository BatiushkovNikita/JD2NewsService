package by.news.service.services.interf;

import java.util.List;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.entity.News;
import by.news.service.services.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface NewsService {
    Logger Log = LogManager.getLogger(AbstractDAO.class.getName());

    int addNews(News news) throws ServiceException;

    void deleteNews(int id) throws ServiceException;

    void updateNews(News news) throws ServiceException;

    List<News> getNewsFeed() throws ServiceException;

    News getNews(int id) throws ServiceException;

    GenericDAO<News, Integer> getNewsDAO() throws ServiceException;

    void setNewsDAO(GenericDAO<News, Integer> newsDAO);
}
