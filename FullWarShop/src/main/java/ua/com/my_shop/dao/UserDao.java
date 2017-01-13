package ua.com.my_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.my_shop.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByName(String name);

	@Query("select distinct u from User u left join fetch u.commodityList where u.id =:id")
	User fetchUserWithCommodity(@Param("id") int id);

	@Query("select u from User u where u.uuid=:uuid")
	User findByUUID(@Param("uuid") String uuid);
	
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email =:email")
	boolean userExistsByEmail(@Param("email") String email);
	
	User findByPhone(String phone);
}
