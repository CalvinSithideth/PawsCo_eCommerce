package com.supplyworld.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class OrderJdbc {

	private DataSource ds;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		this.ds = ds;
		this.jdbcTemplate = new JdbcTemplate(this.ds);
	}
	
	public int newOrder(int id, int quantity) {
		KeyHolder kh = new GeneratedKeyHolder();
		String sql = "insert into Orders (Customer, Date, ProductID, Quantity, FulfilledStatus) values ('Pawsco', ?, ?, ?, false)";
		Date date = Date.valueOf(LocalDate.now());
		
		jdbcTemplate.update(psc -> {
			PreparedStatement ps = psc.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setDate(1, date);
			ps.setInt(2, id);
			ps.setInt(3, quantity);
			return ps;
		}, kh);
		
		return kh.getKey().intValue();
	}
	
	
}
