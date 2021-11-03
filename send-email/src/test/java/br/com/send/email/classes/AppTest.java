package br.com.send.email.classes;

import java.util.Properties;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest { 

	
	@org.junit.Test
	public void testEmail() {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true"); //Authorization 
		properties.put("mail.starttls","true"); //Authentication
		properties.put("mail.smtp.host","smtp.gmail.com"); //Server Google Gmail
		properties.put("mail.smtp.port", "465"); //Server Door 
		properties.put("mail.smtp.socketFactory.port","465"); //Specifies the port to be connected by socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //Class that connects socket to SMTP
	}
}
