package br.com.send.email.classes;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailObject {
	
	private String userName = "wyltamarjavadev@gmail.com";
	private String password = "**********"; //password here is incorrect
	
	private String ricipient = "";
	private String submitter = "";
	private String subject = "";
	private String text = "";
	
	public SendEmailObject(String ricipient, String submitter, String subject, String text) {
		this.ricipient = ricipient;
		this.submitter = submitter;
		this.subject = subject;
		this.text = text;
	}
	
	public void sendEmail() throws Exception{
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.ssl.trust", "*"); // Authentication ssl
		properties.put("mail.smtp.auth", "true"); // Authorization
		properties.put("mail.starttls", "true"); // Authentication
		properties.put("mail.smtp.host", "smtp.gmail.com"); // Server Google Gmail
		properties.put("mail.smtp.port", "465"); // Server Door
		properties.put("mail.smtp.socketFactory.port", "465"); // Specifies the port to be connected by socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Class that connects
																							// socket to SMTP

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		Address[] toUser = InternetAddress
				.parse(ricipient);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName,submitter)); // quem estar enviadno
		message.setRecipients(Message.RecipientType.TO, toUser); //email de destino
		message.setSubject(subject); //assunto do email
		message.setText(text); //corpo do email
		
		Transport.send(message);

	}

}
