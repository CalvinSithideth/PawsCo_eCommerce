package com.pawsco.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.pawsco.business.User;
import com.pawsco.models.ProductModel;

@Controller
public class AdminController {
	
	@GetMapping("admin")
	private ModelAndView checkAdmin(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		ModelAndView mav = new ModelAndView();
		
		if(user.getIsAdmin()) {
			ProductModel pm = new ProductModel();
			mav.setViewName("admin");
			mav.addObject("products", pm.allProducts());
			return mav;
		}else {
			mav.setViewName("home");
			return mav;
		}
	}
	
	@GetMapping("submitOrder")
	private String submitResupplyOrder(@RequestParam("id") int id, @RequestParam("quantity") int quantity) {
		RestTemplate rt = new RestTemplate();
		String url = String.format("http://localhost:8082/SupplyWorld/order/%d/%d", id, quantity);
		
		int response = rt.getForObject(url, Integer.class);
		return "Order ID: " + response;
	}
		
		
//		 RestTemplate rt = new RestTemplate();
//	        String url = "http://localhost:8091/orderMore/"+id+"/"+quantity;
//	       
//	        ResponseEntity<Orders> response = rt.getForEntity(url, Orders.class);
//	        Orders order = response.getBody();
//	        return order;
}
