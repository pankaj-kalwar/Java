package com.beyondalgo.java.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beyondalgo.java.petshop.daos.CategoryDao;
import com.beyondalgo.java.petshop.models.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public void saveCategory(Category category) {
		categoryDao.saveCategory(category);
	}

	public List<Category> findAllCategories() {
		return categoryDao.findAllCategories();
	}

	public Category findCategoryById(int id) {
		return categoryDao.findCategoryById(id);
	}

	public void deleteCategory(Category category) {
		categoryDao.deleteCategory(category);
	}

	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}

}
