package com.pawsco.services;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pawsco.db.orders.SupplyOrderJDBCTemplate;
import com.pawsco.models.SupplyOrder;

public class SupplyOrderService {

	private static SupplyOrderJDBCTemplate supplyOrderJdbc = new AnnotationConfigApplicationContext("com.pawsco").getBean(SupplyOrderJDBCTemplate.class);
	
	public static List<SupplyOrder> listSupplyOrders() {
		return supplyOrderJdbc.listSupplyOrders();
	}
	
	public static void newOrder(int orderID, int productID, int quantity) {
		supplyOrderJdbc.newSupplyOrder(orderID, productID, quantity);
	}
	
	public static void fulfillSupplyOrder(int orderID) {
		supplyOrderJdbc.fulfillOrder(orderID);
	}
	
}
