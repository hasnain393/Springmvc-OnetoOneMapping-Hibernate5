package com.lti.springmvc.spring.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="TBL_PRODUCT")
public class Product {

	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int id;
	private String name;
	private String brand;
	private double price;
	private int stock;
	
	@Transient
	private MultipartFile file;
	
	private String img_path;

	public Product() {
		super();
	}

	

	public Product(int id, String name, String brand, double price, int stock, MultipartFile file, String img_path) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
		this.file = file;
		this.img_path = img_path;
	}



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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	
	public String getImg_path() {
		return img_path;
	}



	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", stock=" + stock
				+ ", file=" + file + ", img_path=" + img_path + "]";
	}



	
	
	
	
}