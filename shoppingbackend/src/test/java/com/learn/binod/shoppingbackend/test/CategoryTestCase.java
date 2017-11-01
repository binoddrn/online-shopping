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
	@Test
	public void testAddCategory() {
		category= new Category();
		category.setName("Television");
		category.setDescription("new samsung LED 32 inch");
		category.setImageURL("CAT_1.png");
		
		assertEquals("sucessfully added category inside the table",true,categoryDAO.add(category));
	}

}
