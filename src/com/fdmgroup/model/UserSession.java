package com.fdmgroup.model;

public class UserSession {

	private static User loggedInUser;

	public UserSession() {
		super();
	}

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(User loggedInUser) {
		UserSession.loggedInUser = loggedInUser;
	}
	
}
