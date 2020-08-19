//------------PASSING ORDER THROUGH JSON ----------------------//


package com.teamG.TeamG.dto;

import java.sql.Date;
import java.util.List;

import com.teamG.TeamG.model.Products;


public class OrderDto {
	
	private String fullName;  // json e Raw data pass hobe 3 feilds
    private String email;    

    private int cakeId;  
    
    private Date date;
    
    
    private int quantity;

	public OrderDto() {
		
	}
	
	

	public OrderDto(String fullName, String email, int cakeId,Date date,int quantity) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.cakeId = cakeId;
		this.date=date;
		this.quantity=quantity;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
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



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	


}
	
	

	
	
	
	

