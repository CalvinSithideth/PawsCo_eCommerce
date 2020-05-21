package com.pawsco.checkout;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pawsco.business.LineItem;
import com.pawsco.business.User;
import com.pawsco.db.orders.LineItemJDBCTemplate;
import com.pawsco.db.orders.OrderJDBCTemplate;

public class CheckoutService {
	
	public static int saveOrder(User user, List<LineItem> cart) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.pawsco");
		OrderJDBCTemplate orderJdbc = ctx.getBean(OrderJDBCTemplate.class);
		LineItemJDBCTemplate itemJdbc = ctx.getBean(LineItemJDBCTemplate.class);
		
		Date date = Date.valueOf(LocalDate.now());
		int orderID = orderJdbc.createOrder(user.getEmail(), date);
		for (LineItem item : cart) {
			itemJdbc.createLineItem(orderID, item.getProduct().getProductID(), item.getQuantity());
		}
		
		((AnnotationConfigApplicationContext)ctx).close();
		return orderID;
	}
}
