package by.news.service.dao.interf;

import java.util.List;

import by.news.service.dao.exception.DAOException;
import by.news.service.entity.Role;
import by.news.service.entity.User;

public interface UserDAO {
	User getUserByEmail(String email) throws DAOException;
	
	List<Role> getUserRoles(int user_id) throws DAOException;
}
