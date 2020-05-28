package com.pawsco.db.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pawsco.business.User;
import com.pawsco.data.ConnectionPool;
import com.pawsco.data.DBUtil;

@Component
public class UserJDBCTemplate implements UserDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}
	
	@Override
	public User getUser(String email) {
		String sql = "SELECT * FROM Users WHERE Email = '" + email+ "'";
		User user = jdbcTemplateObj.queryForObject(sql, new UserMapper());
		return user;
	}

	@Override
	public List<User> listUsers() {
		String sql = "SELECT * FROM Users";
		List<User> users = jdbcTemplateObj.query(sql, new UserMapper());
		return users;
	}

	@Override
	public void registerUser(String email, String password, String firstName, String lastName) {
		String sql = "INSERT INTO Users (Email, Password, FirstName, LastName) VALUES (?, ?, ?, ?)";
		jdbcTemplateObj.update(sql, email, password, firstName, lastName);
	}
	
	@Override
	public boolean userExists(String email) throws SQLException {

		String query = "SELECT Email, Password FROM users " + "WHERE Email = ?";
		Connection conn = dataSource.getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		
		ps = conn.prepareStatement(query);
		 ps.setString(1, email);
         rs = ps.executeQuery();
         if(rs.next()) {
             // redirect or print but not both...
             System.out.println("The user is valid");
             return true;
         } else {
         	System.out.println("You are not valid");
         	return false;
         }

	}
}

