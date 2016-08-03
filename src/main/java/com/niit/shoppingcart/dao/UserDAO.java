package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.UserDetails;

public interface UserDAO {



	public List<User> list();

	public User get(String id);
	
	public void saveOrUpdate(User user);
	public void saveOrpdate(User user);

	public void delete(String id);

	public boolean isValidUser(String userID, String password);



}
