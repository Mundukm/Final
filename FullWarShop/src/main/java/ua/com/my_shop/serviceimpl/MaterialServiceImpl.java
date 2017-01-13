package ua.com.my_shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.my_shop.dao.MaterialDao;
import ua.com.my_shop.entity.Material;
import ua.com.my_shop.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService{

	@Autowired
	private MaterialDao materialDao;

	public void save(Material material) {
		materialDao.save(material);
		
	}

	public void delete(int id) {
		materialDao.delete(id);
	}

	public Material findOne(int id) {
		return materialDao.findOne(id);
	}

	public List<Material> findAll() {
		return materialDao.findAll();
	}
	
	
}
