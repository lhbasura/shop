package com.lhb.sh.service.mail;

import com.lhb.sh.ShopApplicationTest;
import com.lhb.sh.model.entity.User;
import com.lhb.sh.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.LinkedList;


@Slf4j
public class MailServiceTest extends ShopApplicationTest {

    @Resource
    MailService service;

    @Resource
    UserService userService;

    @Test
    public void sendVerifyMail() throws MessagingException {
        User user = userService.getUserByUsername("lhbasura");
        service.sendVerifyMail(user);
    }

}