package com.teamG.TeamG.model;

import java.sql.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.teamG.TeamG.validation.EmailValidate;



@Entity
@Table(name = "orderdetails")
public class User {

    private static final String GenerationTime = null;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String fullName;

    @EmailValidate(message = "Use Proper Email Id")
    private String email;
    
    private int cakeId;
    
    private int quantity;
    
    @JsonFormat(pattern ="dd-MM-yyyy", shape=Shape.STRING)
    @CreationTimestamp
    private Date date=new java.sql.Date(new java.util.Date().getTime()); 

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_product", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "userId")},
    inverseJoinColumns = {@JoinColumn(name = "cake_id", referencedColumnName = "cake_id")})
    private List<Products> products;
    
    
    

	public User() {
		super();
	}

	public User(String fullName, String email, int cakeId,Date date,int quantity) {
		super();
		//this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.cakeId = cakeId;
		this.date=date;
		this.quantity=quantity;
		//this.products = products;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
	
	

	public int getCakeId() {
		return cakeId;
	}

	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}

	/*
	 * public List<Products> getProducts() { return products; }
	 * 
	 * public void setProducts(List<Products> products) { this.products = products;
	 * }
	 */

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	



}