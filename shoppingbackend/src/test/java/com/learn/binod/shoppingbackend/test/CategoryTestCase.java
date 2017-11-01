package com.learn.binod.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.learn.binod.shoppingbackend.dao.CategoryDAO;
import com.learn.binod.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigWebApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigWebApplicationContext();
		context.scan("com.learn.binod.shoppingbackend");
		context.refresh();
		
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
//	
//	@Test
//	public void testAddCategory() {
//		category= new Category();
//		category.setName("Television");
//		category.setDescription("new samsung LED 32 inch");
//		category.setImageURL("CAT_1.png");
//		
//		assertEquals("sucessfully added category inside the table",true,categoryDAO.add(category));
//	}
	
//	@Test
//	public void testgetCategory() 
//	{
//		category=categoryDAO.get(3);
//		assertEquals("sucessfully fetched single category inside the table","Television",category.getName());
//	}
	
//	@Test
//	public void testUpdateCategory() 
//	{
//		category=categoryDAO.get(3);
//		category.setName("TV");
//		assertEquals("sucessfully updated single category inside the table",true,categoryDAO.update(category));
//	}
//	
//	@Test
//	public void testDeleteCategory() 
//	{
//		category=categoryDAO.get(3);
//		assertEquals("sucessfully deleted single category inside the table",true,categoryDAO.delete(category));
//	}
	
//	@Test
//	public void testlistCategory() 
//	{
//		
//		assertEquals("sucessfully fetched the  single category from the table",3,categoryDAO.list().size());
//	}

	@Test
	public void testCRUDCategory() {
		//add operation
		category= new Category();
		category.setName("Laptop");
		category.setDescription("this is some description for laptop");
		category.setImageURL("CAT_1.png");
		
		assertEquals("sucessfully added category inside the table",true,categoryDAO.add(category));
		
		category= new Category();
		category.setName("Tevevision");
		category.setDescription("this is some description for Tevevision");
		category.setImageURL("CAT_2.png");
		
		assertEquals("sucessfully added category inside the table",true,categoryDAO.add(category));
		
		//fetching and updating the category
		category=categoryDAO.get(2);
		category.setName("TV");
		assertEquals("sucessfully updated single category inside the table",true,categoryDAO.update(category));
		
		//delete the category
		assertEquals("sucessfully deleted single category inside the table",true,categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("sucessfully fetched the  single category from the table",1,categoryDAO.list().size());
		
		//
		
	}
}
