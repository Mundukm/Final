package ua.com.my_shop.controller;

import javax.enterprise.inject.New;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.my_shop.entity.Commodity;
import ua.com.my_shop.service.CategoryService;
import ua.com.my_shop.service.CommodityService;

@Controller
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CategoryService categoryService;

//	@RequestMapping(value = "/changeCommodity", method = RequestMethod.GET)
//	private String changeCommodity(Model model) {
//
//		model.addAttribute("commodity", commodityService.findAll());
//
//		model.addAttribute("commoditys" ,new Commodity() );
//		
//		model.addAttribute("category", categoryService.findAll());
//		
//		return "changeCommodity";
//	}

	@RequestMapping(value = "/addCommodity", method = RequestMethod.POST)
	private String addCommodity(@RequestParam String name,
			@RequestParam int price,
			@RequestParam String categoryid,
			
			@RequestParam String description,
			@RequestParam MultipartFile imagePath) {

		Commodity commodity = new Commodity(name, price, description);
		
		
		
		commodityService.addCategoryAndMaterialToCommodity(commodity, categoryid, imagePath);

		
		
		return "redirect:/admin";
	}

	@RequestMapping(value = "/deleteCommodity/{id}", method = RequestMethod.GET)
	private String deleteCommodity(@PathVariable String id) {
		commodityService.delete(Integer.parseInt(id));
		return "redirect:/admin";
	}

	@RequestMapping(value="details{id}" , method=RequestMethod.GET)
	private String commodityDetails(Model model, @PathVariable String id){
		
	model.addAttribute("commodity", commodityService.findOne(Integer.parseInt(id)));
		
		return "views-base-details";
	}
	
}
