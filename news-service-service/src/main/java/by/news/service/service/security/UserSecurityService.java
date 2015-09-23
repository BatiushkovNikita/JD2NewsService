package by.news.service.service.security;

import by.news.service.daojpa.service.interf.UserService;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserSecurityService implements UserDetailsService {

    private Logger Log = LogManager.getLogger(UserSecurityService.class.getName());

    @Inject
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserVO userVO;
        try {
            userVO = userService.getUserByEmail(email);
        } catch (UsernameNotFoundException e) {
            Log.error("User with email: " + email + " not found", e);
            throw new UsernameNotFoundException("User with email: " + email + " not found", e);
        }
        return (UserDetails) userVO;
    }
}
