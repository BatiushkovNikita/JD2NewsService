package by.news.service.daojpa.service.impl;


import by.news.service.daojpa.pojos.News;
import by.news.service.daojpa.pojos.Tag;
import by.news.service.daojpa.repository.NewsRepository;
import by.news.service.daojpa.service.interf.NewsService;
import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableTransactionManagement
public class NewsServiceImpl implements NewsService {

    private Logger Log = LogManager.getLogger(NewsServiceImpl.class.getName());

    @Inject
    private NewsRepository newsRepository;


    @Override
    @Transactional
    public int createNews(NewsVO newsVO) {
        News news = extractNews(newsVO);
        News news1 = newsRepository.save(news);
        return news1.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public NewsVO getNewsByPK(int key) {
        News news = newsRepository.findOne(key);
        if (news == null) {
            return null;
        }
        return extractNews(news);
    }

    @Override
    @Transactional
    public void updateNews(NewsVO newsVO) {
        News news = extractNews(newsVO);
        newsRepository.save(news);
    }

    @Override
    @Transactional
    public void deleteNews(int key) {
        newsRepository.delete(key);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NewsVO> getAll() {
        List<News> newses = (List<News>) newsRepository.findAll(new Sort(Sort.Direction.DESC, "publicationDate"));
        if (newses == null) {
            return null;
        }
        return extractNewses(newses);
    }

    private News extractNews(NewsVO newsVO) {
        News news = new News();
        news.setTopic(newsVO.getTopic());
        news.setPublicationDate(newsVO.getPublicationDate());
        news.setNewsText(newsVO.getNewsText());
        news.setUserId(newsVO.getUserId());
        List<Tag> tags = extractTagsVoToTags(newsVO.getTagsVO());
        news.setTags(tags);
        return news;
    }

    private NewsVO extractNews(News news) {
        int id = news.getId();
        String topic = news.getTopic();
        String publicationDate = news.getPublicationDate();
        String newsText = news.getNewsText();
        String authorFirsName = news.getUser().getUserDetail().getFirstName();
        String authorLastName = news.getUser().getUserDetail().getLastName();
        List<TagVO> tagsVO = extractTagsToTagsVo(news.getTags());
        return new NewsVO(id, topic, publicationDate, newsText, authorFirsName, authorLastName, tagsVO);
    }

    private List<TagVO> extractTagsToTagsVo(List<Tag> tags) {
        List<TagVO> tagsVO = new ArrayList<>();
        for (Tag tag : tags) {
            TagVO tagVO = new TagVO();
            tagVO.setId(tag.getId());
            tagVO.setTagName(tag.getTagName());
            tagsVO.add(tagVO);
        }
        return tagsVO;
    }

    private List<Tag> extractTagsVoToTags(List<TagVO> tagsVO) {
        List<Tag> tags = new ArrayList<>();
        for (TagVO tagVO : tagsVO) {
            Tag tag = new Tag();
            tag.setId(tagVO.getId());
            tag.setTagName(tagVO.getTagName());
            tags.add(tag);
        }
        return tags;
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
