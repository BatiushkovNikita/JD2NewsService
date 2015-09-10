package by.news.service.daojpa.repository;

import by.news.service.daojpa.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*public interface UserRepository extends CrudRepository<User, Integer>{

}*/

@Transactional
@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public User findUser(int id) {
        System.out.println(entityManager);
        return entityManager.find(User.class, id);
    }
}
