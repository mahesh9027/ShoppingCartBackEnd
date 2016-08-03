package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;
import com.niit.shoppingcart.config.ApplicationContextConfig;
import com.niit.shoppingcart.config.ApplicationContextConfig;

public class UserDetailsTest {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   UserDetailsDAO userdetailsDAO = 	(UserDetailsDAO) context.getBean("userdetailsDAO");
	   
	   UserDetails userdetails = 	(UserDetails) context.getBean("userdetails");
	   userdetails.setId("UD123");
	   userdetails.setName("UDName123");
	   userdetails.setDescription("UDDesc123");
	   userdetails.setAddress("mumbai");
	   userdetails.setEmail("email");
	   userdetails.setPassword("xxxxxx");
	   
	   
	   userdetailsDAO.saveOrUpdate(userdetails);

	   System.out.println(" No of suppliers" + userdetailsDAO.list().size()); 
	    
	
	   
  
	   
	  if(   userdetailsDAO.get("sdfsf") ==null)
	  {
		  System.out.println("UserDetails does not exist");
	  }
	  else
	  {
		  System.out.println("UserDetails exist .. the details are ..");
		  System.out.println();
	  }
		
		
	
	}

}
