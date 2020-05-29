package com.pawsco.controllers;

import javax.servlet.http.HttpServlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawsco.db.products.ProductJDBCTemplate;

/* This Controller is a service for fulfilling
 * PawsCo stock orders.
 * SupplyWorld may increase stock of products
 * in the PawsCo DB.
 */
@RestController
public class ReceiveController extends HttpServlet {
	@RequestMapping("/Receive/{id}/{add}")
	public boolean IncreaseStock(@PathVariable("id") int productId, @PathVariable("add") int amtStock) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");
		ProductJDBCTemplate productDB = context.getBean(ProductJDBCTemplate.class);
		return productDB.addProductStock(productId, amtStock);
	}
}
