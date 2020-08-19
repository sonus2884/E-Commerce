package com.teamG.TeamG.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="product_details")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cake_id;
	@Column
	private String cake_name;
	@Column
	private String size;
	@Column
	private String material;
	@Column
	private int price;
	@Column
	private int discount;
	@Column
	private int availability;
	@Lob
	private byte[] image;
	@Column
	private int admin_id;

	 @ManyToMany(fetch = FetchType.LAZY,mappedBy = "products",cascade = CascadeType.ALL)
	 private List<User> users;
	public Products() {
		
	}
	
	
	public Products(String cake_name, String size, String material, int price, int discount,
			int availability, byte[] image, int admin_id) {
		super();
		//this.cake_id = cake_id;
		this.cake_name = cake_name;
		this.size = size;
		this.material = material;
		this.price = price;
		this.discount = discount;
		this.availability = availability;
		this.image = image;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	/*
	 * public List<User> getUsers() { return users; }
	 * 
	 * 
	 * public void setUsers(List<User> users) { this.users = users; }
	 */


	/*
	 * @Override public String toString() { return "Products [cake_id=" + cake_id +
	 * ", cake_name=" + cake_name + ", size=" + size + ", material=" + material +
	 * ", price=" + price + ", discount=" + discount + ", availability=" +
	 * availability + ", image=" + Arrays.toString(image) + ", admin_id=" + admin_id
	 * + "]"; }
	 */
	
	
	
}
