package by.news.service.service.impl;

import by.news.service.daojpa.service.interf.TagService;
import by.news.service.service.interf.TagLocalService;
import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;

import javax.inject.Inject;
import java.util.List;

public class TagLocalServiceImpl implements TagLocalService {

    @Inject
    private TagService tagService;

    @Override
    public List<NewsVO> getNewsesByTagName(String tagName) {
        return tagService.getNewsByTag(tagName);
    }

    @Override
    public TagVO getTagById(int id) {
        return tagService.getTagByPK(id);
    }

    @Override
    public List<TagVO> getAllTags() {
        return tagService.getAll();
    }
}
