package com.learn.binod.shoppingbackend.dao;

import java.util.List;

import com.learn.binod.shoppingbackend.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	Category get(int id);
}
