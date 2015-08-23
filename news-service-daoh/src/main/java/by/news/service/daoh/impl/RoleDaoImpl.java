package by.news.service.daoh.impl;


import by.news.service.daoh.pojos.Role;

public class RoleDaoImpl extends AbstractDao<Role, Integer>{

    @Override
    protected Class getPersistentClass() {
        return Role.class;
    }
}
