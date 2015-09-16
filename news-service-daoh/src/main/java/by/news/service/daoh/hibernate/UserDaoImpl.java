package by.news.service.daoh.hibernate;


import by.news.service.daoh.pojos.User;

public class UserDaoImpl extends AbstractDao<User, Integer>{

    @Override
    protected Class getPersistentClass() {
        return User.class;
    }


}
