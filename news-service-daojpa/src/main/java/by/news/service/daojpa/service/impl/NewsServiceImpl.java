package by.news.service.daojpa.service.impl;


import by.news.service.daojpa.repository.interf.NewsRepository;
import by.news.service.daojpa.service.interf.NewsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    private Logger Log = LogManager.getLogger(NewsServiceImpl.class.getName());

    @Autowired
    private NewsRepository newsRepository;


}
