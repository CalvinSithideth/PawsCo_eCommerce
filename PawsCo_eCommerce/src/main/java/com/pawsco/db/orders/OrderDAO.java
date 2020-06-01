
package com.pawsco.db.orders;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import com.pawsco.models.Order;

public interface OrderDAO {

	public void setDataSource(DataSource ds);
	
	public Order getOrder(int id);
	
	public List<Order> listOrders(String email);
	
	public int createOrder(String email, Date date);
}

