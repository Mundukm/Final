package ua.com.my_shop.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.my_shop.dao.CategoryDao;
import ua.com.my_shop.dao.CommodityDao;
import ua.com.my_shop.dao.MaterialDao;
import ua.com.my_shop.entity.Category;
import ua.com.my_shop.entity.Commodity;
import ua.com.my_shop.entity.Material;
import ua.com.my_shop.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private MaterialDao materialDao;

	public void save(Commodity commodity) {
		commodityDao.save(commodity);
	}

	public void delete(int id) {
		commodityDao.delete(id);
	}

	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	public Commodity findOne(int id) {
		return commodityDao.findOne(id);
	}

	@Transactional
	public void addCategoryAndMaterialToCommodity(Commodity commodity, String categoryid, 
			MultipartFile multipartFile) {

		commodityDao.saveAndFlush(commodity);

		
		
		String path = System.getProperty("catalina.home") + "/resources/" + commodity.getName() + "/"
				+ multipartFile.getOriginalFilename();

		commodity.setImagePath("resources/" + commodity.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + commodity.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}

		Category category = categoryDao.findOne(Integer.parseInt(categoryid));
		
		commodity.setCategory(category);
		

		commodityDao.save(commodity);

	}

	
	@Transactional
	public List<Commodity> findByCategory(String name) {
		
		List<Commodity> all = commodityDao.findAll();
		List<Commodity> some = new ArrayList<Commodity>();
		
		for (Commodity commodity : all) {
			if(commodity.getCategory().getName().equalsIgnoreCase(name)){
				some.add(commodity);
			}
		}
		
		return some;
	}


	
	
}
