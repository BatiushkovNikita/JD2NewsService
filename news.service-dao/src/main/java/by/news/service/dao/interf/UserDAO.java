package by.news.service.dao.interf;

import java.util.List;

import by.news.service.dao.exception.DAOException;
import by.news.service.entity.Role;
import by.news.service.entity.User;

public interface UserDAO extends GenericDAO<User, Integer> {
	User getUserByEmailAndPassword(String email, String password) throws DAOException;
	
	List<Role> getUserRoles(int user_id) throws DAOException;
}
