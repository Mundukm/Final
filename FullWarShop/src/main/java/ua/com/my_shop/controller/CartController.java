package ua.com.my_shop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.my_shop.entity.User;
import ua.com.my_shop.service.UserService;

@Controller
public class CartController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/buycommodity/{id}")
	private String buyBook(Principal principal, @PathVariable String id){
		
		userService.buyCommodity(principal, id);
		
		
		return "redirect:/products";
	}
	
	@RequestMapping(value="/cart")
	private String cart(Model model, Principal principal){
		
		User user = userService.fetchUserWithCommodity(Integer.parseInt(principal.getName()));
		
		int i = userService.numberOfProducts(Integer.parseInt(principal.getName()));
		
		int total = userService.totalPrice(Integer.parseInt(principal.getName()));
		
		model.addAttribute("user", user);
		
		model.addAttribute("numberOfProducts", i);
		
		model.addAttribute("totalPrice", total);
		
		return "views-base-cart";
	}
	
	@RequestMapping(value="/deletecommodity/{id}")
	private String deleteCommodity(Principal principal, @PathVariable String id){
		
		userService.deleteCommodityFromUser(Integer.parseInt(principal.getName()), id);
		
		
		return "redirect:/cart";
	}
	
	
}
