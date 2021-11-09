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

	@org.junit.Test
	public void testEmail() throws Exception {

		SendEmailObject sendEmailObject = new SendEmailObject(
				"wiltamar@cagepa.pb.gov.br", 
				"Wyltamar", 
				"Send email with Java", 
				"Sending email with Java - Course JDev Treinnings"
				);
		
		sendEmailObject.sendEmail();

		Thread.sleep(5000); // await 5 seconds for closed the test

	}

}
