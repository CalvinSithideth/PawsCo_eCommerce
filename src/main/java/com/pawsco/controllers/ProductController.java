package com.pawsco.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pawsco.business.Product;
import com.pawsco.db.products.ProductJDBCTemplate;

@Controller
public class ProductController
{
	@Autowired
	List<Product> productList;
	@Autowired
	Product product;
	
	@GetMapping("/products")
	public ModelAndView products(HttpServletRequest request, HttpServletResponse response) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");
		ProductJDBCTemplate productDB = context.getBean(ProductJDBCTemplate.class);
		productList = productDB.listProducts();
		
		return new ModelAndView("products", "products", productList);
	}
	
	@GetMapping("/product") // This is for a single product and ID
	public ModelAndView product(HttpServletRequest request, HttpServletResponse response) {		
		int productID = Integer.parseInt(request.getParameter("id"));
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");
		ProductJDBCTemplate productDB = context.getBean(ProductJDBCTemplate.class);
		product = productDB.getProduct(productID);
		
		return new ModelAndView("product", "product", product);
	}
}
