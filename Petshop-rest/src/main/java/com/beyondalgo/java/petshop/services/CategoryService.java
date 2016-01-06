package com.beyondalgo.java.petshop.services;

import java.util.List;

import com.beyondalgo.java.petshop.models.Category;

public interface CategoryService {
	void saveCategory(Category category);

	List<Category> findAllCategories();

	Category findCategoryById(int id);

	void deleteCategory(Category category);

	void updateCategory(Category category);
}
