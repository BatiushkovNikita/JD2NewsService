package by.news.service.daoh.impl;

import by.news.service.to.User;


public class UserDaoImpl extends AbstractDao<User, Integer>{

    @Override
    protected Class getPersistentClass() {
        return User.class;
    }

}
