package by.news.service.service.impl;

import by.news.service.daojpa.service.interf.UserService;
import by.news.service.service.interf.UserLocalService;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;


public class UserLocalServiceImpl implements UserLocalService {

    @Inject
    private UserService userService;

    @Override
    public int registerUser(UserVO userVO) {
        Set<RoleVO> rolesVO = new HashSet<>();
        rolesVO.add(new RoleVO(3, "user"));
        userVO.setRoles(rolesVO);
        return userService.createUser(userVO);
    }
}
