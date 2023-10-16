package com.scrapify.login.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrapify.login.modal.Categories;
import com.scrapify.login.modal.Products;

@Repository
public interface ProductRepo extends JpaRepository <Products,Integer> {

	List<Products> findByCategory(Categories category);

	Products findAllById(Integer productId);

	List<Products> getProductsById(Integer productId);

}
