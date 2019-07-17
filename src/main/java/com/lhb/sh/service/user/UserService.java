package com.lhb.sh.service.user;

import com.lhb.sh.event.UserRegisterEvent;
import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.mapper.UserMapper;
import com.lhb.sh.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserService {
    @Resource
    protected UserMapper userMapper;

    @Resource
    protected ApplicationContext applicationContext;



    public int insert(User record) {
        return userMapper.insert(record);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    public boolean exist(String username) {
        return userMapper.findOneByUsername(username) != null;
    }

    public User getUserByUsername(String username) {
        return userMapper.findOneByUsername(username);
    }

    public int saveUser(User user) throws UserException {
        log.info("go UserService");
        return 0;
    }

    public int register(User user) throws UserException {
        int id = this.saveUser(user);
        applicationContext.publishEvent(new UserRegisterEvent(this, user));
        log.info("go UserService register");
        return id;
    }


}
