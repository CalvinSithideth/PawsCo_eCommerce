package com.pawsco.orders;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pawsco.business.LineItem;
import com.pawsco.db.products.ProductJDBCTemplate;

public class LineItemMapper implements RowMapper<LineItem> {

	@Override
	public LineItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		LineItem lineItem = new LineItem();
		lineItem.setProduct(new ProductJDBCTemplate().getProduct(rs.getInt("ProductID")));
		lineItem.setQuantity(rs.getInt("Quantity"));
		return lineItem;
	}

}
