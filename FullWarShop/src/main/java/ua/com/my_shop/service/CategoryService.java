package ua.com.my_shop.service;

import java.util.List;

import ua.com.my_shop.entity.Category;

public interface CategoryService {

	void save(Category category);
	
	void delete(int id);
	
	List<Category> findAll();
	
	Category findOne(int id);
	
}
