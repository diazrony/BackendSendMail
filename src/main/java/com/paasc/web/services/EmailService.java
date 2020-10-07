package com.paasc.web.services;

import com.paasc.web.models.Email;
import com.paasc.web.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    public void saveEmail(Email email){
        emailRepository.save(email);
    }

}
