package com.lhb.sh.service.mail;


import com.lhb.sh.model.entity.User;
import com.lhb.sh.util.SignatureUtil;
import com.lhb.sh.util.constant.VerifyConstant;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * MailService实现类
 */
@Slf4j
@Component
public class MailService {

    @Resource
    protected JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    protected String from;

    @Value("${web.baseurl}")
    protected String baseurl;

    @Resource
    private TemplateEngine templateEngine;


    public void sendVerifyMail(User user) throws MessagingException {
        log.info("to send verify mail");
        Context context = new Context();
        long expire = new Date().getTime() + 60 * 15;
        String signature = SignatureUtil.genVerifySignature(user.getId(), expire);
        context.setVariable("baseurl", baseurl);
        context.setVariable("id", user.getId());
        context.setVariable("expire", expire);
        context.setVariable("signature", signature);
        String emailContent = templateEngine.process(VerifyConstant.MAIL_TEMPLATE, context);
        this.sendSimpleMail(user.getEmail(), VerifyConstant.MAIL_SUBJECT, emailContent);
    }

    public void sendSimpleMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        log.info("content:" + content);
        mailSender.send(message);
    }

}
