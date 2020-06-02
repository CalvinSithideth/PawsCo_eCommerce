package com.supplyworld.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.supplyworld.db.OrderJdbc;
import com.supplyworld.services.LoginService;

@Controller
public class LoginController {
	
	@PostMapping("login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();
		if (LoginService.validateLogin(username, password)) {
			mav.setViewName("orders");
			ApplicationContext ctx = new AnnotationConfigApplicationContext("com.supplyworld");
			OrderJdbc orderJdbc = ctx.getBean(OrderJdbc.class);
			mav.addObject("orderlist", orderJdbc.listOrders());
		} else {
			mav.setViewName("index");
		}
		return mav;
	}
}
