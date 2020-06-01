package com.pawsco.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.pawsco.db.orders.LineItemJDBCTemplate;
import com.pawsco.db.orders.OrderJDBCTemplate;
import com.pawsco.db.products.ProductJDBCTemplate;
import com.pawsco.models.LineItem;
import com.pawsco.models.Order;
import com.pawsco.models.User;

@Controller
public class OrderHistoryController {

	@GetMapping("orderHistory")
	public ModelAndView getOrders(@SessionAttribute("user") User user) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");
		ProductJDBCTemplate prodTemplate = context.getBean(ProductJDBCTemplate.class);
		OrderJDBCTemplate orderTemplate = context.getBean(OrderJDBCTemplate.class);
		LineItemJDBCTemplate lineItemTemplate = context.getBean(LineItemJDBCTemplate.class);
		
		ModelAndView mav = new ModelAndView();
		
		List<Order> orders = orderTemplate.listOrders(user.getEmail());
		
		for (Order order : orders) {
			order.setLineItems(lineItemTemplate.listLineItems(order.getOrderID()));
			for (LineItem lineItem : order.getLineItems()) {
				lineItem.setProduct(prodTemplate.getProduct(lineItem.getProduct().getProductID()));
			}
			System.out.println(order);
		}
		mav.addObject("order", orders);
		mav.setViewName("orderHistory");
		((AnnotationConfigApplicationContext) context).close();
		
		return mav;
	}
}
