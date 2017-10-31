package com.learn.binod.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.learn.binod.shoppingbackend.dao.CategoryDAO;
import com.learn.binod.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("new samsung LED 32 inch");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// adding second category
		category = new Category();

		category.setId(2);
		category.setName("mobile");
		category.setDescription("new Gione 8 with its high screen resolution");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		// adding third category
		category = new Category();

		category.setId(3);
		category.setName("Laptop");
		category.setDescription("new Dell Inspiron with i7 processor and 16GB RAM");
		category.setImageURL("CAT_3.png");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// enhanced for loop
		for(Category category : categories) {
			if(category.getId() == id)
				return category;
		}
		return null;
	}

}
