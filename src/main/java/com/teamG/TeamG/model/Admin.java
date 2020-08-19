package com.teamG.TeamG.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.teamG.TeamG.validation.EmailValidate;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min = 6)
	private String 	fullName;
	
	@Column
	@EmailValidate
	private String email;
	
	@Column
	@Size(min = 6)
	private String password;
	
	@Column
	private String role;
	
	@JoinColumn(name="admin_id")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Products> products;

	public Admin() {
		
	}

	public Admin(String fullName, String email, String password, String role) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
	
	/*
	 * @Override public String toString() { return "Admin [id=" + id + ", username="
	 * + username + ", password=" + password + "]"; }
	 */
	
	

}
