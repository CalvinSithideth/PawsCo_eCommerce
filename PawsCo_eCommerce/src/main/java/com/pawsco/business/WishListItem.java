package com.pawsco.business;

import org.springframework.stereotype.Component;

@Component
public class WishListItem{


	private Product product;
	private User user;
	private int id;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addToWishlist() {

	}

	public void removeFromWishList() {

	}

	@Override
	public String toString() {
		return "WishListItem [product=" + product + ", user=" + user + ", id=" + id + "]";
	}

	
}
