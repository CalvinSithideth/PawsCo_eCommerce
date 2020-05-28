package com.pawsco.db.wishlist;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.pawsco.business.Product;
import com.pawsco.business.User;
import com.pawsco.business.WishListItem;
import com.pawsco.db.products.ProductJDBCTemplate;

public class WishlistMapper implements RowMapper<WishListItem>{


	public WishListItem mapRow(ResultSet rs, int rowNum) throws SQLException{
		WishListItem wishlistItem = new WishListItem();
		wishlistItem.setId(rs.getInt("id"));
		wishlistItem.setProduct(new Product());
		wishlistItem.getProduct().setProductID(rs.getInt("ProductID"));
		wishlistItem.getProduct().setName(rs.getString("name"));
		wishlistItem.getProduct().setPrice(rs.getDouble("price"));
		wishlistItem.getProduct().setImageFileName(rs.getString("ImageFilename"));
		wishlistItem.setUser(new User());
		wishlistItem.getUser().setEmail(rs.getString("email"));
		return wishlistItem;
	}
}
