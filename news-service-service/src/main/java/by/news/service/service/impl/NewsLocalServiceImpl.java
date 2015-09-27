package by.news.service.service.impl;

import by.news.service.daojpa.service.interf.NewsService;
import by.news.service.service.interf.NewsLocalService;
import by.news.service.vo.NewsVO;

import javax.inject.Inject;
import java.util.List;

public class NewsLocalServiceImpl implements NewsLocalService {

    @Inject
    private NewsService newsService;

    @Override
    public List<NewsVO> getAllNews() {
        return newsService.getAll();
    }
}
