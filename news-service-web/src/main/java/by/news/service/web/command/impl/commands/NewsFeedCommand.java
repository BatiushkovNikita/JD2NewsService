package by.news.service.web.command.impl.commands;

import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.impl.NewsDAOImpl;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.entity.News;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.impl.NewsServiceImpl;
import by.news.service.services.interf.NewsService;
import by.news.service.web.command.impl.AbstractCommand;
import by.news.service.web.command.interf.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public class NewsFeedCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nextPage = ResourceBundle.getBundle("resources").getString("page.news.feed");
        List<News> newsFeed = null;
        Log.debug("Getting news");
        try {
            newsFeed = getNewsFeed();
        } catch (ServiceException e) {
            errorHandling(request, "Cannot getting news", e);
        }
        request.setAttribute("newsFeed", newsFeed);
        return nextPage;
    }

    private List<News> getNewsFeed() throws ServiceException {
        AbstractDAO<News, Integer> newsDao = NewsDAOImpl.getInstance();
        newsDao.setConnection(connection);
        NewsService newsService = NewsServiceImpl.getInstance();
        newsService.setNewsDAO(newsDao);
        return newsService.getNewsFeed();
    }
}
