package com.scrapify.login.modal;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String role;
	private String businessType;
	private String email;
	private String phone;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	   @JoinTable(
	       name = "user_products",
	       joinColumns = @JoinColumn(name = "user_id"),
	       inverseJoinColumns = @JoinColumn(name = "product_id")
	       )
		  private List<Products> product = new ArrayList<>();
}

	


