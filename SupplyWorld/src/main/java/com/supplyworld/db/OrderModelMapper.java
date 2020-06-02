package com.supplyworld.db;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.supplyworld.models.OrderModel;

public class OrderModelMapper implements RowMapper<OrderModel> {

	@Override
	public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderModel order = new OrderModel();
		order.setOrderID(rs.getInt("OrderID"));
		order.setCustomer(rs.getString("Customer"));
		order.setDate(rs.getDate("Date"));
		order.setProductID(rs.getInt("ProductID"));
		order.setQuantity(rs.getInt("Quantity"));
		order.setFulfilledStatus(rs.getBoolean("FulfilledStatus"));
		return order;
	}

}