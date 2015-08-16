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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class AddNewsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nextPage = "jsp/addnews.jsp";
        News news = validate(request);
        if (news != null) {
            Connection connection = ConnectionPool.getInstance().getConnection();
            AbstractDAO<News, Integer> newsDao = NewsDAOImpl.getInstance();
            newsDao.setConnection(connection);
            NewsService newsService = NewsServiceImpl.getInstance();
            newsService.setNewsDAO(newsDao);
            try {
                newsService.addNews(news);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            nextPage = "Controller?command=news_feed";
        } else {
            request.setAttribute("errorNewsInput", "Wrong input");
        }

        return nextPage;
	}

    private News validate(HttpServletRequest request) {
        String topic = request.getParameter("topic");
        String newsText = request.getParameter("newsText");
        if (Objects.equals(topic, "") || Objects.equals(newsText, "")) {
            return null;
        }
        return new News(topic, getCurrentDate(), newsText, 1);
    }

    private static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
