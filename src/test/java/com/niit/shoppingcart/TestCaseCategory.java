package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;

public class TestCaseCategory {

  
 static CategoryDAO categoryDAO;
  
  
  
 static Category category;
  
  
  static AnnotationConfigApplicationContext context;
  @BeforeClass
  public static void init()
  {
  context = new AnnotationConfigApplicationContext();
  context.scan("com.niit");
  context.refresh();
  category=(Category)  context.getBean("userDetails");
  categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
  
  
  }
  @Test
  public void CategoryNameTest()
  {
	  category= categoryDAO.get("CG101");
	  String name= category.getName();
	  assertEquals("Category Name Test " , "CG101"       ,name);
  }
  
}
