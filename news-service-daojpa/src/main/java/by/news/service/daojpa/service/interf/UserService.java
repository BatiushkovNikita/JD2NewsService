package by.news.service.daojpa.service.interf;

import by.news.service.vo.UserVO;

import java.util.List;

public interface UserService {

    int createUser(UserVO userVO);

    UserVO getUserByPK(int key);

    UserVO getUserByEmail(String email);

    void updateUser(UserVO userVO);

    List<UserVO> getAll();
}
