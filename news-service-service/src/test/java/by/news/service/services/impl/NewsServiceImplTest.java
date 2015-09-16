package by.news.service.services.impl;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.NewsDAOImpl;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.entity.News;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.interf.NewsService;

public class NewsServiceImplTest {
	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery() {
		{
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};

	private GenericDAO<News, Integer> newsDAO;
	private NewsService newsService = NewsServiceImpl.getInstance();

	@Before
	public void setUp() throws Exception {
		newsDAO = context.mock(NewsDAOImpl.class);
		newsService.setNewsDAO(newsDAO);
	}

	final int newsID = 12345;
	final String topic = "Topic";
	final String publicationDate = "2015-08-09 13:16:49";
	final String newsText = "News text";
	final int userID = 12345;
	News news = new News(newsID, topic, publicationDate, newsText, userID);

	@Test
	public void addNewsTest() throws ServiceException, DAOException {
		context.checking(new Expectations() {
			{
				oneOf(newsDAO).create(news);
				will(returnValue(newsID));
			}
		});
		newsService.addNews(news);
	}
}
