package by.news.service.web.validator;

import by.news.service.vo.NewsVO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class NewsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NewsVO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "topic", "frag.userdata.topic.error.input");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newsText", "frag.userdata.newsText.error.input");
    }
}
