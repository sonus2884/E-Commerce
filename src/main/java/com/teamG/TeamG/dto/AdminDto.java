//----------------ADMIN REGISTRATION THROUGH JSON ---------------//

package com.teamG.TeamG.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.teamG.TeamG.validation.EmailValidate;

import lombok.NonNull;

public class AdminDto {
	
	@NonNull
	@Size(min = 5)
	private String fullName;
	
	@NonNull
	@Size(min = 6)
	private String password;
	
	@EmailValidate
	private String email;
	
	private String role;
	
	

	public AdminDto(String fullName, String password, String email,String role) {
		super();
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.role=role;
	}

	

	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
	
	

	
}
