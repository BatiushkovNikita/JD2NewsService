package by.news.service.daojpa.repository;

import by.news.service.daojpa.pojos.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public User findUser(int id) {
        System.out.println(entityManager);
        return entityManager.find(User.class, id);
    }
/*
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }*/

    public void save(List<User> users) {
        for (User user : users) {
            entityManager.persist(user);
        }
    }
}
