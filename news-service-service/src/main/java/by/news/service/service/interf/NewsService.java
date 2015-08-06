package by.news.service.service.interf;

import java.util.List;

import by.news.service.entity.News;

public interface NewsService {
	int addNews(String topic, String newsText, int userID);

	void deleteNews(int id);

	void updateNews(News news);

	List<News> getAllNews();

	News getNews(int id);
}
