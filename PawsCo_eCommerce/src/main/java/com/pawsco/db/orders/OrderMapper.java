
package com.pawsco.db.orders;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.pawsco.models.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setOrderID(rs.getInt("OrderID"));
		order.setEmail(rs.getString("Email"));
		order.setDate(rs.getDate("Date"));
		return order;
	}

}

