package ua.com.my_shop.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.my_shop.entity.User;
import ua.com.my_shop.service.MailSenderService;
import ua.com.my_shop.service.UserService;
import ua.com.my_shop.validator.UserValidationMessages;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MailSenderService mailSenderService;

	@RequestMapping(value="/registration" , method=RequestMethod.GET)
	private String registration(Model model){
		
		model.addAttribute("newUser", new User());
		
		return "views-base-registration";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	private String addUser(@ModelAttribute User newUser, Model model) throws Exception {

		String uuid = UUID.randomUUID().toString();
	    newUser.setUuid(uuid);
	    
	    model.addAttribute("newUser", newUser);
	    
	    try {
            userService.save(newUser);
        } catch (Exception e) {
            if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.NAME_ALREADY_EXIST)) {
                model.addAttribute("usernameException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_EMAIl_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)) {
                model.addAttribute("emailException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)) {
                model.addAttribute("passwordException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_PHONE_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.PHONE_ALREADY_EXIST)) {
                model.addAttribute("phoneException", e.getMessage());
            }
            return "views-base-registration";
        }
	
		String theme = "thank's for registration";
	    String mailBody = "gl & hf       http://localhost:8080/FullWarShop/confirm/" + uuid;

	    mailSenderService.sendMail(theme, mailBody, newUser.getEmail());


		return "redirect:/";
	}


	
}
