package com.scrapify.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrapify.login.modal.Categories;
import com.scrapify.login.modal.Register;
import com.scrapify.login.respository.CategoryRepo;
import com.scrapify.login.respository.RegisterRepo;

@Service
public class RegisterService {

	@Autowired private RegisterRepo registerRepo ;
	@Autowired private CategoryRepo categoryRepo ;
	public void saveUser( Register register) {
		registerRepo.save(register);
		}
	
	
	public  Register loginUser(String phone) {
	  return registerRepo.findByPhone(phone);
		
	}
	
	public  List<Categories> getCategory() {
		return categoryRepo.findAll();
	}
}
