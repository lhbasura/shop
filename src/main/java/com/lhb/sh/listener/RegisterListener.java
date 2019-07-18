package com.lhb.sh.listener;


import com.lhb.sh.event.UserRegisterEvent;
import com.lhb.sh.model.User;
import com.lhb.sh.service.mail.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@Slf4j
@Component
public class RegisterListener {

    @Resource
    MailService mailService;
    @EventListener
    public void listener(UserRegisterEvent event) {
        try {
            User user = event.getUser();
            mailService.sendVerifyMail(user.getEmail());
            log.info("listen in UserRegisterEvent,the user is:"+user.toString());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
