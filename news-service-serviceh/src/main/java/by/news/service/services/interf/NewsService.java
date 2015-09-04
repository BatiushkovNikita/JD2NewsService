package by.news.service.services.interf;

import by.news.service.daoh.interf.BaseDao;
import by.news.service.services.exception.ServiceException;
import by.news.service.vo.NewsVO;

import java.util.List;

public interface NewsService {

    int addNews(NewsVO newsVO) throws ServiceException;

    void deleteNews(int id) throws ServiceException;

    void updateNews(NewsVO newsVO) throws ServiceException;

    List<NewsVO> getNewsFeed() throws ServiceException;

    NewsVO getNews(int id) throws ServiceException;

    BaseDao<NewsVO, Integer> getNewsDao() throws ServiceException;

    void setNewsDao(BaseDao<NewsVO, Integer> newsDao);
}
