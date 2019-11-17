package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.User;

public interface IUserDao extends ISaved<User>, IUpdatable<User>, IDeletable<User>{

	// Insert get and update methods separate into three interfaces
	
	public List<User> findByFirstname(String firstname);
	public User findUserByUsername(String userName);
	public User findUserById(int id);
	
	
}
