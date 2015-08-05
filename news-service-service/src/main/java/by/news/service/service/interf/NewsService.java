package by.news.service.service.interf;

import java.util.List;

import by.news.service.entity.News;

public interface NewsService {
	int addNews(News news); // CRUD

	void deleteNews(int id); // CRUD remake by PK

	void updateNews(News news); // CRUD

	List<News> getAllNews(); // CRUD

	News getNews(int id); // CRUD

	/*String getCurrentDate();*/ // must be in addNews
}
