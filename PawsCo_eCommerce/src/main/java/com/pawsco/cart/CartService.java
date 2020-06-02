package com.pawsco.cart;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.pawsco.business.LineItem;
import com.pawsco.models.ProductModel;


public class CartService {

	public static void addToCart(int productID, int quantity, HttpSession session) {
		// Load list of products from db
		ProductModel pm = new ProductModel();

		// Check if a cart exists, if not make a new one and add item
		if (session.getAttribute("cart") == null) {
			List<LineItem> cart = new ArrayList<LineItem>();
			cart.add(new LineItem(pm.findProduct(productID), quantity));

			// Save cart to session
			session.setAttribute("cart", cart);
		} else {
			// Load cart if it already exists
			@SuppressWarnings("unchecked")
			List<LineItem> cart = (List<LineItem>) session.getAttribute("cart");

			// Check if item already exists in cart, append qty if it does
			int index = findInCart(productID, cart);
			if (index == -1) {
				cart.add(new LineItem(pm.findProduct(productID), quantity));
			} else {
				int newQuantity = cart.get(index).getQuantity() + quantity;
				cart.get(index).setQuantity(newQuantity);
			}

			// Save cart to session
			session.setAttribute("cart", cart);
		}
	}

	public static void removeFromCart(int productID, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<LineItem> cart = (List<LineItem>)session.getAttribute("cart");
		int index = findInCart(productID, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
	}
	
	public static void editQuantity(int productID, int quantity, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<LineItem> cart = (List<LineItem>)session.getAttribute("cart");
		int index = findInCart(productID, cart);
		cart.get(index).setQuantity(quantity);
		session.setAttribute("cart", cart);
	}
	
	public static void emptyCart(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<LineItem> cart = (List<LineItem>)session.getAttribute("cart");
		cart.clear();
		session.setAttribute("cart", cart);
	}

	// Private method to find index of item in cart, or return -1 if not present
	private static int findInCart(int productID, List<LineItem> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getProductID() == productID) {
				return i;
			}
		}
		return -1;
	}
}
