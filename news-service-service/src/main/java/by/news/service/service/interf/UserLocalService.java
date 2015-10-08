package by.news.service.service.interf;

import by.news.service.vo.UserVO;

import java.util.List;

public interface UserLocalService {

    void editUser(UserVO userVO);

    int registerUser(UserVO userVO);

    UserVO getUserByEmail(String email);

    List<UserVO> getAllUsers();
}
