package by.news.service.service.impl;

import by.news.service.daojpa.service.interf.UserService;
import by.news.service.service.interf.SecurityService;
import by.news.service.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Inject
    private UserService userService;

    public SecurityServiceImpl() {

    }

    @Override
    public void getUser(int id) {
        UserVO user = userService.getUserByPK(id);
        System.out.println(user);
    }
}
