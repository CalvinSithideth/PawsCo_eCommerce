package com.supplyworld.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.supplyworld.db.LoginJdbc;

public class LoginService {

	private static ApplicationContext ctx = new AnnotationConfigApplicationContext("com.supplyworld");
	private static LoginJdbc loginJdbc = (LoginJdbc)ctx.getBean(LoginJdbc.class);
	
	public static boolean validateLogin(String username, String password) {
		return loginJdbc.validateUser(username, password);
	}
	
}
