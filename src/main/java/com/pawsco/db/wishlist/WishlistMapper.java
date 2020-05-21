package com.pawsco.db.wishlist;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.pawsco.business.Wishlist;
import com.pawsco.db.products.ProductJDBCTemplate;

public class WishlistMapper implements RowMapper<Wishlist>{

	public Wishlist mapRow(ResultSet rs, int rowNum) throws SQLException{
		Wishlist wishlistItem = new Wishlist();
		wishlistItem.
		
		
	}
}
