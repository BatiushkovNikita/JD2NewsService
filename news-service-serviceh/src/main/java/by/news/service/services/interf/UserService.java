package by.news.service.services.interf;

import by.news.service.daoh.impl.UserDao;
import by.news.service.daoh.interf.BaseDao;
import by.news.service.services.exception.ServiceException;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;

import java.util.List;

public interface UserService {

    int registerUser(UserVO userVO) throws ServiceException;

    UserVO authorizeUser(UserVO userVO) throws ServiceException;

    void updateUser(UserVO user) throws ServiceException;

    List<UserVO> getAllUsers() throws ServiceException;

    List<RoleVO> getUserRoles(int userId) throws ServiceException;

    BaseDao<UserVO, Integer> getUserDao() throws ServiceException;

    void setUserDao(BaseDao<UserVO, Integer> userDao);
}
