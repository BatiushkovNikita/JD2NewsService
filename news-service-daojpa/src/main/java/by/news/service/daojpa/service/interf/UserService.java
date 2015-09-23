package by.news.service.daojpa.service.interf;

import by.news.service.vo.UserVO;

public interface UserService {

    int createUser(UserVO userVO);

    UserVO getUserByPK(int key);

    UserVO getUserByEmail(String email);

    void updateUser(UserVO userVO);

    //Collection<UserVO> getAll();

}
