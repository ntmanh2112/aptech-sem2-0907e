package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class MailUtil {
public static boolean flag ;
	public static void sendEmail(String to, String cc, String subject, String content){
	
		Properties props = System.getProperties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.failback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
		
		try{
			Session session = Session.getInstance(props, new Authenticator(){
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication("hungtran1008@gmail.com","024023516");
				}
			});
				
			
			javax.mail.Message message =  new MimeMessage(session);
			Address fromAdd = new InternetAddress("hungtran1008@gmail.com");
			Address toAdd = new InternetAddress(to);
			Address ccAdd = new InternetAddress(cc);
			
			
			
			message.setFrom(fromAdd);
			message.setRecipient(Message.RecipientType.TO,toAdd);

			message.setRecipient(Message.RecipientType.CC,ccAdd);
			message.setSubject(subject);
			
			MimeBodyPart messagePart = new MimeBodyPart();
			MimeMultipart multiPart = new MimeMultipart();
			
			multiPart.addBodyPart(messagePart);
			
			messagePart.setText(content,"utf-8");
			messagePart.setHeader("Content-type", "text/html;charset=\"utf-8\"");
			messagePart.setHeader("Content-Transfer-Encoding", "quoted-printable");
			
			message.setContent(multiPart);
			message.setSentDate(new Date());
			
			Transport.send(message);
			flag = true;
		}catch (Exception e) {
			// TODO: handle exception
			flag = false;
			e.printStackTrace();
			
		}
		
	}
}
