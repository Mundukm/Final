package ua.com.my_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.my_shop.service.CommodityService;

@Controller
public class NvigationController {
	
	@Autowired
	private CommodityService commodityService;

	@RequestMapping(value="/wood", method=RequestMethod.GET)
	private String wood(Model model){
		
		model.addAttribute("item",commodityService.findByCategory("wood"));
		
		return "views-base-wood";
	}
	
	@RequestMapping(value="/paper", method=RequestMethod.GET)
	private String paper(Model model){
		
		model.addAttribute("item",commodityService.findByCategory("paper"));
		
		return "views-base-paper";
	}
	
	@RequestMapping(value="/toys", method=RequestMethod.GET)
	private String toys(Model model){
		
		model.addAttribute("item",commodityService.findByCategory("toys"));
		
		return "views-base-toys";
	}
	
	@RequestMapping(value="/gifts", method=RequestMethod.GET)
	private String gifts(Model model){
		
		model.addAttribute("item",commodityService.findByCategory("gifts"));
		
		return "views-base-gifts";
	}
	
	@RequestMapping(value="/other", method=RequestMethod.GET)
	private String other(Model model){
		
		model.addAttribute("item",commodityService.findByCategory("other"));
		
		return "views-base-others";
	}
}
