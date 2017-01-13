package ua.com.my_shop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.my_shop.entity.Category;
import ua.com.my_shop.entity.Commodity;

public interface CommodityService {

	void save(Commodity commodity) throws Exception;
	
	void delete(int id);
	
	List<Commodity> findAll();
	
	Commodity findOne(int id);
	
	void addCategoryAndMaterialToCommodity(Commodity commodity, String categoryid, 
											 MultipartFile multipartFile);
	
	List<Commodity> findByCategory(String name);
}
