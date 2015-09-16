package by.news.service.services.interf;

import java.util.List;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.dao.interf.UserDAO;
import by.news.service.entity.Role;
import by.news.service.entity.User;
import by.news.service.services.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface UserService {
    Logger Log = LogManager.getLogger(AbstractDAO.class.getName());

    int registerUser(User user) throws ServiceException;

    User authorizeUser(User user) throws ServiceException;

    void updateUser(User user) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    List<Role> getUserRoles(int userId) throws ServiceException;

    void setUserDAO(UserDAO userDAO);

    void setUserGenericDAO(GenericDAO<User, Integer> userGenericDAO);
}
