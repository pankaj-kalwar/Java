package com.beyondalgo.java.petshop.daos;

import java.util.List;

import com.beyondalgo.java.petshop.models.Category;

public interface CategoryDao {
	void saveCategory(Category category);

	List<Category> findAllCategories();

	Category findCategoryById(int id);

	void deleteCategory(Category category);

	void updateCategory(Category category);
}
