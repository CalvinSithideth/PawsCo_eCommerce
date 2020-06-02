package com.supplyworld.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.supplyworld.db.OrderJdbc;

@Controller
public class FulfillmentController {
	
	@RequestMapping("/Fulfill/{order}/{id}/{add}")
	public ModelAndView sendStock(@PathVariable("order") int orderID, @PathVariable("id") int productId, @PathVariable("add") int amtStock) {
		RestTemplate rest = new RestTemplate();
		// URL should be for the PawsCo Receive controller.
		String url = "http://localhost:8082/PawsCo_eCommerce/Receive/"
				+ productId + "/" + amtStock;
		boolean success = Boolean.parseBoolean(rest.getForObject(url, String.class));
		
		if(success) {
			ApplicationContext ctx = new AnnotationConfigApplicationContext("com.supplyworld");
			OrderJdbc orderJdbc = ctx.getBean(OrderJdbc.class);
			orderJdbc.markOrderFulfilled(orderID);
		}
		
		return new ModelAndView("fulfillConfirmation"); // return fulfillConfirmation.jsp
//		return new ModelAndView("fulfillConfirmation", "isFulfilled", success);
	}
	
//	@RequestMapping("/Fulfill/{id}/{add}")
//	public String sendStock(@PathVariable("id") int productId, @PathVariable("add") int amtStock
//				,HttpServletRequest req, Model m) {
//		RestTemplate rest = new RestTemplate();
//		// URL should be for the PawsCo Receive controller.
//		String url = "http://localhost:8080/PawsCo_eCommerce/Receive/"
//				+ productId + "/" + amtStock;
//		boolean success = Boolean.parseBoolean(rest.getForObject(url, String.class));
//		m.addAttribute("isFulfilled", success);
//		return "fulfillConfirmation";
//	}
}
