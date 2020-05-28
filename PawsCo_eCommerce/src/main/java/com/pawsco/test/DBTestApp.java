
package com.pawsco.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pawsco.business.LineItem;
import com.pawsco.business.Order;
import com.pawsco.business.Product;
import com.pawsco.db.orders.LineItemJDBCTemplate;
import com.pawsco.db.orders.OrderJDBCTemplate;
import com.pawsco.db.products.ProductJDBCTemplate;

public class DBTestApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.pawsco");
		
		// Displaying all products
		ProductJDBCTemplate prodTemplate = ctx.getBean(ProductJDBCTemplate.class);
		List<Product> products = prodTemplate.listProducts();
		for (Product p : products) {
			System.out.println(p);
		}
		
		// Loading and displaying comprehensive order information. I am ashamed of this code.
		OrderJDBCTemplate orderTemplate = ctx.getBean(OrderJDBCTemplate.class);
		LineItemJDBCTemplate lineItemTemplate = ctx.getBean(LineItemJDBCTemplate.class);
		List<Order> orders = orderTemplate.listOrders("a@a.com");
		for (Order order : orders) {
			order.setLineItems(lineItemTemplate.listLineItems(order.getOrderID()));
			for (LineItem lineItem : order.getLineItems()) {
				lineItem.setProduct(prodTemplate.getProduct(lineItem.getProduct().getProductID()));
			}
			System.out.println(order);
		}
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}

