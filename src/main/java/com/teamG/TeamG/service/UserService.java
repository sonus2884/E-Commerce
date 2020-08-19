package com.teamG.TeamG.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.teamG.TeamG.dto.OrderDto;
import com.teamG.TeamG.model.Products;
import com.teamG.TeamG.model.User;
import com.teamG.TeamG.repository.AdminRepository;
import com.teamG.TeamG.repository.ProductRepository;
import com.teamG.TeamG.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private AdminRepository adminRepository;
//--------------------
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	//------------USER PLACING ORDER ------------------//
	
	public User placeOrder(OrderDto orderDto) // user placeorder method 
	
	
	{
		
		User user = new User(); //user entity class er obj user
        user.setFullName(orderDto.getFullName());
        user.setEmail(orderDto.getEmail());
        user.setCakeId(orderDto.getCakeId());
        user.setDate(orderDto.getDate());
        user.setQuantity(orderDto.getQuantity());
        
		/*
		 * Products products = productRepository.getOne(orderDto.getCakeId());
		 * 
		 * List<Products> allProduct = new ArrayList();
		 * 
		 * allProduct.add(products);
		 * 
		 * user.setProducts(allProduct);
		 */ 

        User savedUser = userRepository.save(user); // user order save hocche..
		
	
        return savedUser;
	
	}

	

	//------------WEEKLY REPORT ------------------//
	
	

	  public List<User> getAllUsersByReport(Date Start_date, Date End_date) {
	  
	  
	  return userRepository.findUserReport(Start_date,End_date); 
	  }



	//===== Monthly Report ------------//
	public List<User> getAllUsersByReportMonthly(Date Start_date, Date End_date)
	{


		return userRepository.findUserReportMonthly(Start_date,End_date); }



}
