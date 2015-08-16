package by.news.service.web.command.impl;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.impl.NewsDAOImpl;
import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.interf.UserDAO;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.entity.News;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.impl.NewsServiceImpl;
import by.news.service.services.interf.NewsService;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Test {
	public static void main(String[] args) throws DAOException, ServiceException {
		System.out.println("dsd");

        addNews();

		//getAll();
		
		
		//getByPass();
		
		//getUserByPK();
	}

    private static void addNews() {
        Connection connection = ConnectionPool.getInstance().getConnection();
        AbstractDAO<News, Integer> newsDao = NewsDAOImpl.getInstance();
        newsDao.setConnection(connection);
        NewsService newsService = NewsServiceImpl.getInstance();
        newsService.setNewsDAO(newsDao);
        try {
            newsService.addNews(new News("AAAAAAAAA", getCurrentDate(), "BBBBBBBBB", 1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public static void getByPass() throws DAOException {
		UserDAO userDAO = UserDAOImpl.getInstance();
		userDAO.getUserByEmailAndPassword("bbb@gmail.com", "827ccb0eea8a706c4c34a16891f84e7b");
		
	}

    public static void getAll() throws ServiceException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        AbstractDAO<News, Integer> newsDao = NewsDAOImpl.getInstance();
        newsDao.setConnection(connection);
        NewsService newsService = NewsServiceImpl.getInstance();
        newsService.setNewsDAO(newsDao);
        List<News> newsFeed = newsService.getNewsFeed();
        System.out.println(newsFeed);
    }

}
