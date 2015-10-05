package by.news.service.web.validator.impl;

import by.news.service.vo.NewsVO;
import by.news.service.web.validator.interf.NewsChecks;

public class NewsValidator extends AbstractValidator<NewsVO> {

    @Override
    public String getAttributeParam() {
        return "newsVOParam";
    }

    @Override
    public Class<?> getValidationMarker() {
        return NewsChecks.class;
    }
}
