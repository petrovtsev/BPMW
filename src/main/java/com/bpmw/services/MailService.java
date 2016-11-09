package com.bpmw.services;

import javax.enterprise.context.RequestScoped;
import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * The class is used to send and receive e-mail.
 * @author ppetr
 * @version 1.0
 */
@RequestScoped
public class MailService {

    private Properties props;

    /**
     * The parameters describe the login name and password.
     */
    private final String username = "js.bpmw@gmail.com";
    private final String password= "Diro1994";


    /**
     * The constructor sets the properties of the connection.
     */
    public MailService() {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    /**
     * The method is used to send messages. As the parameters takes:
     * @param subject - message subject;
     * @param text - message text;
     * @param toEmail - mail address.
     */
    public void send(String subject, String text, String toEmail){
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
