/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yosef Febrianes
 */
@Service
public class MailNotification {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailNotification(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    

    public void MailToEmployee() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("yoseffebrianes@gmail.com");

        msg.setSubject("Q");
        msg.setText("Q");

        javaMailSender.send(msg);
    }
    
    public void MailToManager() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("yoseffebrianes@gmail.com");

        msg.setSubject("Q");
        msg.setText("Q");

        javaMailSender.send(msg);
    }
}

