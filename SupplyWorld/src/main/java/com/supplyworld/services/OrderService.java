package com.supplyworld.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.supplyworld.db.OrderJdbc;

public class OrderService {

	public static int createOrder(int id, int quantity) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.supplyworld");
		OrderJdbc orderJdbc = ctx.getBean(OrderJdbc.class);
		int orderID = orderJdbc.newOrder(id, quantity);
		((AnnotationConfigApplicationContext)ctx).close();
		return orderID;
	}
}
