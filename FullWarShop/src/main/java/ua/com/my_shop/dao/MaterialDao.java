package ua.com.my_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.my_shop.entity.Material;

public interface MaterialDao extends JpaRepository<Material, Integer>{

}
