package ua.com.my_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.my_shop.entity.Commodity;
import ua.com.my_shop.entity.User;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {

	Commodity findByName(String name);
	
}
