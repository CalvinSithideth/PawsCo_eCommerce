package com.pawsco.orders;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pawsco.business.LineItem;

@Component
public class LineItemJDBCTemplate implements LineItemDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LineItem> listLineItems(int orderID) {
		String sql = "SELECT * FROM OrderDetails WHERE OrderID = " + 1;
		List<LineItem> lineItems = jdbcTemplateObj.query(sql, new LineItemMapper());
		return lineItems;
	}

	@Override
	public void createLineItem(int orderID, int productID, int quantity) {
		String sql = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity) VALUES (?, ?, ?)";
		jdbcTemplateObj.update(sql, orderID, productID, quantity);
	}

}
