package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil {
	public static boolean SendMail(String from, String to, String cc, String subject, String content) {
		Properties props = System.getProperties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.failBack", "false");
		props.put("mail.smtp.quitwait", "false");
		
		try {
			Session session = Session.getInstance(props, new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("minhpl.hv@gmail.com", "3003191114");
				}
			});
		Message message	= new MimeMessage(session);
		Address fromAdd = new InternetAddress(to);
		Address toAdd = new InternetAddress(to);
		Address ccAdd = new InternetAddress(cc);
		
		message.setFrom(fromAdd);
		message.setRecipient(Message.RecipientType.TO, toAdd);
		message.setRecipient(Message.RecipientType.CC, ccAdd);
		
		
		MimeBodyPart messagePart = new MimeBodyPart();
		MimeMultipart mutilPart = new MimeMultipart();
		
		mutilPart.addBodyPart(messagePart);
		
		messagePart.setText(content, "utf-8");
		messagePart.setHeader("Content-Type", "text/html;character=\"utf-8\"");
		messagePart.setHeader("Content-Transfer-Encoding", "quoted-printable");
		
		message.setSubject(subject);
		message.setContent(mutilPart);
		message.setSentDate(new Date());
		
		Transport.send(message);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
