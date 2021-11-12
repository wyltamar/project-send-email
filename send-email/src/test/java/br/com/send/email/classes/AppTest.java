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
		
		StringBuilder stringBuilderTextEmail = new StringBuilder();
		
		stringBuilderTextEmail.append("Hi, <br><br>");
		stringBuilderTextEmail.append("<h2>You are receiving the Java course access.</h2>");

		SendEmailObject sendEmailObject = new SendEmailObject(
				"wiltamar@cagepa.pb.gov.br", 
				"Wyltamar", 
				"Send email with Java", 
				stringBuilderTextEmail.toString()
				);
		
		sendEmailObject.sendEmail(true);

		Thread.sleep(5000); // await 5 seconds for closed the test

	}

}
