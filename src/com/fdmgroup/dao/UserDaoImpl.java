package com.fdmgroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.User;
import com.fdmgroup.util.IdGenerator;

public class UserDaoImpl implements IUserDao{

	private static Logger log = Logger.getLogger(UserDaoImpl.class);
	
	@Override
	public void create(User t) {
		String query = "INSERT INTO VOYAGE_USER(user_id, username, pwd, firstname, lastname, email) VALUES (?,?,?,?,?,?)";
		
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, t.getId()); // Different from Solo Project, didn't use generator
			ps.setString(2, t.getUserName());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getFirstName());
			ps.setString(5, t.getLastName());
			ps.setString(6, t.getEmail());
			ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}

	@Override
	public User findUserById(int id) {
		
		String query = "SELECT * FROM VOYAGE_USER WHERE USER_ID = ?";
		User foundUser = null;
		
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(query);){
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					int userId = rs.getInt("user_id");
					String username = rs.getString("username");
					String password = rs.getString("pwd");
					String firstName = rs.getString("firstname");
					String lastName = rs.getString("lastname");
					String email = rs.getString("email");
					foundUser = new User(userId, username, password, firstName, lastName, email);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return foundUser;
		
	}

	@Override
	public ArrayList findAll() {
		
		String query = "SELECT * FROM VOYAGE_USER";
		List<User> userList = new ArrayList<User>();
		User foundUser = null;
		
		try(Connection con = DataSource.getInstance().getConnection();
				Statement stmt = con.createStatement();){
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()){
					int userId = rs.getInt("user_id");
					String userName = rs.getString("username");
					String password = rs.getString("pwd");
					String firstName = rs.getString("firstname");
					String lastName = rs.getString("lastname");
					String email = rs.getString("email");
					foundUser = new User(userId, userName, password, firstName, lastName, email);
					userList.add(foundUser); // Is it okay to have duplicate user objects in the arraylist?
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (ArrayList) userList;
	}
	
	@Override
	public User findUserByUsername(String userName) {
		
		String query = "SELECT * FROM VOYAGE_USER WHERE USERNAME = ?";
		User foundUser = null;
		
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(query);){
				ps.setString(1, userName);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					int userId = rs.getInt("user_id");
					String username = rs.getString("username");
					String password = rs.getString("pwd");
					String firstName = rs.getString("firstname");
					String lastName = rs.getString("lastname");
					String email = rs.getString("email");
					foundUser = new User(userId, username, password, firstName, lastName, email);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return foundUser;
	}

	@Override
	public List<User> findByFirstname(String firstname) {
		
		String query = "SELECT * FROM VOYAGE_USER WHERE FIRSTNAME = ?";
		List<User> userList = new ArrayList<User>();
		User foundUser = null;
		
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(query);){
				ps.setString(1, firstname);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					int userId = rs.getInt("user_id");
					String userName = rs.getString("username");
					String password = rs.getString("pwd");
					String firstName = rs.getString("firstname");
					String lastName = rs.getString("lastname");
					String email = rs.getString("email");
					foundUser = new User(userId, userName, password, firstName, lastName, email);
					userList.add(foundUser); // Is it okay to have duplicate user objects in the arraylist?
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public boolean delete(User t) {

		int rowsAffected = 0;
		String query = "DELETE * FROM VOYAGE_USER WHERE USER_ID = ?";
		
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(query);){
				ps.setInt(1, t.getId());
				rowsAffected = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (rowsAffected != 0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean findById(int id) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	public boolean findUsernameDuplicate(String userName) {

		String query = "SELECT * FROM VOYAGE_USER WHERE USERNAME = ?";
		
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(query);){
				ps.setString(1, userName);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()){
					return true;
				} else {
					return false;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}


	
}
