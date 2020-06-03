package com.supplyworld.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.supplyworld.db.OrderJdbc;

@Controller
public class OrderPageController {

	@GetMapping("orders")
	public ModelAndView orders(HttpSession session) {
		ModelAndView mav;
		Boolean loggedIn = (Boolean)session.getAttribute("loggedIn");
		
		if (loggedIn != null && loggedIn) {
			ApplicationContext ctx = new AnnotationConfigApplicationContext("com.supplyworld");
			OrderJdbc orderJdbc = ctx.getBean(OrderJdbc.class);
			
			mav = new ModelAndView("orders");
			mav.addObject("orderlist", orderJdbc.listOrders());
			
			((AnnotationConfigApplicationContext)ctx).close();
		} else {
			mav = new ModelAndView("index");
		}
		return mav;
	}
}
