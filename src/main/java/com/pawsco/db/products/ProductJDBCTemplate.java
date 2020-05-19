
package com.pawsco.db.products;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pawsco.business.Product;

@Component
public class ProductJDBCTemplate implements ProductDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	@Override
	public Product getProduct(int id) {
		String sql = "SELECT * FROM AllProducts WHERE ProductID = " + id;
		Product product = jdbcTemplateObj.queryForObject(sql, new ProductMapper());
		return product;
	}

	@Override
	public List<Product> listProducts() {
		String sql = "SELECT * FROM AllProducts";
		List<Product> products = jdbcTemplateObj.query(sql, new ProductMapper());
		return products;
	}

}

