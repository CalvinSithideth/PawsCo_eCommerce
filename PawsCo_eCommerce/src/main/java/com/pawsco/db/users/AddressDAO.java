package com.pawsco.db.users;

import javax.sql.DataSource;

import com.pawsco.business.Address;

public interface AddressDAO {
	
	public void setDataSource(DataSource ds);

	public Address getAddress(String email);
	
	public void addAddress(String email, String street, String city, String state, String zip);
	
	public void updateAddress(String email, String street, String city, String state, String zip);
	
	public void updateAddressTempSolution(String email, String street, String city, String state, String zip);
}
