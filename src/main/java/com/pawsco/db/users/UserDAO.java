
package com.pawsco.db.users;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.pawsco.business.User;

public interface UserDAO {
	
	public void setDataSource(DataSource ds);

	public User getUser(String email);
	
	public List<User> listUsers();
	
	public void registerUser(String email, String password, String firstName, String lastName);
	
	public boolean userExists(String email) throws SQLException;
}

