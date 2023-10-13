package com.scrapify.login.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scrapify.login.modal.Categories;
import com.scrapify.login.modal.Products;
import com.scrapify.login.modal.Register;
import com.scrapify.login.respository.CategoryRepo;
import com.scrapify.login.respository.ProductRepo;
import com.scrapify.login.respository.RegisterRepo;
import com.scrapify.login.service.RegisterService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@RestController
public class RegisterController {
@Autowired private RegisterService registerService;
@Autowired private RegisterRepo registerRepo;
@Autowired private CategoryRepo categoryRepo;
@Autowired private ProductRepo productRepo;


	@PostMapping("/register")
	public String addUser(Register register) {
	  registerService.saveUser(register);
	  return "registration success";
	}
	
	 @GetMapping("/product/{categoryId}")
	    public List<Products> getSubCategoriesForMainCategory(@PathVariable Integer categoryId) {
	        Categories Category = categoryRepo.findById(categoryId).orElse(null);
	        if (Category != null) {
	            return productRepo.findByCategory(Category);
	        } else {
	            return new ArrayList<>();
	        }
	    }
	 @PostMapping("/addproduct")
	 public Products addProduct(Products product ) {
	return 	productRepo.save(product) ;
	
	 }
	 @GetMapping("/getproduct")
	 public List<Products> getProduct(Products product ) {
	return 	productRepo.findAll() ;
	
	 }
	
	@GetMapping("/login")
	public ResponseEntity<Map<String, Object>> loginUser( String phone) {
		
		Register user = registerRepo.findByPhone(phone);
		 Map<String, Object> response = new HashMap<>();

		if(user!=null) {
			response.put("user", user);
		    response.put("message", "Login success");
		
			 return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
	            throw new UsernameNotFoundException("User not found with phone number: " + phone);
	        }
		
	}
	
	@GetMapping("/category")
	public List<Categories> getCategeory() {
		return registerService.getCategory();
	}
}
