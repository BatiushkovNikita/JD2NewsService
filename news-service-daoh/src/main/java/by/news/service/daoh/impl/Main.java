package by.news.service.daoh.impl;

import by.news.service.daoh.util.JpaUtil;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.setEntityManager(JpaUtil.INSTANCE.getEntityManager());
        System.out.println(userDao.getByPK(1));
        //System.out.println(userDao.getByPK(2));



        UserVO userVO = new UserVO("email1", "password1", "FirstName1", "LastName1", "1234567890");
        userDao.create(userVO);
    }
}
