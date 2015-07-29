package com.assignment.lulu.register.util;

import java.io.StringWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.assignment.lulu.constant.ForexConstant;
import com.assignment.lulu.register.exception.ForexException;
import com.assignment.lulu.register.model.CustomerModel;
import com.assignment.lulu.register.model.EmailVO;

/**
 * Class for handling Email Utility.
 * @author ranjeethpt
 * @since 28-07-2015
 *
 */
public class EmailUtil {
	
	/**
	 * Constant used as a resource loader key for velocity macro.
	 */
	private static final String RESOURCE_LOADER_KEY = "resource.loader";
	
	/**
	 * Constant used as a resource loader value for velocity macro.
	 */
	private static final String RESOURCE_LOADER_VALUE = "file";
	
	/**
	 * Constant used as a class resource loader key for velocity macro.
	 */
	private static final String CLASS_RESOURCE_LOADER_KEY = "class.resource.loader.class";
	
	/**
	 * Constant used as a class resource loader value for velocity macro.
	 */
	private static final String CLASS_RESOURCE_LOADER_VALUE = 
		"org.apache.velocity.runtime.resource.loader.FileResourceLoader";
	
	/**
	 * Constant used as a file resource loader key for velocity macro.
	 */
	private static final String FILE_RESOURCE_LOADER_KEY = "file.resource.loader.class";
	
	/**
	 * Method creates email data string in html as per the template.
	 * @param customerData Customer Data
	 * @return Formatted email string in html format.
	 */
	public static String getEmailData(CustomerModel customerData){
		Properties prop = new Properties();
		prop.setProperty(RESOURCE_LOADER_KEY,RESOURCE_LOADER_VALUE);
		prop.setProperty(CLASS_RESOURCE_LOADER_KEY,CLASS_RESOURCE_LOADER_VALUE);
		prop.setProperty(FILE_RESOURCE_LOADER_KEY,ClasspathResourceLoader.class.getName());
		Velocity.init(prop);
		VelocityContext context = new VelocityContext();
		context.put("customerData",customerData);
		Template objTemplate = Velocity.getTemplate("Email.vm");
		StringWriter writer = new StringWriter();
		objTemplate.merge(context,writer);
		return writer.toString();
	}
	/**
	 * Methood will send email as per the parameters
	 * @param emailVO Email Model.
	 * @param emailTo Sender email address.
	 * @param subject Email Subject.
	 * @param body Email Body
	 * @throws ForexException 
	 */
	public static void sendEmail(EmailVO emailVO, String emailTo, String subject, String body) throws ForexException {
		final String username = emailVO.getUsername();
		final String password = emailVO.getPassword();
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", emailVO.getHost());
		props.put("mail.smtp.port", emailVO.getPort());		
		
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailVO.getEmailFrom()));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailTo));
			message.setSubject(subject);
			message.setContent(body,"text/html");
 			Transport.send(message);
 		} catch (MessagingException e) {
			throw new ForexException(e,1040,ForexConstant.ERROR_1040);
		}
	}
}
