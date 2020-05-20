package com.pawsco.db.wishlist;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pawsco.business.Wishlist;

public class WishlistJDBCTemplate implements WishListMappingDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	@Override
	public Wishlist getWishlist(String email) {
		String sql = "SELECT * FROM WishlistMappings WHERE email = " + email;
		Wishlist wishlist = jdbcTemplateObj.
	}

	@Override
	public void setWishlist(Wishlist wishlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Wishlist checkWishlist(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
