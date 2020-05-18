package com.pawsco.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.pawsco.business.User;

@Component
public class UserDB {
	
	public static void insert(User user) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query =
				"Insert INTO users (Email, Password, FirstName, LastName)"
				+ "VALUES(?, ?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2,  user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			
			ps.executeUpdate();
			
			//get the user ID from the last insert statement		
			Statement identityStatement = connection.createStatement();
			identityStatement.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				System.err.println(e);
		}finally {
			 	DBUtil.closeResultSet(rs);
	         	DBUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
		}
		
	}
	
	public static void update(User user) throws SQLException {
		
		 	ConnectionPool pool = ConnectionPool.getInstance();
		 	Connection connection = pool.getConnection();
		 	PreparedStatement ps = null;
		 	ResultSet rs = null;
		 	
		 	String query = "UPDATE users SET"
		 			+ "email = ?,"
		 			+ "password = ?, "
		 			+ "FirstName = ?, "
		 			+ "LastName = ? "
		 			+ "WHERE email = ?";
		 	
		 	try {
				ps = connection.prepareStatement(query);
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFirstName());
				ps.setString(4, user.getLastName());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e);
			}finally {
				DBUtil.closeResultSet(rs);
	            DBUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
			}
	}
	
	/*
	 * selectUser will get the information stored with the user's profile in the database
	 * and set it to the user object
	 */
	public static User selectUser(String email) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance();
	 	Connection connection = pool.getConnection();
	 	PreparedStatement ps = null;
	 	ResultSet rs = null;
	 	
	 	String query = "SELECT * FROM users "
	 			+ "WHERE email = ?";
	 	
	 	try {
			ps = connection.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			User user = null;
			if(rs.next()) {
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
			}
			return user;
			
		} catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
	}
	
	/*
	 * emailExists checks the MySql database to see if the email exists
	 */
	public static boolean emailExists(String email) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT email FROM users "
                + "WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
	
	/*
	 * userExists checks to see if the email and password typed in matches an email and password in the MySql
	 * database
	 */
	public static boolean userExists(String email, String password) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email, Password FROM users "
                + "WHERE Email = ? && Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs = ps.getResultSet();
            if(rs.next()) {
                // redirect or print but not both...
                System.out.println("The user is valid");
                return true;
            } else {
            	System.out.println("You are not valid");
            	return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
		
    }

}
