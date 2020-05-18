package com.pawsco.db.users;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pawsco.business.User;


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
		String sql = "SELECT * FROM Users WHERE Email = " + email;
		User user = (User) jdbcTemplateObj.queryForObject(sql, new UserMapper());
		return user;
	}

	@Override
	public List<User> listUsers() {
		String sql = "SELECT * FROM Users";
		List<User> users = jdbcTemplateObj.query(sql, new UserMapper());
		return users;
	}

}
