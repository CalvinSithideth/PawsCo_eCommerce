package com.pawsco.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pawsco.models.ProductModel;
import com.pawsco.models.User;
import com.pawsco.services.SupplyOrderService;

@Controller
public class AdminController {
	
	@GetMapping("admin")
	private ModelAndView checkAdmin(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		ModelAndView mav = new ModelAndView();
		
		if (request.getAttribute("orderConfirm") != null) {
			mav.addObject("orderConfirm", request.getAttribute("orderConfirm"));
		}
		
		if(user.getIsAdmin()) {
			ProductModel pm = new ProductModel();
			mav.setViewName("admin");
			session.setAttribute("products", pm.allProducts());
			session.setAttribute("supplyOrders", SupplyOrderService.listSupplyOrders());
			return mav;
		}else {
			mav.setViewName("home");
			return mav;
		}
	}
	
	@GetMapping("submitOrder")
	private ModelAndView submitResupplyOrder(@RequestParam("id") int productID, @RequestParam("quantity") int quantity) {
		RestTemplate rt = new RestTemplate();
		String url = String.format("http://localhost:8082/SupplyWorld/order/%d/%d", productID, quantity);
		ModelAndView mav = new ModelAndView(new RedirectView("admin"));
		
		
		if (quantity < 1) {
			return mav;
		}
		
		int supplyOrderID = rt.getForObject(url, Integer.class);
		
		if (supplyOrderID != -1) {
			SupplyOrderService.newOrder(supplyOrderID, productID, quantity);
		} else {
			return mav;
		}
		
		mav.addObject("orderConfirm", String.format("Supply Order #%d created successfully.", supplyOrderID));
		return mav;
	}
}
