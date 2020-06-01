package com.pawsco.models;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pawsco.db.products.ProductJDBCTemplate;

public class ProductModel {

	private List<Product> products;
	
	public ProductModel() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.pawsco");
		ProductJDBCTemplate prodJDBC = ctx.getBean(ProductJDBCTemplate.class);
		this.products = prodJDBC.listProducts();
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
	public List<Product> allProducts() {
		return this.products;
	}
	
	public Product findProduct(int productID) {
		for (Product p : this.products) {
			if (p.getProductID() == productID) {
				return p;
			}
		}
		return null;
	}
}
