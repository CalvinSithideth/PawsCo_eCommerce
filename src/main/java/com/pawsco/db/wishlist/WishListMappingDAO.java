package com.pawsco.db.wishlist;

import java.util.List;

import javax.sql.DataSource;

import com.pawsco.business.WishListItem;

public interface WishListMappingDAO {

	public void setDataSource(DataSource ds);

	//methods for getting/setting/deleting product from wishlist table
	public List<WishListItem> getWishlist(String email); 
	public void setWishlistItem(String email, int productID); 
	public void deleteWishlistItem(String email, int productID); 
	/* public void addToCart(String email, int productID); */
	

}
