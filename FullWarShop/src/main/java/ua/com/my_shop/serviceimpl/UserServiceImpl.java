package ua.com.my_shop.serviceimpl;

import java.awt.print.Book;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.my_shop.dao.CommodityDao;
import ua.com.my_shop.dao.UserDao;
import ua.com.my_shop.entity.Commodity;
import ua.com.my_shop.entity.Role;
import ua.com.my_shop.entity.User;
import ua.com.my_shop.service.UserService;
import ua.com.my_shop.validator.Validator;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	public void save(User user) throws Exception{
		
		validator.validate(user);

		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));

		userDao.save(user);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	public User findByName(String name) {
		return userDao.findByName(name);
	}

	@Transactional
	public void buyCommodity(Principal principal, String id) {

		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		Commodity commodity = commodityDao.findOne(Integer.parseInt(id));

		user.getCommodityList().add(commodity);

	}

	public User fetchUserWithCommodity(int id) {
		return userDao.fetchUserWithCommodity(id);
	}

	public int numberOfProducts(int id) {
		User user = userDao.fetchUserWithCommodity(id);

		int i = 0;
		for (Commodity commodity : user.getCommodityList()) {
			i++;
		}

		return i;
	}

	public int totalPrice(int id) {

		User user = userDao.fetchUserWithCommodity(id);

		int i = 0;
		for (Commodity commodity : user.getCommodityList()) {
			i += commodity.getPrice();
		}

		return i;
	}

	@Transactional
	public void deleteCommodityFromUser(int id, String com_id) {

		User user = userDao.fetchUserWithCommodity(id);

		Commodity commodity = commodityDao.findOne(Integer.parseInt(com_id));

		for (Commodity commodity1 : user.getCommodityList()) {
			if (commodity1.getId() == commodity.getId()) {
				user.getCommodityList().remove(commodity1);
				return;
			}

		}

	}

	public User findByUUID(String uuid) {
		return userDao.findByUUID(uuid);
	}

	public void update(User user) {
		userDao.save(user);
	}

}
