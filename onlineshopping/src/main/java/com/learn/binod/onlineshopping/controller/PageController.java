package com.learn.binod.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learn.binod.shoppingbackend.dao.CategoryDAO;
import com.learn.binod.shoppingbackend.dto.Category;

@Controller
public class PageController {
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView modelAndView=new ModelAndView("page");
		
		modelAndView.addObject("title", "Home");
		modelAndView.addObject("userClickHome",true);
		//passing the list of categories
		modelAndView.addObject("categories", categoryDAO.list());
		return modelAndView;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about() {
		ModelAndView modelAndView=new ModelAndView("page");
		modelAndView.addObject("title", "About Us");
		modelAndView.addObject("userClickAbout",true);
		return modelAndView;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView=new ModelAndView("page");
		modelAndView.addObject("title", "Contact Us");
		modelAndView.addObject("userClickContact",true);
		return modelAndView;
	}
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView modelAndView=new ModelAndView("page");
		
		modelAndView.addObject("title", "All Products");
		modelAndView.addObject("userClickAllProducts",true);
		//passing the list of categories
		modelAndView.addObject("categories", categoryDAO.list());
		return modelAndView;
	}
	
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView modelAndView=new ModelAndView("page");
		//categoryDAO to fetch a single category
		Category category = null;
		category=categoryDAO.get(id);
		
		modelAndView.addObject("title", category.getName());
		
		modelAndView.addObject("userClickCategoryProducts",true);
		//passing the list of categories
		modelAndView.addObject("categories", categoryDAO.list());
		
		
		//passing the single category object
		modelAndView.addObject("category", category);
		
		return modelAndView;
	}

}
