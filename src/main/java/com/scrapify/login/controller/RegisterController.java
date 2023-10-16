package com.scrapify.login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scrapify.login.modal.Categories;
import com.scrapify.login.modal.Products;
import com.scrapify.login.modal.Register;
import com.scrapify.login.respository.ProductRepo;
import com.scrapify.login.respository.RegisterRepo;
import com.scrapify.login.service.RegisterService;


@RestController
public class RegisterController {
	
@Autowired private RegisterService registerService;
@Autowired private RegisterRepo registerRepo;

@Autowired private ProductRepo productRepo;


	@PostMapping("/register")
	  public Register addUser(Register register) {
	 return registerService.saveUser(register);   
	}
		
	 @GetMapping("/product/{categoryId}")
	    public List<Products> getSubCategoriesForMainCategory(@PathVariable Integer categoryId) {
	    return registerService.getSubCategory(categoryId);
	    }
	 
	 @PostMapping("/add/product")
	 public Products addProduct(Products product ) {
	 return registerService.addProduct(product);
	
	 }
	 @GetMapping("/get/product")
	 public List<Products> getProduct(Products product ) {
	 return 	productRepo.findAll() ;
	 }
	 
	 
	 @PostMapping("/get/product/{id}")
	 public Optional<Products> getProductById(@PathVariable Integer id ) {
	 return 	productRepo.findById(id);}
	 
	
	 @GetMapping("/{userId}/products")
	    public Register getUserWithProducts(@PathVariable Integer userId) {
	        return registerRepo.findUserWithProductsById(userId);
	    }
	  
	  
	@GetMapping("/login")
	public ResponseEntity<Map<String, Object>> loginUser( String phone) throws Exception {
	return registerService.loginUserWithPhone(phone);
		
	}
	
	@GetMapping("/category")
	public List<Categories> getCategeory() {
		return registerService.getCategory();
	}
}
