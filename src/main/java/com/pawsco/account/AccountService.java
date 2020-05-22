package com.pawsco.account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pawsco.business.Address;
import com.pawsco.db.users.AddressJDBCTemplate;

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
//		if (addressJdbc.getAddress(email) == null) {
//			addressJdbc.addAddress(email, street, city, state, zip);
//		} else {
//			addressJdbc.updateAddress(email, street, city, state, zip);
//		}
		addressJdbc.fatigueFueledSolution(email, street, city, state, zip);
		((AnnotationConfigApplicationContext)ctx).close();
	}
}
