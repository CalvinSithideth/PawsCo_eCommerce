package com.pawsco.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.pawsco.models.LineItem;
import com.pawsco.models.User;
import com.pawsco.services.CartService;
import com.pawsco.services.CheckoutService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	@GetMapping
	public ModelAndView checkout(@SessionAttribute("cart") List<LineItem> cart, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		if (session.getAttribute("user") == null) {
			mav.addObject("errorMessage", "You must be signed in to access this page");
			mav.setViewName("signin");
		} else {
			double subtotal = 0;
			for (LineItem item : cart) {
				subtotal += item.getProduct().getPrice() * item.getQuantity();
			}
			mav.addObject("subtotal", subtotal);
			mav.setViewName("checkout");
		}
		return mav;
	}
	
	@PostMapping
	public ModelAndView completeCheckout(@SessionAttribute("user") User user, @SessionAttribute("cart") List<LineItem> cart, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (CheckoutService.checkStocks(cart)) {
			int orderID = CheckoutService.saveOrder(user, cart);
			CartService.emptyCart(session);
			mav.setViewName("orderConfirmation");
			mav.addObject("orderID", orderID);
			return mav;
		} else {
			mav.setViewName("myCart");
			mav.addObject("checkoutErrorMessage", "We're sorry, but our supplies are insufficient to fulfill one of more items in your order.");
			return mav;
		}
		
	}
}
