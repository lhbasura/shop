package com.lhb.sh.service.mail;

import com.lhb.sh.ShopApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;


@Slf4j
public class MailServiceTest extends ShopApplicationTest {

    @Autowired
    MailService service;
    @Test
    public void sendSimpleMail() throws MessagingException {
        service.sendMail("hongbo.liu@geneegroup.com","我要变强","你的付出不会白费！");
    }

    @Test
    public void sendVerifyMail() throws MessagingException {
        log.info("start send email");
        service.sendVerifyMail("hongbo.liu@geneegroup.com");

        log.info("send email end");
    }
}