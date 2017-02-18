/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.userregistration;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail implements CurrentUser{
    
    User theUser;
    public void mail(){
        
         final String username = "someone@gmail@gmail.com";
        final String password = "password";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
             try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("fromSomeone@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(theUser.getEmail()));
            message.setSubject("Welcome to RTS WIFI");
            message.setText("Dear " + theUser.getName()  + ","
                + "Your RTS WIFI login Credentials\n userID is :" +theUser.getUserName()
                + "\npassword is :" +theUser.getPwd2());

            Transport.send(message);

            

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
       
    }
    public void mail(String passCode) {

        final String username = "someone@gmail.com";
        final String password = "password";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session2 = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        

        try {

            Message message = new MimeMessage(session2);
            message.setFrom(new InternetAddress("fromSomeone@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(theUser.getEmail()));
            message.setSubject("RTS WIFI VERIFICATION CODE");
            message.setText("Dear " + theUser.getName()  + ","
                + "Your Verification Code is :" +passCode );

            Transport.send(message);

            

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        
       
    }

    @Override
    public void setCurrentUser(User currentUser) {
        theUser = currentUser;
    }
}