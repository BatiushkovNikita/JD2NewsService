package by.news.service.web.validator.impl;

import by.news.service.vo.UserVO;
import by.news.service.web.validator.interf.UserChecks;

public class UserValidator extends AbstractValidator<UserVO> {

    @Override
    public String getAttributeParam() {
        return "userVOParam";
    }

    @Override
    public Class<?> getValidationMarker() {
        return UserChecks.class;
    }
}
