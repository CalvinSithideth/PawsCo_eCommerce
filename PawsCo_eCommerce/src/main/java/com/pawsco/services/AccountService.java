package com.pawsco.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pawsco.db.users.AddressJDBCTemplate;
import com.pawsco.models.Address;

public class AccountService {

	public static Address getAddress(String email) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.pawsco");
		AddressJDBCTemplate addressJdbc = (AddressJDBCTemplate)ctx.getBean(AddressJDBCTemplate.class);
		Address address = addressJdbc.getAddress(email);
		((AnnotationConfigApplicationContext)ctx).close();
		return address;
	}
	
	public static void updateAddress(String email, String street, String city, String state, String zip) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.pawsco");
		AddressJDBCTemplate addressJdbc = (AddressJDBCTemplate)ctx.getBean(AddressJDBCTemplate.class);
		addressJdbc.updateAddressTempSolution(email, street, city, state, zip);
		((AnnotationConfigApplicationContext)ctx).close();
	}
}
