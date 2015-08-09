package by.news.service.services.interf;

import java.util.List;

import by.news.service.dao.exception.DAOException;
import by.news.service.entity.Role;
import by.news.service.entity.User;
import by.news.service.services.exception.ServiceException;

public interface UserService {
	int registerUser(User user) throws ServiceException;
	
	User authorizationUser(String email, String Password) throws ServiceException;

	void updateUser(User user) throws ServiceException;

	List<User> getAllUsers() throws ServiceException;

	List<Role> getUserRoles(int user_id) throws ServiceException;
}
