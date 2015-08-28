package by.news.service.daoh.impl;

import by.news.service.daoh.pojos.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaBasicsTutorial {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewsService");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserService userService = new UserService(entityManager);

        System.out.println("Persist");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = userService.createUser("AAdsdsA", "dsdsBBB");
        transaction.commit();

        entityManager.close();
        System.out.println(user);
    }
}
