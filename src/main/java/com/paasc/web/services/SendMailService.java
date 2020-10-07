package com.paasc.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String from, String to, String subject, String body) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setText(body, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        javaMailSender.send(mimeMessage);
    }
}
