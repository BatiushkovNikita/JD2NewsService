package by.news.service.daoh.impl;

import by.news.service.daoh.pojos.User;
import by.news.service.daoh.pojos.UserDetail;

import javax.persistence.EntityManager;

public class UserService {

    private EntityManager entityManager;

    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User createUser(String email, String password) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        entityManager.persist(user);
        return user;

        //One to one

        /*UserDetail userDetail = new UserDetail();
        userDetail.setFirstName("RQRRQRQR");
        userDetail.setLastName("dsdsds");
        userDetail.setPhoneNumber("9494949494");

        User user = new User();
        user.setUserDetail(userDetail);
        user.setPassword(password);
        user.setEmail(email);

        entityManager.persist(user);*/
      /*  return user;*/


    }

    public UserDetail createUserDetail(int id, String firstName, String lastName, String phone) {
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(id);
        userDetail.setFirstName(firstName);
        userDetail.setLastName(lastName);
        userDetail.setPhoneNumber(phone);
        entityManager.persist(userDetail);
        return userDetail;
    }
}
