package by.news.service.service.impl;

import by.news.service.daojpa.service.interf.UserService;
import by.news.service.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Inject
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserVO userVO = userService.getUserByEmail(email);
        return userVO;
    }
}
