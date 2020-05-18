package com.pawsco.db.products;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pawsco.business.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductID(rs.getInt("ProductID"));
		product.setCategory(rs.getString("Category"));
		product.setName(rs.getString("Name"));
		product.setDescription(rs.getString("Description"));
		product.setPrice(rs.getDouble("Price"));
		product.setImageFileName(rs.getString("ImageFilename"));
		return product;
	}

}
