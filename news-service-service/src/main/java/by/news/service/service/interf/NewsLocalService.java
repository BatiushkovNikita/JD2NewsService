package by.news.service.service.interf;

import by.news.service.vo.NewsVO;

import java.util.List;

public interface NewsLocalService {

    int addNews(NewsVO newsVO);

    List<NewsVO> getAllNews();
}
