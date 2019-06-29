package com.lhb.sh.service.user.impl;

import com.lhb.sh.exception.user.NullValueException;
import com.lhb.sh.exception.user.RepeatException;
import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.mapper.UserMapper;
import com.lhb.sh.model.User;
import com.lhb.sh.service.user.UserService;
import com.lhb.sh.util.Security;
import com.lhb.sh.util.enums.AccountStaEnum;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Resource
    private UserMapper userMapper;

    public int insert(User record) {
        return userMapper.insert(record);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    public boolean exist(String username) {
        return userMapper.findOneByUsername(username) != null;
    }

    public int register(User user) throws UserException {
        if (user.getUsername() == null) {
            throw new NullValueException(AccountStaEnum.nameNull);
        }
        if (this.exist(user.getUsername())) {
            throw new RepeatException(AccountStaEnum.registerRepeat);
        }
        user.setPassword(Security.encode(user.getUsername(), user.getPassword()));
        return this.insert(user);
    }

    public User getUserByUsername(String username) {
        return userMapper.findOneByUsername(username);
    }

    @Override
    public void login(String username, String password) {
        User user=userMapper.findOneByUsername(username);
        if(user==null)
        {
            throw new UsernameNotFoundException(AccountStaEnum.userNotFound.getInfo());
        }
        if (!(user.getUsername().equals(username) && user.getPassword().equals(Security.encode(username,password)))){
            throw new RuntimeException("用户名或密码错误！");
        }
    }


}
