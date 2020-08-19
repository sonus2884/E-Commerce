package com.teamG.TeamG.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.teamG.TeamG.dto.AdminDto;
import com.teamG.TeamG.dto.AdminResponseDto;
import com.teamG.TeamG.exception.AdminExistsException;
import com.teamG.TeamG.model.Admin;
import com.teamG.TeamG.model.Products;
import com.teamG.TeamG.model.User;
import com.teamG.TeamG.repository.AdminRepository;
import com.teamG.TeamG.repository.ProductRepository;
import com.teamG.TeamG.repository.UserRepository;


@Service
public class AdminServiceImpl implements AdminService {
	
	
	private AdminRepository adminRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;

	

	@Autowired
	AdminServiceImpl(AdminRepository adminRepository){
		
		this.adminRepository = adminRepository;
		
	}

	
	//------------ADMIN REGISTRATION ------------------//
	
	
	@Override
	public Admin registerAdmin(AdminDto adminDto) {
		// TODO Auto-generated method stub
		
		
		//Create new admin..
		
		if(adminRepository.findByEmail(adminDto.getEmail()) != null){

            //Admin Account is already found;
            throw new AdminExistsException("Admin with \'" + adminDto.getEmail()+ " \' email already exists");

        }
		
		Admin admin = new Admin();
		
		admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
		admin.setFullName(adminDto.getFullName());
		admin.setEmail(adminDto.getEmail());
		admin.setRole(adminDto.getRole());
		
		Admin saveAdmin = adminRepository.save(admin); //.save is by default method of JpaRepository
		
		
		return saveAdmin;
	}
	
	
	//------------SHOWING ALL PRODUCT ------------------//
	
	@Override
	public Iterable<Products> findAdminByEmail() {
						
			System.out.println("Found!!");
			
			return productService.getProducts(); //getProducts();  method defined in ProductService.java
			 
			
			
		
	}
	
	//------------SEARCHING PRODUCT BY ID ------------------//
	
	@Override
	public Products findAdminByEmailProductById(int id) {
		// TODO Autemaio-generated method stub
						
			System.out.println("Found!!");
			
			return productService.getProductById(id); // this will return all the details of the particular product id getProductById(id); this method is defined at ProductService.java  

		
	}

	
	//------------DELETE PRODUCT------------------//
	
	@Override
	public String findAdminByEmailDeleteProductById( int id) {
		
				
			return productService.deleteProduct(id); // delete the details of the particular product id

	}

	
	
	//------------UPDATE PRODUCT ------------------//
	
	@Override
	public Products findAdminByEmailUpdate(int id,Products product) {
		
			  
			 return productService.updateProduct(product,id);  // method defined in ProductService.java
		
	}

	
	//------------ADD PRODUCT ------------------//
	
	
	@Override
	public Products findAdminAndAddProduct( Products product) {
		
			return productService.saveProducts(product); // method defined in ProductService.java

	
	}


	@Override
	public List<Products> findPaginated( int pageNo, int pageSize) {
		
		//if(adminRepository.findByEmail( email )!= null && adminRepository.findByPassword(password) != null) {
			//Sort sort = Sort.by(Sort.Direction.ASC,"cake_name");
			Pageable paging = PageRequest.of(pageNo, pageSize);
	        Page<Products> pagedResult = productRepository.findAll(paging);
	        	return pagedResult.toList();
	        
		//}
		//return null;
	}


	
	
	
}
