package com.pawsco.orders;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pawsco.business.Order;

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
		String sql = "SELECT * FROM Orders WHERE OrderID = " + id;
		Order order = jdbcTemplateObj.queryForObject(sql, new OrderMapper());
		return order;
	}

	@Override
	public List<Order> listOrders(String email) {
		String sql = "SELECT * FROM Orders WHERE Email = " + email;
		List<Order> orders = jdbcTemplateObj.query(sql, new OrderMapper());
		return orders;
	}

}
