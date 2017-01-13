package ua.com.my_shop.service;

import java.util.List;

import ua.com.my_shop.entity.Material;

public interface MaterialService {

	void save(Material material);

	void delete(int id);

	Material findOne(int id);

	List<Material> findAll();

}
