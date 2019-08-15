package com.lhb.sh.service.user;

import com.lhb.sh.ShopApplicationTest;
import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.model.entity.User;
import net.bytebuddy.utility.RandomString;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;


public class UserServiceTest extends ShopApplicationTest {

    @Resource(name = "dbUserService")
    UserService userService;

    @Test
    public void register() throws UserException, InterruptedException {
        User user=new User();
        System.out.println(user);
        RandomString randomString=new RandomString(8);
        user.setUsername(randomString.nextString());
        user.setPassword(randomString.nextString());
        user.setEmail("hongbo.liu@geneegroup.com");
        userService.register(user);
    }


}