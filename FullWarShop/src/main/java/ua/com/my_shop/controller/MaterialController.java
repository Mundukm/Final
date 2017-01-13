package ua.com.my_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.my_shop.entity.Material;
import ua.com.my_shop.service.MaterialService;

@Controller
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	@RequestMapping(value="/changeMaterial", method=RequestMethod.GET)
	private String changeMaterial(Model model){
		
		model.addAttribute("materials", materialService.findAll());
		
		model.addAttribute("material", new Material());
		
		return "changeMaterial";
	}
	
	@RequestMapping(value="/addMaterial", method=RequestMethod.POST)
	private String addMaterial(@ModelAttribute Material material){
		
		materialService.save(material);
		
		
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/deleteMaterial/{id}", method=RequestMethod.GET)
	private String deleteMaterial(@PathVariable String id){
		
		materialService.delete(Integer.parseInt(id));
		
		
		return "redirect:/admin";
	
	
	
	}
	
	
	
	
}
