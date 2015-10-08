package by.news.service.service.interf;

import by.news.service.vo.NewsVO;

import java.util.List;

public interface NewsLocalService {

    NewsVO getNewsById(int id);

    void deleteNews(int id);

    int addNews(NewsVO newsVO);

    List<NewsVO> getAllNews();
}
