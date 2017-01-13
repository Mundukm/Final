package ua.com.my_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.my_shop.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

	
}
