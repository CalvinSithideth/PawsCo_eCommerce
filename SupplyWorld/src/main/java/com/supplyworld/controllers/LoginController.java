package com.supplyworld.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.supplyworld.db.OrderJdbc;
import com.supplyworld.services.LoginService;

@Controller
public class LoginController {
	
	@PostMapping("login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		ModelAndView mav;
		
		if (LoginService.validateLogin(username, password)) {
			mav = new ModelAndView(new RedirectView("orders"));
			session.setAttribute("loggedIn", true);
		} else {
			mav = new ModelAndView("index");
		}
		return mav;
	}
}
