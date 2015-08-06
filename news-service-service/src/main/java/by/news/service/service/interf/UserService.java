package by.news.service.service.interf;

import java.util.List;

import by.news.service.entity.Role;
import by.news.service.entity.User;

public interface UserService {
	int registerUser(User user); // CRUD create

	void updateUser(User user); // key in session UserDAO

	boolean isValidUser(String email, String Password);

	List<User> getAllUsers(); // CRUD

	List<Role> getUserRoles(int user_id);

}
