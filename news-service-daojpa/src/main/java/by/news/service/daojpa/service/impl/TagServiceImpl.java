package by.news.service.daojpa.service.impl;

import by.news.service.daojpa.pojos.News;
import by.news.service.daojpa.pojos.Tag;
import by.news.service.daojpa.repository.TagRepository;
import by.news.service.daojpa.service.interf.TagService;
import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableTransactionManagement
public class TagServiceImpl implements TagService{

    private Logger Log = LogManager.getLogger(TagServiceImpl.class.getName());

    @Inject
    private TagRepository tagRepository;

    @Override
    public TagVO getTagByPK(int id) {
        Tag tag = tagRepository.findOne(id);
        return extractTag(tag);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TagVO> getAll() {
        List<Tag> tags = (List<Tag>) tagRepository.findAll();
        if (tags == null) {
            return null;
        }
        return extractTagsToTagsVo(tags);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NewsVO> getNewsByTag(String tagName) {
        List<News> newses = tagRepository.findByTag(tagName);
        return extractNewses(newses);
    }

    private TagVO extractTag(Tag tag) {
        TagVO tagVO = new TagVO();
        tagVO.setId(tag.getId());
        tagVO.setTagName(tag.getTagName());
        return tagVO;
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
