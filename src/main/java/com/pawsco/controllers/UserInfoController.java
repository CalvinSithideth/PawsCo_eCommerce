package com.pawsco.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.pawsco.account.AccountService;
import com.pawsco.business.Address;
import com.pawsco.business.User;

@Controller
public class UserInfoController {

	@GetMapping("myAccount")
	public ModelAndView accountPage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User user = (User)session.getAttribute("user");
		Address address = AccountService.getAddress(user.getEmail());
		if (address == null) {
			address = new Address();
		}
		mav.addObject("address", address);
		mav.setViewName("myAccount");
		return mav;
	}
	
	@PostMapping("editAccount")
	public ModelAndView updateAccountInfo(@SessionAttribute("user") User user, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myAccount");
		return mav;
	}
	
	@PostMapping("editAddress")
	public ModelAndView updateAddressInfo(@SessionAttribute("user") User user, @RequestParam("street") String street, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("zip") String zip) {
		ModelAndView mav = new ModelAndView();
		AccountService.updateAddress(user.getEmail(), street, city, state, zip);
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		mav.addObject("address", address);
		mav.setViewName("myAccount");
		return mav;
	}
}
