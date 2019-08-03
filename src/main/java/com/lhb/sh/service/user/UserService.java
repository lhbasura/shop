package com.lhb.sh.service.user;

import com.lhb.sh.event.UserRegisterEvent;
import com.lhb.sh.exception.user.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.lhb.sh.model.User;
import com.lhb.sh.mapper.UserMapper;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Resource
    protected UserMapper userMapper;

    @Resource
    protected ApplicationContext applicationContext;

    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }


    public int insert(User record) {
        return userMapper.insert(record);
    }


    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }


    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User getUserByUsername(String username) {
        return userMapper.findOneByUsername(username);
    }

    public boolean exist(String username) {
        return this.getUserByUsername(username) != null;
    }

    public void saveUser(User user) throws UserException {
        log.info("go UserService's saveUser function");

    }

    public void register(User user) throws UserException {
        saveUser(user);
        applicationContext.publishEvent(new UserRegisterEvent(this,user));
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}
