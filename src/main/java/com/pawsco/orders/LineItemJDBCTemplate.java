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
	private int orderID;
	
//	public LineItemJDBCTemplate(int orderID) {
//		this.orderID = orderID;
//	}
	
	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LineItem> listLineItems() {
		String sql = "SELECT * FROM OrderDetails WHERE OrderID = " + orderID;
		List<LineItem> lineItems = jdbcTemplateObj.query(sql, new LineItemMapper());
		return lineItems;
	}

}
