package com.scrapify.login.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrapify.login.modal.Register;

@Repository
public interface RegisterRepo extends  JpaRepository<Register, Integer>{
Register findByPhone( String phone);

Register findUserWithProductsById(Integer userId);
}
