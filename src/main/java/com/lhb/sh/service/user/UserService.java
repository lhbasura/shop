package com.lhb.sh.service.user;


import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.model.User;

import java.util.List;


public interface UserService {


    int insert(User record);

    List<User> selectAll();

    boolean exist(String username);

    int register(User user) throws UserException;

    User getUserByUsername(String username);

    void login(String username, String password);
}
