package by.news.service.service.interf;

import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;

import java.util.List;

public interface TagLocalService {

    List<NewsVO> getNewsesByTagName(String tagName);

    TagVO getTagById(int id);

    List<TagVO> getAllTags();
}
