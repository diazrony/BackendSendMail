package com.paasc.web.controllers;

import com.paasc.web.models.Email;
import com.paasc.web.services.EmailService;
import com.paasc.web.services.MailContentBuilder;
import com.paasc.web.services.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

import java.util.Date;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    SendMailService sendMailService;

    @Autowired
    MailContentBuilder mailContentBuilder;

    @PostMapping()
    public ResponseEntity<?> saveAndSendEmail(@RequestBody Email email) throws MessagingException {
        Email email2 = new Email();
        email2.setNombre(email.getNombre());
        email2.setEmail(email.getEmail());
        email2.setEstado(email.getEstado());
        email2.setMensaje(email.getMensaje());
        email2.setServicio(email.getServicio());
        email2.setFecha(new Date());
        sendMailService.sendMail("ronydiaz99@gmail.com","147185@udlondres.com","email Test",mailContentBuilder.build(email2.getNombre()) );
        emailService.saveEmail(email2);
        return new ResponseEntity("Todo en orden",HttpStatus.OK);
    }

}
