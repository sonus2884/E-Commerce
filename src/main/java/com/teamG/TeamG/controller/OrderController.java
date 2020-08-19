package com.teamG.TeamG.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamG.TeamG.dto.AdminResponseDto;
import com.teamG.TeamG.dto.OrderDto;
import com.teamG.TeamG.dto.OrderResponse;
import com.teamG.TeamG.dto.ProductResponse;
import com.teamG.TeamG.dto.ResponseDto;

import com.teamG.TeamG.model.Products;
import com.teamG.TeamG.model.User;
import com.teamG.TeamG.repository.UserRepository;
import com.teamG.TeamG.service.ProductService;
import com.teamG.TeamG.service.UserService;

@RestController
public class OrderController {
	
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	

	
	@Autowired
	public OrderController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	
	//-------------SHOWING THE PRODUCT TO THE USER -----------------//
	
	
	
	  @GetMapping("/user/product")
	  public List<ProductResponse> showproduct() {
	  
		  Iterable<Products> productList = productService.getProducts();
		  
		  List<ProductResponse> prList=new ArrayList<>();
		  
		  for (Products products : productList) {
			  
			  ProductResponse pr=new ProductResponse();
				
			  pr.setCake_id(products.getCake_id());
			  pr.setCake_name(products.getCake_name());
			  pr.setSize(products.getSize());
			  pr.setMaterial(products.getMaterial());
			  pr.setPrice(products.getPrice());
			  pr.setDiscount(products.getDiscount());
			  pr.setAvailability(products.getAvailability());
			  pr.setAdmin_id(products.getAdmin_id());
				
			  prList.add(pr);
			
		}
  
		  return prList;
		 
	  
	 }
	  
	  
   //---------------USER PLACING ORDER ---------------------//	  
	
	 @PostMapping("/placeOrder")
	 public ResponseDto<OrderResponse> placeOrder(@RequestBody OrderDto orderDto) //user er name emailid cake id dite hobe
	 {
		 
		 User user=userService.placeOrder(orderDto);
		 
		 	return new ResponseDto<>(
					HttpStatus.OK,
					new OrderResponse(user.getFullName(),user.getEmail(),user.getCakeId(),user.getDate(),user.getQuantity()));


	    }
	 
	 @GetMapping("/showImage/{id}")
	 public ResponseEntity<byte[]> fromDatabaseAsResEntity(@PathVariable("id") Integer id) 
	         throws SQLException {

	 	Optional<Products> cakeImage = Optional.of(productService.getProductById(id));
	 	byte[] imageBytes = null;
	 	if (cakeImage.isPresent()) {
	 	
	 		imageBytes = cakeImage.get().getImage();
	 	}
	 	
	 	return ResponseEntity.ok().contentType(org.springframework.http.MediaType.IMAGE_JPEG).body(imageBytes);
	 }
	 	
	 
		
		

}
