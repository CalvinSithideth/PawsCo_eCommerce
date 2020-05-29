package com.supplyworld.db;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginJdbc {

	private DataSource ds;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		this.ds = ds;
		this.jdbcTemplate = new JdbcTemplate(this.ds);
	}
	
	public boolean validateUser(String username, String password) {
		String sql = "select * from users where Username = ? and Password = ?";
		List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, username, password);
		if (results.size() == 1) {
			return true;
		}
		return false;
	}
}
