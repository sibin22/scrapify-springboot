package com.scrapify.login.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrapify.login.modal.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock,Integer>{

}
