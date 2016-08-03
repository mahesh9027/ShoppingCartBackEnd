package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;

import com.niit.shoppingcart.model.Cart;

public class CartTest {
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   CartDAO cartDAO = 	(CartDAO) context.getBean("cartDAO");
	   
	   Cart cart = 	(Cart) context.getBean("cart");
	   cart.setId("CG123");
	   cart.setName("CGName123");
	   cart.setDescription("CGDesc123");
	   
	 
	   cartDAO.saveOrUpdate(cart);

	   System.out.println(" No of suppliers" + cartDAO.list().size()); 
	     
	
	   
  
	   
	  if(   cartDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Cart does not exist");
	  }
	  else
	  {
		  System.out.println("Cart exist .. the details are ..");
		  System.out.println();
	  }
		
		
	
	}

}
