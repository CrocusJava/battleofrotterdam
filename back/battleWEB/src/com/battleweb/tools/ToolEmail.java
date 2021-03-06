package com.battleweb.tools;


import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class ToolEmail {
	
	 	private String username;
	    private String password;
	    private Properties props;
	 
	   {
	        this.username = "battleofrotterdam@gmail.com";
	        this.password = "battleofrotterdam2014";
	 
	        props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	    }
	 
	    public void send(final String subject, final String text, final String toEmail){
	        final Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });
	        new Thread(new Runnable() {
				
				@Override
				public void run() {
					  try {
				            Message message = new MimeMessage(session);
				            message.setFrom(new InternetAddress(username));
				            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
				            message.setSubject(subject);
				            message.setContent(text, "text/html");
				 
				            Transport.send(message);
				        } catch (MessagingException e) {
				            throw new RuntimeException(e);
				        }
				}
			}).start();
	      
	    }
	
}
