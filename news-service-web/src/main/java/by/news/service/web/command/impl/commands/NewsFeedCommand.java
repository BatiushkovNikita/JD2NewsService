package by.news.service.web.command.impl.commands;

import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.impl.NewsDAOImpl;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.entity.News;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.impl.NewsServiceImpl;
import by.news.service.services.interf.NewsService;
import by.news.service.web.command.interf.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;

public class NewsFeedCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nextPage = "/jsp/newsfeed.jsp";
        Connection connection = ConnectionPool.getInstance().getConnection();
        AbstractDAO<News, Integer> newsDao = NewsDAOImpl.getInstance();
        newsDao.setConnection(connection);
        NewsService newsService = NewsServiceImpl.getInstance();
        newsService.setNewsDAO(newsDao);
        List<News> newsFeed;
        try {
            newsFeed = newsService.getNewsFeed();
            request.setAttribute("newsFeed", newsFeed);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute("testValue", "Primerrerere");
        return nextPage;
    }
}
