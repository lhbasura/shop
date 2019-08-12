package com.lhb.sh.listener;

import com.lhb.sh.model.entity.User;
import com.lhb.sh.service.mail.MailService;
import com.lhb.sh.service.user.UserService;
import com.lhb.sh.util.constant.MailConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@Component
@Slf4j
@RabbitListener(queues = MailConstant.MAIL_QUEUE)
public class MailListener {

    @Resource
    MailService mailService;

    @RabbitHandler
    public void process(User user) throws MessagingException {
        log.info("Consumer:"+user);
        mailService.sendVerifyMail(user.getEmail());
    }
}