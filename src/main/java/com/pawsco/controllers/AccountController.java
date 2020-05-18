package com.pawsco.controllers;

import java.sql.SQLException;

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
import com.pawsco.data.UserDB;

@Controller
public class AccountController {
	
	@Autowired
	public User user;
	@Autowired
	public UserDB userDB;
	
	
	@GetMapping("/myAccount")
	public String myAccount() {
		return "myAccount";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		mav.addObject("UserDB", new UserDB());
		return mav;
	}
	//@PostMapping("/myAccount.jsp")
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) throws SQLException {
		if(UserDB.emailExists(user.getEmail())){
			showRegister(request, response);
		}else {
			UserDB.insert(user);
		}
	 
	  return new ModelAndView("welcome", "firstname", user.getFirstName());
	  }
}
