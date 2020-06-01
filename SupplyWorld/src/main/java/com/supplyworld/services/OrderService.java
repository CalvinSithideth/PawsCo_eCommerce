package com.supplyworld.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.supplyworld.db.OrderJdbc;
import com.supplyworld.db.ProductJdbc;

public class OrderService {

	public static int createOrder(int id, int quantity) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.supplyworld");
		OrderJdbc orderJdbc = ctx.getBean(OrderJdbc.class);
		int orderID;
		
		if (checkStock(id, quantity)) {
			orderID = orderJdbc.newOrder(id, quantity);
		} else {
			orderID = -1;
		}

		((AnnotationConfigApplicationContext)ctx).close();
		return orderID;
	}
	
	private static boolean checkStock(int productID, int quantity) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.supplyworld");
		ProductJdbc productJdbc = ctx.getBean(ProductJdbc.class);
		boolean result = productJdbc.checkStock(productID, quantity);
		((AnnotationConfigApplicationContext)ctx).close();
		return result;
	}
}
