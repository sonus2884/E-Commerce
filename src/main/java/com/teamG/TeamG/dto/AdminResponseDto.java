//-------------------RESPONSE AGAINST ADMIN REGISTRATION --------------//

package com.teamG.TeamG.dto;

public class AdminResponseDto {
	
	private int id;
	
	private String fullName;
	
	private String password;
	
	private String email;
	
	private String role;

	public AdminResponseDto(int id,String fullName, String password, String email, String role) {
		this.id=id;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
