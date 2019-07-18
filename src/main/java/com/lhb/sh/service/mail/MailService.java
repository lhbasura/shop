package com.lhb.sh.service.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
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
@Component
public class MailService  {

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    TemplateEngine templateEngine;

    private final String verifyPath="auth/verify";
    private final String verifySubject="激活您的账户";
    public void sendVerifyMail(String to) throws MessagingException {

        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process(verifyPath, context);
        this.sendMail(to,verifySubject,emailContent);
    }
    public void sendMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

}
