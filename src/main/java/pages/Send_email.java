package pages;

import java.time.Duration;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import businesscomponents.CommonFunctions;
import supportlibraries.ScriptHelper;

public class Send_email extends MasterPage{
	
	private static WebElement element = null;
	CommonFunctions CF = new CommonFunctions(scriptHelper);   
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    public Send_email(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		
		
	}

    public Send_email email() 
	{
	       // Sender's email credentials
	       String from = "shantanoo.chitrao@ocwen.com";
	       String password = "Summer@10";
	       // Recipient's email address
	       String to = "shantanoo.chitrao@ocwen.com";
	       // SMTP server details
	       String host = "smtp-mail.outlook.com";
	       //String host = "mailrelay.ocwen.com";
	       int port = 25;
	       
	       
	    // Set properties for SMTP
	       Properties properties = new Properties();
	       properties.put("mail.debug", "true");
	       properties.put("mail.smtp.auth", "true");
	       properties.put("mail.smtp.starttls.enable", "true");
	       properties.put("mail.smtp.host", host);
	       properties.put("mail.smtp.port", port);
	       
	       // Get the session object
	       // Get system properties
	       //tempProperties properties = System.getProperties(); 
	       
	       // Setup mail server
	       //properties.setProperty("mailrelay.ocwen.com", host);
	       
	    // Get the default Session object
	      //temSession session = Session.getDefaultInstance(properties); 
	       
	       // Create a session with authentication
	       Session session = Session.getInstance(properties, new Authenticator() {
	           @Override
	           protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(from, password);
	           }
	       });
	       
	       // compose the message
	        try {
	 
	            // javax.mail.internet.MimeMessage class 
	            // is mostly used for abstraction.
	            MimeMessage message = new MimeMessage(session); 
	 
	            // header field of the header.
	            message.setFrom(new InternetAddress(from)); 
	            message.addRecipient(Message.RecipientType.TO, 
	                                new InternetAddress(to));
	            message.setSubject("subject");
	            message.setText("Hello, aas is sending email ");
	 
	            // Send message
	            Transport.send(message);
	            System.out.println("Yo it has been sent..");
	        }
	        catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	 
	       return new Send_email(scriptHelper);
	   }
	}



