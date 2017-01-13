package ua.com.my_shop.service;

import java.security.Principal;
import java.util.List;

import ua.com.my_shop.entity.Commodity;
import ua.com.my_shop.entity.User;

public interface UserService {

	void save(User user) throws Exception;

	void delete(int id);

	List<User> findAll();

	User findOne(int id);
	
	void buyCommodity(Principal principal, String id);
	
	User fetchUserWithCommodity(int id);
	
	int numberOfProducts(int id);
	
	int totalPrice(int id);
	
	void deleteCommodityFromUser(int id, String com_id);
	
	User findByUUID(String uuid);
	
	 void update(User user);

}
