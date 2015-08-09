package by.news.service.services;

import by.news.service.services.exception.ServiceException;
import by.news.service.services.impl.NewsServiceImpl;
import by.news.service.services.interf.NewsService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		NewsService newsService = NewsServiceImpl.getInstance();
		try {
			newsService.addNews("dsdsd", "dsdsd", 1);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
