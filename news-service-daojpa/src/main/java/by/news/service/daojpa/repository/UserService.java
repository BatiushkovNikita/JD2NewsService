package by.news.service.daojpa.repository;

import by.news.service.daojpa.pojos.User;

public interface UserService {
    User getByPK(Integer key);
}
