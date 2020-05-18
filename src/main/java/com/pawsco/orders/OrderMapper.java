package com.pawsco.orders;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pawsco.business.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setOrderID(rs.getInt("OrderID"));
		order.setEmail(rs.getString("Email"));
		order.setDate(rs.getDate("Date"));
//		order.setLineItems(new LineItemJDBCTemplate(order.getOrderID()).listLineItems());
		return order;
	}

}
