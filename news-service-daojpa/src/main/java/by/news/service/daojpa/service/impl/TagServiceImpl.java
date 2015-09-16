package by.news.service.daojpa.service.impl;

import by.news.service.daojpa.pojos.News;
import by.news.service.daojpa.pojos.Tag;
import by.news.service.daojpa.repository.TagRepository;
import by.news.service.daojpa.service.interf.NewsService;
import by.news.service.daojpa.service.interf.TagService;
import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagServiceImpl implements TagService{

    private Logger Log = LogManager.getLogger(TagServiceImpl.class.getName());

    @Inject
    private TagRepository tagRepository;

    @Override
    public List<NewsVO> getNewsByTag(String tagName) {
        List<News> newses = tagRepository.findByTag(tagName);
        return extractNewses(newses);
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
