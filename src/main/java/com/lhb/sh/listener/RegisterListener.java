package com.lhb.sh.listener;


import com.lhb.sh.event.UserRegisterEvent;
import com.lhb.sh.model.entity.User;
import com.lhb.sh.provider.RabbitProvider;
import com.lhb.sh.service.mail.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class RegisterListener {

    @Resource
    private RabbitProvider rabbitProvider;

    @EventListener
    public void listener(UserRegisterEvent event) {

        User user = event.getUser();
        rabbitProvider.sendMail(user);
        log.info("listen in UserRegisterEvent,the user is:" + user);
    }
}
