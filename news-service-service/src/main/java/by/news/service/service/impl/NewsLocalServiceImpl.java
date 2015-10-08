package by.news.service.service.impl;

import by.news.service.daojpa.service.interf.NewsService;
import by.news.service.service.interf.NewsLocalService;
import by.news.service.vo.NewsVO;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class NewsLocalServiceImpl implements NewsLocalService {

    @Inject
    private NewsService newsService;

    @Override
    public NewsVO getNewsById(int id) {
        return newsService.getNewsByPK(id);
    }

    @Override
    public void deleteNews(int id) {
        newsService.deleteNews(id);
    }

    @Override
    public int addNews(NewsVO newsVO) {
        newsVO.setPublicationDate(getCurrentDate());
        return newsService.createNews(newsVO);
    }

    @Override
    public List<NewsVO> getAllNews() {
        return newsService.getAll();
    }


    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
