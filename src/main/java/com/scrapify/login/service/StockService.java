package com.scrapify.login.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrapify.login.modal.Products;
import com.scrapify.login.modal.Register;
import com.scrapify.login.respository.ProductRepo;
import com.scrapify.login.respository.RegisterRepo;

@Service
public class StockService {
	
@Autowired RegisterRepo registerRepo;
@Autowired ProductRepo productRepo;

	public List<Register> findAllSeller(){
		
		List<Register> sortedUsers = registerRepo.findAll().stream()
		        .sorted((user1, user2) -> Integer.compare(user2.getProduct().size(), user1.getProduct().size()))
		        .collect(Collectors.toList());
		return sortedUsers;
	}

	public Optional<Register> findSellerById(Integer userId) {
		
		return registerRepo.findById(userId);
	}

	public void addProductsToSeller(Integer userId, List<Integer> productId) {
		
		   Register user = registerRepo.findById(userId).orElse(null);

		      Collection<Products> product = productRepo.findAllById(productId);
		        user.getProduct().addAll(product);

		        registerRepo.save(user);
		
	};
	
	

}
