package by.news.service.dao.interf;

import by.news.service.entity.User;

public interface UserDAO {
	User getUserByEmail(String email);
}