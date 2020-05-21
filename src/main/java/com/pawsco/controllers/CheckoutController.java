package com.pawsco.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.pawsco.business.LineItem;
import com.pawsco.business.User;
import com.pawsco.cart.CartService;
import com.pawsco.checkout.CheckoutService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	@GetMapping
	public String checkout() {
		return "checkout";
	}
	
	@PostMapping
	public ModelAndView completeCheckout(@SessionAttribute("user") User user, @SessionAttribute("cart") List<LineItem> cart, HttpSession session) {
		int orderID = CheckoutService.saveOrder(user, cart);
		CartService.emptyCart(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("orderConfirmation");
		mav.addObject("orderID", orderID);
		return mav;
	}
}
