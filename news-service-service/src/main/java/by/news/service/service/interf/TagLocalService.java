package by.news.service.service.interf;

import by.news.service.vo.TagVO;

import java.util.List;

public interface TagLocalService {

    TagVO getTagById(int id);

    List<TagVO> getAllTags();
}
