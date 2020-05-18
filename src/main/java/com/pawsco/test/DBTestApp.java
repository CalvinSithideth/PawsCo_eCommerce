package com.pawsco.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pawsco.business.Product;
import com.pawsco.db.products.ProductJDBCTemplate;

public class DBTestApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.pawsco");
//		((AnnotationConfigApplicationContext)ctx).refresh();
		ProductJDBCTemplate prodTemplate = ctx.getBean(ProductJDBCTemplate.class);
		List<Product> asdf = prodTemplate.listProducts();
		for (Product p : asdf) {
			System.out.println(p);
		}
	}

}
