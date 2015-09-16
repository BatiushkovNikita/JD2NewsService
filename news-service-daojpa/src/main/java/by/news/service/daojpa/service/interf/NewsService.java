package by.news.service.daojpa.service.interf;

import by.news.service.vo.NewsVO;

import java.util.List;

public interface NewsService {

    int createNews(NewsVO newsVO);

    NewsVO getNewsByPK(int key);

    void updateNews(NewsVO newsVO);

    void deleteNews(int key);

    List<NewsVO> getAll();
}
