package com.pawsco.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pawsco.db.orders.LineItemJDBCTemplate;
import com.pawsco.db.orders.OrderJDBCTemplate;
import com.pawsco.models.LineItem;
import com.pawsco.models.Product;
import com.pawsco.models.ProductModel;
import com.pawsco.models.User;

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
	
	public static boolean checkStocks(List<LineItem> cart) {
		ProductModel pm = new ProductModel();
		List<Product> currentInventory = pm.allProducts();
		
		// This is a little ugly, but it only queries the database once
		for (LineItem item : cart) {
			for (Product p : currentInventory) {
				if (item.getProduct().getProductID() == p.getProductID()) {
					if (item.getQuantity() > p.getStock()) {
						return false;
					}
					break;
				}
			}
		}
		
		return true;
	}
}
