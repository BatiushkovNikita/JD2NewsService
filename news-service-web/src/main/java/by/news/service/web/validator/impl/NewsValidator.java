package by.news.service.web.validator.impl;

import by.news.service.vo.NewsVO;
import by.news.service.web.validator.interf.NewsChecks;

import javax.validation.groups.Default;

public class NewsValidator extends AbstractValidator<NewsVO> {

    @Override
    public String getAttributeParam() {
        return "newsAttribute";
    }

    @Override
    public Class<?> getValidationMarker() {
        return NewsChecks.class;
    }
}
