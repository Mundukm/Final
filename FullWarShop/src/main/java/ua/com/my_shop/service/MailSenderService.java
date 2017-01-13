package ua.com.my_shop.service;

public interface MailSenderService {

	void sendMail(String theme, String mailbody, String email); 
	
}
