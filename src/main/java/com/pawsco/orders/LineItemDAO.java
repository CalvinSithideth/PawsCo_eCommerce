package com.pawsco.orders;

import java.util.List;

import javax.sql.DataSource;

import com.pawsco.business.LineItem;

public interface LineItemDAO {

	public void setDataSource(DataSource ds);
	
	public List<LineItem> listLineItems();
}
