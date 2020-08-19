package com.teamG.TeamG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamG.TeamG.model.Admin;
import com.teamG.TeamG.model.Products;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByEmail(String email);

	Object findByPassword(String password);

	Products findById(int i);

	
//	Admin FindByEmail(String email);

//	Admin findByEmail(String email);
}
