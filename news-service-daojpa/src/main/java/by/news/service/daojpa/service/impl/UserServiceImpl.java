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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private Logger Log = LogManager.getLogger(UserServiceImpl.class.getName());

    @Inject
    private UserRepository userRepository;

    @Override
    public int createUser(UserVO userVO) {
        User user = extractUser(userVO);
        User user1 = userRepository.save(user);
        return user1.getId();
    }

    @Override
    public UserVO getUserByPK(int key) {
        return extractUser(userRepository.findOne(key));
    }

    @Override
    public void updateUser(UserVO userVO) {
        User user = extractUser(userVO);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user;
        try {
            user = userRepository.findByEmail(email);
        } catch (UsernameNotFoundException e) {
            Log.error("User with email: " + email + " not found", e);
            throw new UsernameNotFoundException("User with email: " + email + " not found", e);
        }
        return user;
    }

    private User extractUser(UserVO userVO) {
        User user = new User();
        user.setId(userVO.getId());
        user.setEmail(userVO.getEmail());
        user.setPassword("");
        user.setUserDetail(extractUserDetail(userVO));
        user.setRoles(extractRoles(userVO.getRoles()));
        return user;
    }

    private UserDetail extractUserDetail(UserVO userVO) {
        UserDetail userDetail = new UserDetail();
        userDetail.setFirstName(userVO.getFirstName());
        userDetail.setLastName(userVO.getLastName());
        userDetail.setCellPhone(userVO.getCellPhone());
        return userDetail;
    }

    private UserVO extractUser(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setEmail(user.getEmail());
        //userVO.setPassword(null);
        userVO.setPassword("");
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
