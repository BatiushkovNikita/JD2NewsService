package by.news.service.daojpa.service.interf;

import by.news.service.vo.NewsVO;

import java.util.List;

public interface TagService {

    List<NewsVO> getNewsByTag(String tagName);
}
