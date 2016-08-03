package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserTest {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   UserDAO userDAO = 	(UserDAO) context.getBean("userDAO");
	   
	   User user = 	(User) context.getBean("user");
	   user.setId("USER199");
	   
	   user.setPassword("xxxxxx");
	   
	   
	   
	   
	   userDAO.saveOrUpdate(user);
	   System.out.println(" No of users" + userDAO.list().size());
	   
			   
	   
	/*   
	   
	  if(   userDAO.get("sdfsf") ==null)
	  {
		  System.out.println("User does not exist");
	  }
	  else
	  {
		  System.out.println("User exist .. the details are ..");
		  System.out.println();
	  }
		*/
		
		
	}

}
