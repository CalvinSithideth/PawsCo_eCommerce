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

	@Override
	public List<WishListItem> getWishlist(String email) {
		String sql = "Select * from wishlistmappings "
				+ "INNER JOIN products ON wishlistmappings.ProductID = products.ProductID " + "where Email='" + email + "'";
		List<WishListItem> wl = jdbcTemplateObj.query(sql, new WishlistMapper());
		return wl;
	}

	@Override
	public void setWishlistItem(String email, int productID) {
		String sql ="INSERT INTO wishlistmappings (Email, ProductId) VALUES (?, ?)";
				jdbcTemplateObj.update(sql, email, productID);

	}

	@Override
	public void deleteWishlistItem(String email, int productID) {
		String sql ="DELETE FROM wishlistmappings WHERE Email='"+email+"' AND ProductId="+ productID;
		jdbcTemplateObj.execute(sql);
	}

}
