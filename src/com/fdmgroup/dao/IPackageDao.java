package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Package;
import com.fdmgroup.model.User;

public interface IPackageDao extends ISaved<Package>, IUpdatable<Package>, IDeletable<Package>{

//	public List<Package> findByTheme(String theme);
//	public List<Package> findByDestination(String cityName);
//	public List<Package> findByBudget(int budget);
//	public List<Package> findByDepartureTime(String date);
	public List<Package> findPackage(String theme, String cityName, String hotelName, String departureDate, int duration, int budget);
	public void displayPackages();
	Boolean findById(int pID);
}
