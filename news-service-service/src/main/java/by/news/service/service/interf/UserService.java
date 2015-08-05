package by.news.service.service.interf;

import java.util.List;

import by.news.service.entity.Role;
import by.news.service.entity.User;

public interface UserService {
	int registerUser(User user); // CRUD create

	void updateUser(int id); // key in session UserDAO

	boolean isUserValid(String email, String Password);

	List<User> getAllUsers(); // CRUD

	List<Role> getUserRoles(int user_id);

}
