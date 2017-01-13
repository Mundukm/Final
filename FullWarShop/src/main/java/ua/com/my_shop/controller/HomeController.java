package ua.com.my_shop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.my_shop.entity.Commodity;
import ua.com.my_shop.entity.User;
import ua.com.my_shop.service.CategoryService;
import ua.com.my_shop.service.CommodityService;
import ua.com.my_shop.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	private String home(Model model) {
	

		model.addAttribute("commoditys", commodityService.findAll());
		return "views-base-home";
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String loginPage() {

		return "views-base-loginpage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {

		return "redirect:/";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginprocesing() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/products")
	private String toProfile(Model model) {

		model.addAttribute("commoditys", commodityService.findAll());

		return "views-base-product";

	}

}
