package com.pawsco.db.wishlist;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pawsco.business.WishListItem;

@Component
public class WishListItemJDBCTemplate implements WishListMappingDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;

	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	//getting product info from wishlist table
	@Override
	public List<WishListItem> getWishlist(String email) {
		String sql = "Select * from wishlistmappings "
				+ "INNER JOIN products ON wishlistmappings.ProductID = products.ProductID " + "where Email='" + email + "'";
		List<WishListItem> wl = jdbcTemplateObj.query(sql, new WishlistMapper());
		return wl;
	}

	//adding product to wishlist
	@Override
	public void setWishlistItem(String email, int productID) {
		String sql ="INSERT INTO wishlistmappings (Email, ProductId) VALUES (?, ?)";
				jdbcTemplateObj.update(sql, email, productID);

	}

	//deleting product from wishlist
	@Override
	public void deleteWishlistItem(String email, int productID) {
		String sql ="DELETE FROM wishlistmappings WHERE Email='"+email+"' AND ProductId="+ productID;
		jdbcTemplateObj.execute(sql);
	}
	
	/*
	 * @Override public void addToCart(String email, int productID) { String sql
	 * ="DELETE FROM wishlistmappings WHERE Email='"+email+"' AND ProductId="+
	 * productID; jdbcTemplateObj.execute(sql); }
	 */

}
