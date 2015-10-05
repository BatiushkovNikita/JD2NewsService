package by.news.service.daojpa.service.interf;

import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;

import java.util.List;

public interface TagService {

    List<TagVO> getAll();

    List<NewsVO> getNewsByTag(String tagName);
}
