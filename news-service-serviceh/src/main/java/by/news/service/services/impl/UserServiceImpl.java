package by.news.service.services.impl;

import by.news.service.daoh.impl.UserDao;
import by.news.service.daoh.interf.BaseDao;
import by.news.service.daoh.util.JpaUtil;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.interf.UserService;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;
import net.sf.ehcache.CacheManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {

    private Logger Log = LogManager.getLogger(UserServiceImpl.class.getName());
    private BaseDao<UserVO, Integer> userDao;

    UserServiceImpl() throws ServiceException {
        getUserDao().setEntityManager(JpaUtil.INSTANCE.getEntityManager());
    }

    public BaseDao<UserVO, Integer> getUserDao() throws ServiceException {
        if (userDao == null) {
            Log.error("Cannot configured UserServiceImpl. UserDao is not submitted.");
            throw new ServiceException("Cannot configured UserServiceImpl. UserDao is not submitted.");
        }
        return userDao;
    }

    @Override
    public void setUserDao(BaseDao<UserVO, Integer> userDao) {
        this.userDao = userDao;
    }


    @Override
    public int registerUser(UserVO userVO) throws ServiceException {
        return getUserDao().create(userVO);
    }

    @Override
    public UserVO authorizeUser(UserVO userVO) throws ServiceException {
        return null;
    }

    @Override
    public void updateUser(UserVO user) throws ServiceException {

    }

    @Override
    public List<UserVO> getAllUsers() throws ServiceException {
        return null;
    }

    @Override
    public List<RoleVO> getUserRoles(int userId) throws ServiceException {
        return null;
    }

    public void cache() {
        CacheManager cacheManager = CacheManager.getInstance();
    }
}
