package by.news.service.daojpa.service.impl;


import by.news.service.daojpa.exp.BenchmarkMethods;
import by.news.service.daojpa.pojos.News;
import by.news.service.daojpa.pojos.Tag;
import by.news.service.daojpa.repository.NewsRepository;
import by.news.service.daojpa.service.interf.NewsService;
import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@BenchmarkMethods
public class NewsServiceImpl implements NewsService {

    private Logger Log = LogManager.getLogger(NewsServiceImpl.class.getName());

    @Inject
    private NewsRepository newsRepository;


    @Override
    public int createNews(NewsVO newsVO) {
        News news = extractNews(newsVO);
        News news1 = newsRepository.save(news);
        return news1.getId();
    }

    @Override
    public NewsVO getNewsByPK(int key) {
        News news = newsRepository.findOne(key);
        if (news == null) {
            return null;
        }
        return extractNews(news);
    }

    @Override
    public void updateNews(NewsVO newsVO) {
        News news = extractNews(newsVO);
        newsRepository.save(news);
    }

    @Override
    public void deleteNews(int key) {
        newsRepository.delete(key);
    }

    @Override
    public List<NewsVO> getAll() {
        List<News> newses = (List<News>) newsRepository.findAll();
        if (newses == null) {
            return null;
        }
        return extractNewses(newses);
    }

    private News extractNews(NewsVO newsVO) {
        News news = new News();
        news.setTopic(newsVO.getTopic());
        news.setPublicationDate(newsVO.getPublicationDate());
        news.setTopic(newsVO.getPublicationDate());
        return news;
    }

    private NewsVO extractNews(News news) {
        int id = news.getId();
        String topic = news.getTopic();
        String publicationDate = news.getPublicationDate();
        String newsText = news.getNewsText();
        String authorFirsName = news.getUser().getUserDetail().getFirstName();
        String authorLastName = news.getUser().getUserDetail().getLastName();
        Set<TagVO> tagsVO = extractTags(news.getTags());
        return new NewsVO(id, topic, publicationDate, newsText, authorFirsName, authorLastName, tagsVO);
    }

    private Set<TagVO> extractTags(Set<Tag> tags) {
        Set<TagVO> tagsVO = new HashSet<>();
        for (Tag tag : tags) {
            TagVO tagVO = new TagVO();
            tagVO.setId(tag.getId());
            tagVO.setTagName(tag.getTagName());
            tagsVO.add(tagVO);
        }
        return tagsVO;
    }

    private List<NewsVO> extractNewses(List<News> newses) {
        List<NewsVO> newsVOs = new ArrayList<>();
        for (News news : newses) {
            NewsVO newsVO = extractNews(news);
            newsVOs.add(newsVO);
        }
        return newsVOs;
    }
}
