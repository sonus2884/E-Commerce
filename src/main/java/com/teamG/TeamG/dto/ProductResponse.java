package com.teamG.TeamG.dto;

public class ProductResponse {
	
private int cake_id;
	
	private String cake_name;
	
	private String size;
	
	private String material;
	
	private int price;
	
	private int discount;
	
	private int availability;
	
	private int admin_id;
	
	public ProductResponse() {
		
	}

	public ProductResponse(int cake_id, String cake_name, String size, String material, int price, int discount,
			int availability, int admin_id) {
		super();
		this.cake_id = cake_id;
		this.cake_name = cake_name;
		this.size = size;
		this.material = material;
		this.price = price;
		this.discount = discount;
		this.availability = availability;
		this.admin_id = admin_id;
	}

	public int getCake_id() {
		return cake_id;
	}

	public void setCake_id(int cake_id) {
		this.cake_id = cake_id;
	}

	public String getCake_name() {
		return cake_name;
	}

	public void setCake_name(String cake_name) {
		this.cake_name = cake_name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	


}
