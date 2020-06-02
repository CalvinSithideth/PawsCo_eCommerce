package com.pawsco.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.pawsco.business.LineItem;
import com.pawsco.models.ProductModel;

public class AdminCartService {
	
	public static void addToCart(int productID, int quantity, HttpSession session) {
		// Load list of products from db
		ProductModel pm = new ProductModel();

		// Check if a cart exists, if not make a new one and add item
		if (session.getAttribute("adminCart") == null) {
			List<LineItem> adminCart = new ArrayList<LineItem>();
			adminCart.add(new LineItem(pm.findProduct(productID), quantity));

			// Save cart to session
			session.setAttribute("adminCart", adminCart);
		} else {
			// Load cart if it already exists
			@SuppressWarnings("unchecked")
			List<LineItem> adminCart = (List<LineItem>) session.getAttribute("adminCart");

			// Check if item already exists in cart, append qty if it does
			int index = findInCart(productID, adminCart);
			if (index == -1) {
				adminCart.add(new LineItem(pm.findProduct(productID), quantity));
			} else {
				int newQuantity = adminCart.get(index).getQuantity() + quantity;
				adminCart.get(index).setQuantity(newQuantity);
			}

			// Save cart to session
			session.setAttribute("adminCart", adminCart);
		}
	}

	public static void removeFromCart(int productID, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<LineItem> adminCart = (List<LineItem>)session.getAttribute("adminCart");
		int index = findInCart(productID, adminCart);
		adminCart.remove(index);
		session.setAttribute("adminCart", adminCart);
	}
	
	public static void editQuantity(int productID, int quantity, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<LineItem> adminCart = (List<LineItem>)session.getAttribute("adminCart");
		int index = findInCart(productID, adminCart);
		adminCart.get(index).setQuantity(quantity);
		session.setAttribute("adminCart", adminCart);
	}
	
	public static void emptyCart(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<LineItem> adminCart = (List<LineItem>)session.getAttribute("adminCart");
		adminCart.clear();
		session.setAttribute("adminCart", adminCart);
	}

	// Private method to find index of item in cart, or return -1 if not present
	private static int findInCart(int productID, List<LineItem> adminCart) {
		for (int i = 0; i < adminCart.size(); i++) {
			if (adminCart.get(i).getProduct().getProductID() == productID) {
				return i;
			}
		}
		return -1;
	}
}

