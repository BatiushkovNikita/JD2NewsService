package by.news.service.daojpa.service.impl;


import by.news.service.daojpa.pojos.Role;
import by.news.service.daojpa.pojos.User;
import by.news.service.daojpa.pojos.UserDetail;
import by.news.service.daojpa.repository.UserRepository;
import by.news.service.daojpa.service.interf.UserService;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService {

    private Logger Log = LogManager.getLogger(UserServiceImpl.class.getName());

    @Inject
    private UserRepository userRepository;

    @Override
    @Transactional
    public int createUser(UserVO userVO) {
        User user = extractUser(userVO);
        User user1 = userRepository.save(user);
        return user1.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public UserVO getUserByPK(int key) {
        return extractUser(userRepository.findOne(key));
    }

    @Override
    @Transactional(readOnly = true)
    public UserVO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        return extractUser(user);
    }

    @Override
    @Transactional
    public void updateUser(UserVO userVO) {
        User user = extractUser(userVO);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserVO> getAll() {
        Iterable<User> users = userRepository.findAll();
        List<UserVO> usersVO = new ArrayList<>();
        for (User user : users) {
            UserVO userVO = extractUser(user);
            usersVO.add(userVO);
        }
        return usersVO;
    }

    private User extractUser(UserVO userVO) {
        User user = new User();
        user.setId(userVO.getId());
        user.setEmail(userVO.getEmail());
        user.setPassword(userVO.getPassword());
        user.setUserDetail(extractUserDetail(userVO));
        Set<RoleVO> roles = userVO.getRoles();
        if (roles != null) {
            user.setRoles(extractRoles(roles));
        }
        return user;
    }

    private UserDetail extractUserDetail(UserVO userVO) {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(userVO.getId());
        userDetail.setFirstName(userVO.getFirstName());
        userDetail.setLastName(userVO.getLastName());
        userDetail.setCellPhone(userVO.getCellPhone());
        return userDetail;
    }

    private UserVO extractUser(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setEmail(user.getEmail());
        userVO.setPassword(user.getPassword());
        userVO.setFirstName(user.getUserDetail().getFirstName());
        userVO.setLastName(user.getUserDetail().getLastName());
        userVO.setCellPhone(user.getUserDetail().getCellPhone());
        userVO.setRoles(extractRole(user.getRoles()));
        return userVO;
    }

    private Set<RoleVO> extractRole(Set<Role> roles) {
        Set<RoleVO> rolesVO = new HashSet<>();
        for (Role role : roles) {
            RoleVO roleVO = new RoleVO();
            roleVO.setId(role.getId());
            roleVO.setRoleName(role.getRoleName());
            rolesVO.add(roleVO);
        }
        return rolesVO;
    }

    private Set<Role> extractRoles(Set<RoleVO> rolesVO) {
        Set<Role> roles = new HashSet<>();
        for (RoleVO roleVO : rolesVO) {
            Role role = new Role();
            role.setId(roleVO.getId());
            role.setRoleName(roleVO.getRoleName());
            roles.add(role);
        }
        return roles;
    }
}
