/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Billy
 */
public class SendMail {

   

    public void sendmail(String toEmail, String name,String username1,String password1) {
        // Recipient's email ID needs to be mentioned.
        String to = toEmail;
        Calendar time = Calendar.getInstance();
        // Sender's email ID needs to be mentioned
        String from = "iradlorie@gmail.com";
        final String username = "iradlorie@gmail.com";//change accordingly
        final String password = "Godisawesome95";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("CSHR Notification.");

            // Send the actual HTML message, as big as you like
            message.setContent(
                      "<html>\n"
                    + "  <head>\n"
                    + "    <style>\n"
                    + "      .colored {\n"
                    + "        color: blue;\n"
                    + "      }\n"
                    + "      #body {\n"
                    + "        font-size: 12px;\n"
                    + "      }\n"
                    + "    </style>\n"
                    + "  </head>\n"
                    + "  <body>\n"
                    + "    <div id='body'>\n"
                    +        "<p>Dear " + name + ",</p>\n"
                    +        "<p>\n"
                    +        "Welcome to CSHR Management System. Your username is "+ username1 +" and password "+password1+".\n\n"
                    ,
                      "text/html");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
