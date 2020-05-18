package com.pawsco.orders;

import java.util.List;

import javax.sql.DataSource;

import com.pawsco.business.Order;

public interface OrderDAO {

	public void setDataSource(DataSource ds);
	
	public Order getOrder(int id);
	
	public List<Order> listOrders(String email);
}
