package com.pawsco.db.orders;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pawsco.models.SupplyOrder;

@Component
public class SupplyOrderJDBCTemplate implements SupplyOrderDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	@Override
	public List<SupplyOrder> listSupplyOrders() {
		String sql = "SELECT * FROM SupplyOrders";
		List<SupplyOrder> supplyOrders = jdbcTemplateObj.query(sql, new SupplyOrderMapper());
		return supplyOrders;
	}

	@Override
	public void newSupplyOrder(int orderID, int productID, int quantity) {
		String sql = "INSERT INTO SupplyOrders (OrderID, ProductID, Quantity, FulfilledStatus) VALUES (?, ?, ?, false)";
		jdbcTemplateObj.update(sql, orderID, productID, quantity);
	}

	@Override
	public void fulfillOrder(int orderID) {
		String sql = "UPDATE SupplyOrders SET FulfilledStatus = true WHERE OrderID = ?";
		jdbcTemplateObj.update(sql, orderID);
	}

}
