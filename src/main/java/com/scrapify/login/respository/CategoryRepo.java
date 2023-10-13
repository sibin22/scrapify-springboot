package com.scrapify.login.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrapify.login.modal.Categories;
@Repository
public interface CategoryRepo extends JpaRepository <Categories,Integer> {

	Optional<Categories> findById(Long mainCategoryId);

}
