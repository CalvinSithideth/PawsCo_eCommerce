
package com.pawsco.db.orders;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.pawsco.models.Order;

@Component
public class OrderJDBCTemplate implements OrderDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	@Override
	public Order getOrder(int id) {
		String sql = "SELECT * FROM Orders WHERE OrderID = '" + id + "'";
		Order order = jdbcTemplateObj.queryForObject(sql, new OrderMapper());
		return order;
	}

	@Override
	public List<Order> listOrders(String email) {
		String sql = "SELECT * FROM Orders WHERE Email = '" + email + "'";
		List<Order> orders = jdbcTemplateObj.query(sql, new OrderMapper());
		return orders;
	}

	@Override
	public int createOrder(String email, Date date) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO Orders (Email, Date) VALUES (?, ?)";
		
		jdbcTemplateObj.update(con -> {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, email);
			ps.setDate(2, date);
			return ps;
		}, keyHolder);
		
		return keyHolder.getKey().intValue();
	}

}

