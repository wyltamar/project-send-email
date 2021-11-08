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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private String userName = "wyltamarjavadev@gmail.com";
	private String password = "xxxxxxxxxx"; //password here is incorrect

	@org.junit.Test
	public void testEmail() {

		try {

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
					.parse("pedrooluucas2010@gmail.com");
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName,"Wyltamar Douglas")); // quem estar enviadno
			message.setRecipients(Message.RecipientType.TO, toUser); //email de destino
			message.setSubject("Email enviado com java"); //assunto do email
			message.setText("Esse email foi enviado com Java através do curso Java Web - Wyltamar"); //corpo do email
			
			Transport.send(message);
			
			Thread.sleep(5000); //wait 5 seconds for closed the test

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
