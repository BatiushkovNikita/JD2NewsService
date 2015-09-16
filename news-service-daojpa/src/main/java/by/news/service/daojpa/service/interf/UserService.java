package by.news.service.daojpa.service.interf;

import by.news.service.vo.UserVO;

public interface UserService {

    int createUser(UserVO userVO);

    UserVO getUserByPK(int key);

    void updateUser(UserVO userVO);

    //Collection<UserVO> getAll();

}
