package by.news.service.web.validator.impl;

import by.news.service.vo.NewsVO;
import by.news.service.web.validator.interf.NewsChecks;
import org.springframework.validation.Errors;

public class NewsValidator extends AbstractValidator<NewsVO> {

    @Override
    public String getAttributeParam() {
        return "newsVOParam";
    }

    @Override
    public Class<?> getValidationMarker() {
        return NewsChecks.class;
    }

/*    public void validate(Object o, Errors errors) {
        NewsVO newsVO = (NewsVO) o;
        if (newsVO.getTagsVO() == null) {
            errors.rejectValue("tagsVO", "add.news.tagsVo.error");
        }
        super.validate(o, errors);
    }*/
}
