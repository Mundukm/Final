package ua.com.my_shop.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.my_shop.entity.User;
import ua.com.my_shop.service.MailSenderService;
import ua.com.my_shop.service.UserService;
import ua.com.my_shop.validator.UserValidationMessages;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String confirm(@PathVariable String uuid) {

		User user = userService.findByUUID(uuid);
		user.setEnabled(true);

		userService.update(user);

		return "redirect:/";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable String id) {
		userService.delete(Integer.parseInt(id));
		return "redirect:/changeUser";
	}

}
