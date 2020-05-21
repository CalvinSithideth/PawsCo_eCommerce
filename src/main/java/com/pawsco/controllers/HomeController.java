package com.pawsco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("home")
	public String homeImage() {
		return "home";
	}
	@GetMapping("signin")
	public String signIn() {
		return "signin";
	}
	@GetMapping("loggedOut")
	public String loggout() {
		return "loggedOut";
	}
	@GetMapping("register")
	public String register() {
		return "register";
	}
	@GetMapping("view_cookies")
	public String view_cookies() {
		return "view_cookies";
	}
	@GetMapping("aboutus")
	public String aboutus() {
		return "aboutus";
	}
	
	@GetMapping("careers")
	public String careers() {
		return "careers";
	}
	@GetMapping("userstories")
	public String userstories() {
		return "userstories";
	}
	@GetMapping("testimonials")
	public String testimonials() {
		return "testimonials";
	}
	@GetMapping("press")
	public String press() {
		return "press";
	}
	@GetMapping("photos")
	public String photos() {
		return "photos";
	}
	@GetMapping("payments")
	public String payments() {
		return "payments";
	}
	@GetMapping("shipping")
	public String shipping() {
		return "shipping";
	}
	
	@GetMapping("cancellation&return")
	public String cancellationreturn() {
		return "cancellation&return";
	}
	@GetMapping("faq")
	public String faq() {
		return "faq";
	}
//	@GetMapping("wishlist")
//	public String wishList() {
//		return "wishlist";
//	}
}

