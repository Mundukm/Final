package ua.com.my_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.my_shop.entity.Category;
import ua.com.my_shop.entity.Commodity;
import ua.com.my_shop.entity.Material;
import ua.com.my_shop.service.CategoryService;
import ua.com.my_shop.service.CommodityService;
import ua.com.my_shop.service.MaterialService;

@Controller
public class AdminController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private CommodityService commodityService;

	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	private String admin(Model model){
		model.addAttribute("allCategory", categoryService.findAll());
		model.addAttribute("newCommodity" ,new Commodity() );
		model.addAttribute("newMaterial", new Material());
		model.addAttribute("newCategory", new Category());
		model.addAttribute("allMaterial", materialService.findAll());
		model.addAttribute("allCommodity", commodityService.findAll());
		return "views-base-admin";
	}
	
	
}
