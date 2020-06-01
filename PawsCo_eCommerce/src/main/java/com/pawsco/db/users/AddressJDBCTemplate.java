package com.pawsco.db.users;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pawsco.models.Address;

@Component
public class AddressJDBCTemplate implements AddressDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	@Override
	public Address getAddress(String email) {
		String sql = "SELECT * FROM Addresses WHERE Email = '" + email + "'";
		if (jdbcTemplateObj.queryForList(sql).size() > 0) {
			Address address = jdbcTemplateObj.queryForObject(sql, new AddressMapper());
			return address;
		} else {
			return null;
		}
	}
	
	@Override
	public void addAddress(String email, String street, String city, String state, String zip) {
		String sql = "INSERT INTO Addresses (Email, Street, City, State, Zip) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplateObj.update(sql, email, street, city, state, zip);
	}

	@Override
	public void updateAddress(String email, String street, String city, String state, String zip) {
		String sql = "UPDATE Addresses SET Street = ?, City = ?, State = ?, Zip = ? WHERE Email = ?";
		jdbcTemplateObj.update(sql, email, street, city, state, zip);
	}
	
	/*
	 * This method was made as a workaround to an issue with the way updateAddress works.
	 * Ideally the problem with the 2 methods above will be corrected and this method 
	 * will be deleted.
	 */
	@Override
	public void updateAddressTempSolution(String email, String street, String city, String state, String zip) {
		String sql = "DELETE FROM Addresses WHERE Email = '" + email + "'";
		jdbcTemplateObj.update(sql);
		sql = "INSERT INTO Addresses (Email, Street, City, State, Zip) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplateObj.update(sql, email, street, city, state, zip);
	}

}
