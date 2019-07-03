package com.lhb.sh.service.auth;

import com.lhb.sh.exception.user.NullValueException;
import com.lhb.sh.exception.user.RepeatException;
import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.model.User;
import com.lhb.sh.service.user.UserService;
import com.lhb.sh.util.Security;
import com.lhb.sh.util.enums.AccountStaEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DbUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    DbUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), simpleGrantedAuthorities);
    }

    public int register(User user) throws UserException {
        if (user.getUsername() == null) {
            throw new NullValueException(AccountStaEnum.nameNull);
        }
        if (user.getPassword() == null) {
            throw new NullValueException(AccountStaEnum.pswdNull);
        }
        if (userService.exist(user.getUsername())) {
            throw new RepeatException(AccountStaEnum.registerRepeat);
        }
        user.setPassword(Security.encode(user.getUsername(), user.getPassword()));
        return userService.insert(user);
    }

}
