package by.news.service.service.impl;

import by.news.service.daojpa.service.interf.TagService;
import by.news.service.service.interf.TagLocalService;
import by.news.service.vo.TagVO;

import javax.inject.Inject;
import java.util.Set;

public class TagLocalServiceImpl implements TagLocalService {

    @Inject
    private TagService tagService;

    @Override
    public Set<TagVO> getAllTags() {
        return tagService.getAll();
    }
}
