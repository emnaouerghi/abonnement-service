package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void send(String toEmail,String subject,String body) {
		SimpleMailMessage msg= new SimpleMailMessage();
		msg.setFrom("clubna2022@gmail.com");
		msg.setTo(toEmail);
		msg.setText(body);
		msg.setSubject(subject);
		mailSender.send(msg);
		System.out.printf("mail sent successfuly");
		
	}
	

}
