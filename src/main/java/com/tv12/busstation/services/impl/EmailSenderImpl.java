package com.tv12.busstation.services.impl;

import com.tv12.busstation.services.EmailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailSenderImpl implements EmailSender {
    private final Session session;
    private final String from;
    public EmailSenderImpl() {
        // Sender's email ID needs to be mentioned
        from = "bf78252867-9ee8cd+1@inbox.mailtrap.io";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.mailtrap.io";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "2525");
        properties.put("mail.smtp.tls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("6b62f3b89cd126", "e29aa1118fe0d2");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);
    }

    public void sendHtml(String text, String toEmail) {
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // Now set the actual message
            message.setContent(text, "text/html; charset=UTF-8");

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
