package com.lhb.sh.provider;

import com.lhb.sh.ShopApplicationTest;
import com.lhb.sh.model.entity.User;
import com.lhb.sh.service.user.UserService;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class RabbitProviderTest extends ShopApplicationTest {

    @Resource
    RabbitProvider provider;
    @Resource
    UserService userService;
    @Test
    public void sendMail() {
        User user=userService.getUserByUsername("lhbasura");
        provider.sendMail(user);
    }
}