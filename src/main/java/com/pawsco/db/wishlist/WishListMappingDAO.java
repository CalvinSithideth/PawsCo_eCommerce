package com.pawsco.db.wishlist;

import javax.sql.DataSource;
import com.pawsco.business.Wishlist;

public interface WishListMappingDAO {

	public void setDataSource(DataSource ds);

	public Wishlist getWishlist(String email); 
	public void setWishlist(Wishlist wishlist); 
	public Wishlist checkWishlist(String email);
	

}
