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

@Entity
@Table(name = "VOYAGE_PACKAGE")
@NamedQuery(name = "displayAllPackages", query = "SELECT p FROM Package p")
@NamedQuery(name = "displayUserPackages", query = "SELECT p FROM Package p WHERE p.packageID = :pId")
@NamedQuery(name = "findPackageByCityName", query = "SELECT p FROM Package p WHERE p.city = :city")
@NamedQuery(name = "findPackageByTheme", query = "SELECT p FROM Package p WHERE p.theme = :theme")
@NamedQuery(name = "findPackageByDepartureDate", query = "SELECT p FROM Package p WHERE p.departure_Date = :dDate")
@NamedQuery(name = "findPackageByThemeAndDepartureDate", query = "SELECT p FROM Package p WHERE p.theme = :theme AND p.departure_Date = :dDate")
@NamedQuery(name = "findPackageByCityNameAndDepartureDate", query = "SELECT p FROM Package p WHERE p.city = :city AND p.departure_Date = :dDate")
@NamedQuery(name = "findPackageByCityNameThemeAndDepartureDate", query = "SELECT p FROM Package p WHERE p.city = :city AND p.theme = :theme AND p.departure_Date = :dDate")
public class Package implements ISavable{

	@Id
	@Column (name = "PACKAGE_ID")
	private int packageID;
	private String theme;
	@Column (name = "CITY_NAME")
	private String city;
	@Column (name = "HOTEL")
	private String hotel;
	@Column (name = "DEPARTUREDATE")
	private String departure_Date;
	private int duration;
	private int price;
	
	@ManyToMany (mappedBy = "pList")
	private List<User> uList = new ArrayList<>();
	
	public List<User> getuList() {
		return uList;
	}

	public void setuList(List<User> uList) {
		this.uList = uList;
	}

	public Package(int packageID, String theme, String city, String hotel, String departure_Date, int duration,
			int price) {
		super();
		this.packageID = packageID;
		this.theme = theme;
		this.city = city;
		this.hotel = hotel;
		this.departure_Date = departure_Date;
		this.duration = duration;
		this.price = price;
	}

	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPackageID() {
		return packageID;
	}

	public void setPackageID(int packageID) {
		this.packageID = packageID;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
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

	@Override
	public String toString() {
		return "[ packageID=" + packageID + ", theme=" + theme + ", city=" + city + ", hotel=" + hotel
				+ ", departure_Date=" + departure_Date + ", duration=" + duration + ", price=" + price + "]";
	}
	
	@Override
	public boolean equals(Object object)
	{
	    boolean isEqual= false;

	    if (object != null && object instanceof Package)
	    {
	        isEqual = (this.packageID == ((Package) object).packageID);
	    }

	    return isEqual;
	}
	
	@Override
	public int hashCode() {
	    return this.packageID;
	}
	
}


