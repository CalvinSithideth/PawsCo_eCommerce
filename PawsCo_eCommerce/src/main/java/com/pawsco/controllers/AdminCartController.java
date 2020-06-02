package com.pawsco.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.pawsco.business.LineItem;
import com.pawsco.cart.AdminCartService;

@Controller
public class AdminCartController {

	@GetMapping("adminCart")
	public String viewCart() {
		return "adminCart";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("adminCart")
	public String adminCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int productID = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String action = (String) request.getParameter("action");

		System.out.println(action);
		List<LineItem> adminCart;
		if (session.getAttribute("adminCart") == null) {
			adminCart = new ArrayList<>();
		} 
			else {
			adminCart = (List<LineItem>) session.getAttribute("adminCart");
		}
		switch (action) {
		case "add":
			AdminCartService.addToCart(productID, quantity, session);
			break;
		case "remove":
			AdminCartService.removeFromCart(productID, session);
			break;
		case "edit":
			AdminCartService.editQuantity(productID, quantity, session);
			break;
		}
		session.setAttribute("adminCart", adminCart);
		return "adminCart";
	}
	
	@PostMapping("adminCheckout")
	public String submitOrder() {
		return "adminCheckout";
		
	}
}
