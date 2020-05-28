package com.pawsco.db.users;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pawsco.business.Address;

public class AddressMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address = new Address();
		address.setStreet(rs.getString("Street"));
		address.setCity(rs.getString("City"));
		address.setState(rs.getString("State"));
		address.setZip(rs.getString("Zip"));
		return address;
	}

}
