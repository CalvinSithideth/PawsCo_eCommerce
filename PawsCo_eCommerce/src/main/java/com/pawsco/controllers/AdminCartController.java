package com.pawsco.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawsco.cart.CartService;

@Controller
@RequestMapping("/admincart")
public class AdminCartController {
	
	@GetMapping
	public String viewCart() {
		return "adminCart";
	}
	
	@PostMapping
	public String updateCart(@RequestParam String action, @RequestParam int productID, @RequestParam(required = false) Integer quantity, HttpSession session) {
		
		switch (action) {
			case "add":
				CartService.addToCart(productID, quantity, session);
				break;
			case "remove":
				CartService.removeFromCart(productID, session);
				break;
			case "edit":
				CartService.editQuantity(productID, quantity, session);
				break;
		}
		return "adminCart";
	}
}
