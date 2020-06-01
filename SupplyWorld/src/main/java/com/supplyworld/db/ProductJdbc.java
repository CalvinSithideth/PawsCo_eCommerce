package com.supplyworld.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductJdbc {

	private DataSource ds;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		this.ds = ds;
		this.jdbcTemplate = new JdbcTemplate(this.ds);
	}
	
	public boolean checkStock(int productID, int quantity) {
		String sql = "select Stock from Products where ProductID = " + productID;
		int stock = jdbcTemplate.queryForObject(sql, Integer.class);
		return stock >= quantity;
	}
}
