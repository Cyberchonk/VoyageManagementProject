package com.fdmgroup.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fdmgroup.util.CPIdGenerator;

@Entity
@Table(name = "VOYAGE_PACKAGE_CUSTOMIZED")
public class CustomizedPackage {

	@Id
	@Column (name = "PACKAGE_ID")
	private int packageID;
	@Column (name = "CITY_NAME")
	private String city;
	private String hotel;
	@Column (name = "DEPARTUREDATE")
	private String departure_Date;
	private int duration;
	private int price;
	private String comments;
	
	@ManyToMany (mappedBy = "pCList")
	private List<User> uList = new ArrayList<>();
	
	public List<User> getuList() {
		return uList;
	}

	public void setuList(List<User> uList) {
		this.uList = uList;
	}

	public CustomizedPackage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomizedPackage(String city, String hotel, String departure_Date, int duration,
			int price, String comments) {
		super();
		this.packageID = CPIdGenerator.generate();
		this.city = city;
		this.hotel = hotel;
		this.departure_Date = departure_Date;
		this.duration = duration;
		this.price = price;
		this.comments = comments;
	}

	public int getPackageID() {
		return packageID;
	}

	public void setPackageID(int packageID) {
		this.packageID = packageID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getDeparture_Date() {
		return departure_Date;
	}

	public void setDeparture_Date(String departure_Date) {
		this.departure_Date = departure_Date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "CustomizedPackage [packageID=" + packageID + ", city=" + city + ", hotel=" + hotel + ", departure_Date="
				+ departure_Date + ", duration=" + duration + ", price=" + price + ", comments=" + comments + "]";
	}
	
}
