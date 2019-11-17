package com.fdmgroup.controller;

import org.apache.log4j.Logger;

import com.fdmgroup.dao.UserDaoImpl;
import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.model.User;
import com.fdmgroup.view.HomeViewer;

public class RegistrationController {

	private static Logger log = Logger.getLogger(RegistrationController.class);
	
	private UserDaoJpaImpl userDao = new UserDaoJpaImpl();
	private HomeViewer homeViewer = new HomeViewer();
	
	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistrationController(UserDaoJpaImpl userDao, HomeViewer homeViewer) {
		super();
		this.userDao = userDao;
		this.homeViewer = homeViewer;
	}

	public void register(String userName, String password, String firstName, String lastName, String email) {

		userDao.create(new User(userName, password, firstName, lastName, email));
		
		homeViewer.displayHomePage(false);
	}

	public UserDaoJpaImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoJpaImpl userDao) {
		this.userDao = userDao;
	}

	public HomeViewer getHomeViewer() {
		return homeViewer;
	}

	public void setHomeViewer(HomeViewer homeViewer) {
		this.homeViewer = homeViewer;
	}
	
	

}
