package com.scrapify.login.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.scrapify.login.modal.Register;
import com.scrapify.login.respository.ProductRepo;
import com.scrapify.login.respository.RegisterRepo;
import com.scrapify.login.respository.StockRepo;
import com.scrapify.login.service.StockService;

@RestController
public class StockController {
	
	
	@Autowired StockRepo stockRepo;
	@Autowired RegisterRepo registerRepo;
	@Autowired ProductRepo productRepo;
	@Autowired StockService stockService;
	
	@GetMapping("/stock")
	public List<Register> getUser() {
	     return	stockService.findAllSeller();
	}
	
	@GetMapping("/stock/{userId}")
	public Optional<Register> getUserwithProduct(@PathVariable Integer userId) {
		return stockService.findSellerById(userId);}
		

	 @PostMapping("/stock/{userId}/add")
	    public ResponseEntity<String> addUserProduct(
	        @PathVariable Integer userId,
	        @RequestBody List<Integer> productId) {
	      
	         stockService.addProductsToSeller(userId,productId);

	        return ResponseEntity.ok("Product added successfully.");}
	

	}

