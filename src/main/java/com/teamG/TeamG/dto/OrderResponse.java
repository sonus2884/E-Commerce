//--------------------RESPONSE AGAINST ORDER PLACED -------------------//


package com.teamG.TeamG.dto;

import java.sql.Date;

public class OrderResponse {
	
	 private String fullName;  //user er full name r cake er name return korche
	// private String productName;
	 
	 private String email;
	 
	 private int cakeId;
	 private Date date;
	 private int quantity;
		
	   
		public OrderResponse() {
			
		}
		
//		public OrderResponse(String fullName, String productName) {
//			super();
//			this.fullName = fullName;
//			this.productName = productName;
//		}
		
		

		public OrderResponse(String fullName, String email, int cakeId, Date date,int quantity) {
			super();
			this.fullName = fullName;
			this.email = email;
			this.cakeId = cakeId;
			this.date = date;
			this.quantity=quantity;
			
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

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		
		
		/*
		 * public String getProductName() { return productName; } public void
		 * setProductName(String productName) { this.productName = productName; }
		 */
	
	
	

}
