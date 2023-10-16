package com.scrapify.login.modal;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Stock {
	@Id
	private Integer id;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private Register register;
	  
	 @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
       name = "user_products",
       joinColumns = @JoinColumn(name = "user_id"),
       inverseJoinColumns = @JoinColumn(name = "product_id"))
	  private List<Products> product = new ArrayList<>();


	    private Double price; 

	    private Integer quantity;

}
