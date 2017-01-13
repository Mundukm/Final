package ua.com.my_shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.my_shop.dao.CategoryDao;
import ua.com.my_shop.entity.Category;
import ua.com.my_shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;

	public void save(Category category) {
		categoryDao.save(category);
	}

	public void delete(int id) {
		categoryDao.delete(id);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}


	
	
}
