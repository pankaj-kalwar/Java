package com.beyondalgo.java.petshop.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.beyondalgo.java.petshop.models.Category;
import com.beyondalgo.java.petshop.services.CategoryService;

@RestController
@RequestMapping(value="/category")
public class CategoryRestController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testMethod() {
		return "Test Data";
	}
	
	@RequestMapping(value="/getCategories", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getCategories(){
		List<Category> employees = new ArrayList<Category>();
		employees = categoryService.findAllCategories();
		if(employees.isEmpty()){
			//You many decide to return HttpStatus.NOT_FOUND
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<List<Category>>(employees, HttpStatus.OK);
	}
	
	//-------------------Retrieve Single Category--------------------------------------------------------
    
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getEmployee(@PathVariable("id") int id) {
        System.out.println("Fetching Category with id " + id);
        Category category = categoryService.findCategoryById(id);
        if (category == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Category--------------------------------------------------------
     
    @RequestMapping(value = "/category/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Category " + category.getName());

        categoryService.saveCategory(category);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getCategoryId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a Category --------------------------------------------------------
     
    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
        System.out.println("Updating Category " + id);
         
        Category currentCategory = categoryService.findCategoryById(id);
         
        if (currentCategory==null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
 
        currentCategory.setName(category.getName());
         
        categoryService.updateCategory(currentCategory);
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }
 
    //------------------- Delete a Category --------------------------------------------------------
     
    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteEmployee(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Category with id " + id);
 
        Category category = categoryService.findCategoryById(id);
        if (category == null) {
            System.out.println("Unable to delete. Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
 
        //categoryService.deleteCategory(category);;
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}
