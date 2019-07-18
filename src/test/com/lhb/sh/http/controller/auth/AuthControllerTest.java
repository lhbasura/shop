package com.lhb.sh.http.controller.auth;

import com.lhb.sh.ShopApplicationTest;
import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.model.User;
import com.lhb.sh.service.user.UserService;
import net.bytebuddy.utility.RandomString;
import org.junit.Test;

import javax.annotation.Resource;


public class AuthControllerTest extends ShopApplicationTest {

    @Resource(name = "dbUserService")
    UserService userService;

    @Test
    public void register() throws UserException {
        User user=new User();
        RandomString randomString=new RandomString(8);
        user.setUsername(randomString.nextString());
        user.setEmail(randomString.nextString()+"@qq.com");
        user.setPassword(randomString.nextString());
        userService.register(user);
    }
}