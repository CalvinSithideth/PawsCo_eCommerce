package com.pawsco.db.orders;

import java.util.List;

import javax.sql.DataSource;

import com.pawsco.models.SupplyOrder;

public interface SupplyOrderDAO {

public void setDataSource(DataSource ds);
	
	public List<SupplyOrder> listSupplyOrders();
	
	public void newSupplyOrder(int orderID, int productID, int quantity);
	
	public void fulfillOrder(int orderID);
}
