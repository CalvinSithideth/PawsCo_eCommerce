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
		
		/*
		 * Check if the cart exists, if not make a new one.
		 * 
		 */
		if (session.getAttribute("cart") == null) {
			List<LineItem> cart = new ArrayList<LineItem>();
			cart.add(new LineItem(pm.findProduct(productID), quantity));
			session.setAttribute("cart", cart);
			System.out.println(cart);
		} else {
			@SuppressWarnings("unchecked")
			List<LineItem> cart = (List<LineItem>)session.getAttribute("cart");
			int index = this.existsInCart(productID, cart);
			if (index == -1) {
				cart.add(new LineItem(pm.findProduct(productID), quantity));
			} else {
				int newQuantity = cart.get(index).getQuantity() + quantity;
				cart.get(index).setQuantity(newQuantity);
			}
			System.out.println(cart);
			session.setAttribute("cart", cart);
		}
		return "home";
	}
	
	private int existsInCart(int productID, List<LineItem> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getProductID() == productID) {
				return i;
			}
		}
		return -1;
	}
}
