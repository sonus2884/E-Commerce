package com.teamG.TeamG.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamG.TeamG.model.Products;
import com.teamG.TeamG.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository; // productRepository is obj of ProductRepository
	
	public Products saveProducts(Products products) {
		return productRepository.save(products); //save(products); by default of  JpaRepository
	}
	
	public Iterable<Products> getProducts(){
		return productRepository.findAll();  //same as above
	}
	
	public Products getProductById(int id) {
		return productRepository.findById(id).orElse(null); //if findById(id) method doesnt work then orElse(null) return null
	}
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id); // default method of jpaRepository
		return "Product removed: "+id;
	}
	
	public Products updateProduct(Products products, int id) {
		
		Products existProduct=productRepository.findById(id).orElse(null); //existProduct is object of Products class
		existProduct.setCake_name(products.getCake_name());
		existProduct.setSize(products.getSize());
		existProduct.setMaterial(products.getMaterial());
		existProduct.setPrice(products.getPrice());
		existProduct.setDiscount(products.getDiscount());
		existProduct.setAvailability(products.getAvailability());
	//	existProduct.setImage(products.getImage());
		existProduct.setAdmin_id(products.getAdmin_id());
		
		return productRepository.save(existProduct);  // actually updating this object
				
	}


}
