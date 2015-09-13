package by.news.service.daojpa.repository.interf;

import by.news.service.daojpa.pojos.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
