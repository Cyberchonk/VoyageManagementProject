package com.fdmgroup.controller;

import org.apache.log4j.Logger;

import com.fdmgroup.dao.PackageDaoImpl;
import com.fdmgroup.dao.PackageDaoJpaImpl;
import com.fdmgroup.model.Package;
import com.fdmgroup.view.PackageViewer;

public class PackageController {

	private static Logger log = Logger.getLogger(PackageController.class);
	
	private PackageViewer pView;
	private PackageDaoJpaImpl packDao;

	public PackageController(PackageViewer pView) {
		super();
		this.pView = pView;
	}

	public PackageController() {
		super();
	}
	
	public PackageViewer getpView() {
		return pView;
	}

	public void setpView(PackageViewer pView) {
		this.pView = pView;
	}
	
	public PackageDaoJpaImpl getPackDao() {
		return packDao;
	}

	public void setPackDao(PackageDaoJpaImpl packDao) {
		this.packDao = packDao;
	}

	public void showAllPackages(){
		pView.viewAllPackages();
	}
	
	public void findPackages(String theme, String cityName, String departureDate){
		pView.viewSearchedPackages(theme, cityName, departureDate);
	}

	public void customizePackage(String cityName1, String hotelName1, String departureDate1, int duration1, int budget1,
			String comment) {
		
		packDao.createCustomizedPackage(cityName1, hotelName1, departureDate1, duration1, budget1, comment);
	}

	public void showUserPackages() {

		packDao.displayUserPackage();
	}

	public Boolean findPackageByID(int pID) {

		return packDao.findById(pID);
	}

	public void pSignUp(int pID) {

		packDao.pRegister(pID);
	}
}
