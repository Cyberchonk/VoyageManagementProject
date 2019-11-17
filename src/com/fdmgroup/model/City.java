package com.fdmgroup.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class City {

	private String name;
	private BigDecimal flightPrice;
	
	public City() {
		super();
	}

	public City(String name, BigDecimal flightPrice) {
		super();
		this.name = name;
		this.flightPrice = flightPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(BigDecimal flightPrice) {
		this.flightPrice = flightPrice;
	}
	
	

	
	
}
