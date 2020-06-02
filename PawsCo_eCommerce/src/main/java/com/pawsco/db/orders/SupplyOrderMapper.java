package com.pawsco.db.orders;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pawsco.models.SupplyOrder;

public class SupplyOrderMapper implements RowMapper<SupplyOrder> {

	@Override
	public SupplyOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		SupplyOrder so = new SupplyOrder();
		so.setOrderID(rs.getInt("OrderID"));
		so.setProductID(rs.getInt("ProductID"));
		so.setQuantity(rs.getInt("Quantity"));
		so.setFulfilledStatus(rs.getBoolean("FulfilledStatus"));
		return so;
	}

	
}
