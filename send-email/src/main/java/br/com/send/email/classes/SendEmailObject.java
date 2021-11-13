package br.com.send.email.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SendEmailObject {

	private String userName = "wyltamarjavadev@gmail.com";
	private String password = "javadev123"; // password here is incorrect

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

	public void sendEmail(boolean envioHtml) throws Exception {

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

		Address[] toUser = InternetAddress.parse(ricipient);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, submitter)); // quem estar enviadno
		message.setRecipients(Message.RecipientType.TO, toUser); // email de destino
		message.setSubject(subject); // assunto do email

		if (envioHtml) {
			message.setContent(text, "text/html; chartset=utf-8");
		} else {
			message.setText(text); // corpo do email

		}

		Transport.send(message);

	}

	/* Mock file pdf 
	 * Return a PDF with the paragraph text */
	
	private FileInputStream pdfSimulator() throws Exception {

		Document documentPdf = new Document();
		File file = new File("attachmentFile.pdf");
		file.createNewFile();
		PdfWriter.getInstance(documentPdf, new FileOutputStream(file));
		documentPdf.open();
		documentPdf.add(new Paragraph("This line will be writer within PDF file"));
		documentPdf.close();

		return new FileInputStream(file);
	}

}
