package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;

public class JpaUtility {

	private static Logger log = Logger.getLogger(JpaUtility.class);
	
	private static JpaUtility eMF;
	private EntityManagerFactory emf;
	
	private JpaUtility() {
	
		init();
	}
	
	private void init(){
		
		emf = Persistence.createEntityManagerFactory("JPABasicExample");
	}
	
	public static JpaUtility getInstance(){
		
		if(eMF == null){
			eMF = new JpaUtility();
		}
		return eMF;
		
	}
	
	public EntityManager getEntityManger(){
		
		return emf.createEntityManager();
	}
	
	public void close(){
		
		emf.close();
	}
}
