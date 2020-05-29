package com.pawsco.db.products;

import java.util.List;

import javax.sql.DataSource;

import com.pawsco.business.Product;

public interface ProductDAO {

	public void setDataSource(DataSource ds);
	
	public Product getProduct(int id);
	
	public List<Product> listProducts();
	
	public boolean addProductStock(int id, int amtStockToAdd);
}
