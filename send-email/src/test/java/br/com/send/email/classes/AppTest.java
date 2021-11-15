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
		stringBuilderTextEmail.append("<p>You are receiving the the link for project Virtual Store.</p><br>");
		stringBuilderTextEmail.append("<p><b>Login:</b> wyltamar83</p>");
		stringBuilderTextEmail.append("<p><b>Senha:</b> y33eej87dd</p><br><br>");
		stringBuilderTextEmail.append(
				"<a href=\"https://github.com/wyltamar/loja_virtual_mentoria\" style=\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration: none; display: inline-block; border-radius:30px; font-size:20px; font-family:courier; border:3px solid green; background-color:#99DA39;\">Access Stuent Portal</a><br><br>");
		
		stringBuilderTextEmail.append("<span style=\"font-size: 9px\">Ass.: Wyltamar Douglas de Sousa Oliveira</spam>");
		SendEmailObject sendEmailObject = new SendEmailObject("wyltamar.douglasdesousaoliveir@gmail.com", "Wyltamar",
				"Send email with Java", stringBuilderTextEmail.toString());

		sendEmailObject.sendEmailAttachment(true);

		Thread.sleep(5000); // await 5 seconds for closed the test

	}

}
