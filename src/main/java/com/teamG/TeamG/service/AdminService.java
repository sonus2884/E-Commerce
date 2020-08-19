package com.teamG.TeamG.service;

import java.util.List;

import com.teamG.TeamG.dto.AdminDto;
import com.teamG.TeamG.model.Admin;
import com.teamG.TeamG.model.Products;
import com.teamG.TeamG.model.User;

public interface AdminService {
	
	Admin registerAdmin(AdminDto adminDto);
	
	Iterable<Products> findAdminByEmail();

	Products findAdminByEmailUpdate(int id, Products products);

	Products findAdminByEmailProductById( int id);
	
	String findAdminByEmailDeleteProductById( int id);
	
	Products findAdminAndAddProduct(Products products);


	List<Products> findPaginated(int pageNo, int pageSize);

	

	

}
