
package com.pawsco.db.orders;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pawsco.db.products.ProductJDBCTemplate;
import com.pawsco.models.LineItem;
import com.pawsco.models.Product;

public class LineItemMapper implements RowMapper<LineItem> {

	@Override
	public LineItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		LineItem lineItem = new LineItem();
		lineItem.setProduct(new Product());
		lineItem.getProduct().setProductID(rs.getInt("ProductID"));
		lineItem.setQuantity(rs.getInt("Quantity"));
		return lineItem;
	}

}

