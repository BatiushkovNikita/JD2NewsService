package by.news.service.service.impl;

import by.news.service.daojpa.service.interf.UserService;
import by.news.service.service.interf.UserLocalService;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserLocalServiceImpl implements UserLocalService {

    private Logger Log = LogManager.getLogger(UserLocalServiceImpl.class.getName());

    @Inject
    private UserService userService;

    @Override
    public void editUser(UserVO userVO) {
        userService.updateUser(userVO);
    }

    @Override
    public int registerUser(UserVO userVO) {
        Set<RoleVO> rolesVO = new HashSet<>();
        rolesVO.add(new RoleVO(3, "user"));
        Log.error("Set default user role");
        userVO.setRoles(rolesVO);
        return userService.createUser(userVO);
    }

    @Override
    public UserVO getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<UserVO> getAllUsers() {
        return userService.getAll();
    }
}
