package com.fdmgroup.controller;

import org.apache.log4j.Logger;

import com.fdmgroup.view.HomeViewer;

public class HomeController {

	private static Logger log = Logger.getLogger(HomeController.class);
	
	private HomeViewer homeViewer;

	public HomeController(HomeViewer homeViewer) {
		super();
		this.homeViewer = homeViewer;
	}

	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomeViewer getHomeViewer() {
		return homeViewer;
	}

	public void setHomeViewer(HomeViewer homeViewer) {
		this.homeViewer = homeViewer;
	}
	
	public void displayHome(){
		homeViewer.displayHomePage(false);
	}
}
