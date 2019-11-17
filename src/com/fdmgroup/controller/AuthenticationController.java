package com.fdmgroup.controller;

import org.apache.log4j.Logger;

import com.fdmgroup.dao.UserDaoImpl;
import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.DashboardViewer;
import com.fdmgroup.view.HomeViewer;

public class AuthenticationController {

	private static Logger log = Logger.getLogger(AuthenticationController.class);
	
	private HomeViewer homeViewer;
	private DashboardViewer dashViewer;
	private UserDaoJpaImpl userDao;

	public AuthenticationController() {
		super();
	}

	public AuthenticationController(HomeViewer homeViewer, DashboardViewer dashViewer, UserDaoJpaImpl userDao) {
		super();
		this.homeViewer = homeViewer;
		this.dashViewer = dashViewer;
		this.userDao = userDao;
	}

	public void loginValidation(String userName, String password) {

		User user = userDao.findUserByUsername(userName);
		
		if (user != null && user.getPassword().equals(password)){
		
		UserSession.setLoggedInUser(user);
		
		dashViewer.displayDashboard();
		
		} else {homeViewer.displayLoginOptions(true);}
	}

	public void logout() {

		UserSession.setLoggedInUser(null);
		homeViewer.displayHomePage(true);
		
	}

	public HomeViewer getHomeViewer() {
		return homeViewer;
	}

	public void setHomeViewer(HomeViewer homeViewer) {
		this.homeViewer = homeViewer;
	}

	public DashboardViewer getDashViewer() {
		return dashViewer;
	}

	public void setDashViewer(DashboardViewer dashViewer) {
		this.dashViewer = dashViewer;
	}

	public UserDaoJpaImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoJpaImpl userDao) {
		this.userDao = userDao;
	}

	public boolean checkUsernameDuplicate(String userName) {

		return userDao.findUsernameDuplicate(userName);
		
		
	}
	
	
}
