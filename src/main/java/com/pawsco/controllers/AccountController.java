package com.pawsco.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pawsco.business.User;
import com.pawsco.db.users.UserJDBCTemplate;

@Controller
public class AccountController {
	
	@Autowired
	public User user;
	@Autowired
	public UserJDBCTemplate userDB;
	
	
	@GetMapping("/myAccount")
	public String myAccount() {
		return "myAccount";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		mav.addObject("UserDB", new UserJDBCTemplate());
		return mav;
	}
	//@PostMapping("/myAccount.jsp")
}
