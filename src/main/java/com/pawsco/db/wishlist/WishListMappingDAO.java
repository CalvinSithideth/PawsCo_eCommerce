package com.pawsco.db.wishlist;

import java.util.List;

import javax.sql.DataSource;

import com.pawsco.business.WishListItem;

public interface WishListMappingDAO {

	public void setDataSource(DataSource ds);

	public List<WishListItem> getWishlist(String email); 
	public void setWishlist(String email, int productID); 
	public WishListItem checkWishlist(String email);
	

}
