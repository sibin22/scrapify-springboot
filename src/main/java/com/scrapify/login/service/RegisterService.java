package com.scrapify.login.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scrapify.login.modal.Categories;
import com.scrapify.login.modal.Products;
import com.scrapify.login.modal.Register;
import com.scrapify.login.respository.CategoryRepo;
import com.scrapify.login.respository.ProductRepo;
import com.scrapify.login.respository.RegisterRepo;


@Service
public class RegisterService {

	@Autowired private RegisterRepo registerRepo ;
	@Autowired private CategoryRepo categoryRepo ;
	@Autowired private ProductRepo productRepo ;
	
	public Register saveUser( Register register) {
		return registerRepo.save(register);
		}
		
	public  Register loginUser(String phone) {
	  return registerRepo.findByPhone(phone);
		
	}
	
	
	
	public List<Products> getSubCategory(Integer categoryId) {
		
	    Categories Category = categoryRepo.findById(categoryId).orElse(null);
	    
        if (Category != null) {
            return productRepo.findByCategory(Category);
        } else {
            return new ArrayList<>();
        }
		
	}

	public Products addProduct(Products product) {
		
		return 	productRepo.save(product) ;
	}

	public ResponseEntity<Map<String, Object>> loginUserWithPhone(String phone) throws Exception {
		
		Register user = registerRepo.findByPhone(phone);
		 Map<String, Object> response = new HashMap<>();

		if(user!=null) {
			response.put("user", user);
		    response.put("message", "Login success");
		
			 return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
	            throw new Exception("User not found with phone number: " + phone);
	        }
	}

	public List<Categories> getCategory() {
		return categoryRepo.findAll();
	}
	
	
}
