package by.news.service.daojpa.service.interf;

import by.news.service.daojpa.exception.DaoException;
import by.news.service.daojpa.pojos.User;
import by.news.service.vo.UserVO;

import java.util.Collection;

public interface UserService {
    int createUser(UserVO userVO) throws DaoException;

    UserVO getUserByPK(int key) throws DaoException;

    void updateUser(UserVO userVO) throws DaoException;

    //Collection<UserVO> getAll() throws DaoException;

}
