package com.CRUD.Java8.Example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class ProductEntity 
{
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int id;
	@Column(name = "product_name")
	private String name;
	@Column(name = "product_price")
	private int price;
	@Column(name = "product_brand")
	private String brand;
	@Column(name = "product_quantity")
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", price=" + price + ", brand=" + brand + ", quantity="
				+ quantity + "]";
	}
	public ProductEntity() {
	
	}
	public ProductEntity(int id, String name, int price, String brand, int quantity) {
	
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.quantity = quantity;
	}

}
