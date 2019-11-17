package com.fdmgroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.Package;
import com.fdmgroup.model.User;

public class UserDaoJpaImpl implements IUserDao{

	private static Logger log = Logger.getLogger(UserDaoJpaImpl.class);
	
	@Override
	public void create(User t) {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public User findUserById(int id) {
		
		EntityManager em = JpaUtility.getInstance().getEntityManger();
		User foundUser = em.find(User.class, id);
		System.out.println(foundUser);
		
		if (foundUser != null){
		    return foundUser;
		} else {
			System.out.println("No user found");
			return null;
		}
			
	}

	@Override
	public ArrayList findAll() {
		
		EntityManager em = JpaUtility.getInstance().getEntityManger();
		Query namedQuery = em.createNamedQuery("displayAllUsers");
		ArrayList<User> userList = (ArrayList<User>) namedQuery.getResultList();
		
		return userList;
		
	}
	
	@Override
	public User findUserByUsername (String userName) {
			
		EntityManager em = JpaUtility.getInstance().getEntityManger();
		Query namedQuery = em.createNamedQuery("findUserByUserName");
		namedQuery.setParameter(1, userName);
		User foundUser = null;
		try{
		foundUser = (User) namedQuery.getSingleResult();
		} catch(NoResultException nre){}	
		
		if (foundUser != null){
		    return foundUser;
		} else {
			return null;
		}
	}

	@Override
	public List<User> findByFirstname(String firstname) {
		
		EntityManager em = JpaUtility.getInstance().getEntityManger();
		Query namedQuery = em.createNamedQuery("findUserByFirstName");
		namedQuery.setParameter(1, firstname);
		List<User> userList = namedQuery.getResultList();
		
		if (userList != null){
		    return userList;
		} else {
			System.out.println("No user found");
			return null;
		}
		
	}

	@Override
	public boolean delete(User u) {
		
		EntityManager em = JpaUtility.getInstance().getEntityManger();
		em.getTransaction().begin();
		em.remove(u); 
		em.getTransaction().commit();
		
		return true;
	}

	@Override
	public Boolean findById(int id) {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		User foundUser = em.find(User.class, id);  
		
		if(foundUser != null){
		System.out.println(foundUser);
		return true;
		
		} else {
			System.out.println("There is no user associated with this ID");
			return false;
		}
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	public boolean findUsernameDuplicate(String userName) {
		
		EntityManager em = JpaUtility.getInstance().getEntityManger();
		Query namedQuery = em.createNamedQuery("findUserByUserName");
		namedQuery.setParameter(1, userName);
		List<User> foundUser = (List<User>) namedQuery.getResultList();
		
		if (foundUser.size() != 0){
		    return true;
		} else {
			return false;
		}
	}
	
}
