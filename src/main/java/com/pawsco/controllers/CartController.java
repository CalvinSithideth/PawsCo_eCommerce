package com.pawsco.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawsco.business.LineItem;
import com.pawsco.models.ProductModel;

@Controller
public class CartController {
	
	@PostMapping("/cart")
	public String addToCart(@RequestParam int productID, @RequestParam int quantity, HttpSession session) {
		
		// Load list of products from db
		ProductModel pm = new ProductModel();
		
		// Check if a cart exists, if not make a new one and add item
		if (session.getAttribute("cart") == null) {
			List<LineItem> cart = new ArrayList<LineItem>();
			cart.add(new LineItem(pm.findProduct(productID), quantity));
			
			// Save cart to session
			session.setAttribute("cart", cart);
			
			// Console output for testing, can be removed
			System.out.println(cart);
		} else {
			// Load cart if it already exists
			@SuppressWarnings("unchecked")
			List<LineItem> cart = (List<LineItem>)session.getAttribute("cart");
			
			// Check if item already exists in cart, append qty if it does
			int index = this.existsInCart(productID, cart);
			if (index == -1) {
				cart.add(new LineItem(pm.findProduct(productID), quantity));
			} else {
				int newQuantity = cart.get(index).getQuantity() + quantity;
				cart.get(index).setQuantity(newQuantity);
			}
			
			// Console output for testing
			System.out.println(cart);
			
			// Save cart to session
			session.setAttribute("cart", cart);
		}
		
		// This is returning to home as a placeholder, will be changed
		return "home";
	}
	
	// Private method to check if an item exists and grabbing the collection index
	private int existsInCart(int productID, List<LineItem> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getProductID() == productID) {
				return i;
			}
		}
		return -1;
	}
}
