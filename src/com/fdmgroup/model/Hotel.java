package com.fdmgroup.model;

import java.util.ArrayList;

public class Hotel {

	private String name;
	private int starRating;
	
	public Hotel() {
		super();
	}

	public Hotel(String name, int starRating) {
		super();
		this.name = name;
		this.starRating = starRating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	
}
