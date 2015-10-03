package by.news.service.web.validator.impl;

import by.news.service.vo.NewsVO;

public class NewsValidator extends AbstractValidator<NewsVO> {

    @Override
    public String getAttributeParam() {
        return null;
    }

    @Override
    public Class<?> getValidationMarker() {
        return null;
    }
}
