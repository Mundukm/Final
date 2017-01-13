package ua.com.my_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.my_shop.entity.Category;
import ua.com.my_shop.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(value="/changeCategory", method=RequestMethod.GET)
	private String changeCategory(Model model){
		
		model.addAttribute("category", categoryService.findAll());
		
		model.addAttribute("categorys", new Category());
		
		return "changeCategory";
	}
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	private String addCategory(@ModelAttribute Category categorys){
		
		categoryService.save(categorys);
		
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/deleteCategory/{id}", method=RequestMethod.GET)
	private String deleteCategory(@PathVariable String id){
		
		categoryService.delete(Integer.parseInt(id));
		
		return "redirect:/admin";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
