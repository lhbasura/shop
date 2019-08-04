package com.lhb.sh.service.mail;


import com.lhb.sh.util.constant.MailConstant;
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

/**
 * MailService实现类
 */
@Slf4j
@Component
public class MailService  {

    @Resource
    protected JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    protected String from;

    @Resource
    TemplateEngine templateEngine;


    public void sendHtmlMail(String to,String subject,String template) throws MessagingException {
        Context context = new Context();
        String emailContent = templateEngine.process(template, context);
        this.sendSimpleMail(to,subject,emailContent);
    }
    public void sendVerifyMail(String to) throws MessagingException {
        this.sendHtmlMail(to,MailConstant.VERIFY_SUBJECT,MailConstant.VERIFY_TEMPLATE);
    }
    public void sendSimpleMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        log.info("content:"+content);
        mailSender.send(message);
    }

}
