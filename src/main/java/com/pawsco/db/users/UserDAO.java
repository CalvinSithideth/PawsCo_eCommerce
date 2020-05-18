package com.pawsco.db.users;

import java.util.List;

import javax.sql.DataSource;

import com.pawsco.business.User;


public interface UserDAO {
	
	public void setDataSource(DataSource ds);

	public User getUser(String email);
	
	public List<User> listUsers();
}
