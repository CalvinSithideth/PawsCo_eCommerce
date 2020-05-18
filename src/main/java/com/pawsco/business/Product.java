package com.pawsco.business;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private int productID;
	private String category;
	private String name;
	private String description;
	private double price;
	private String imageFileName;
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", category=" + category + ", name=" + name + ", description="
				+ description + ", price=" + price + ", imageFileName=" + imageFileName + "]";
	}

}
