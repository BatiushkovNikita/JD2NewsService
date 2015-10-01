package by.news.service.service.interf;

import by.news.service.vo.UserVO;

public interface UserLocalService {

    int registerUser(UserVO userVO);

    UserVO getUserByEmail(String email);
}
