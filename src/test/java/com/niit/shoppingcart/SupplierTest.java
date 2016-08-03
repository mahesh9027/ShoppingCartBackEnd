package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;
import org.springframework.beans.factory.*;

public class SupplierTest {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   SupplierDAO supplierDAO = 	(SupplierDAO) context.getBean("supplierDAO");
	   
	   Supplier supplier = 	(Supplier) context.getBean("supplier");
	   supplier.setId("SUP123");
	   supplier.setName("SUPName123");
	   supplier.setAddress("MUMBAI");
	   
	   
	   supplierDAO.saveOrUpdate(supplier); 
	   	 System.out.println(" No of suppliers" +  supplierDAO.list().size());
	   
	   
	   	/*  
	   
	  if(   supplierDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Supplier does not exist");
	  }
	  else
	  {
		  System.out.println("Supplier exist .. the details are ..");
		  System.out.println();
	  }
		
		*/
		
	}

}
