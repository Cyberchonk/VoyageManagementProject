package com.fdmgroup.view;

import org.apache.log4j.Logger;

import com.fdmgroup.dao.PackageDaoImpl;
import com.fdmgroup.dao.PackageDaoJpaImpl;
import com.fdmgroup.model.Package;

public class PackageViewer {
	
	private static Logger log = Logger.getLogger(PackageViewer.class);
	
	private PackageDaoJpaImpl packageDao = new PackageDaoJpaImpl(); 

	public PackageViewer() {
		super();
	}

	public PackageViewer(PackageDaoJpaImpl packageDao) {
		super();
		this.packageDao = packageDao;
	}

	public void viewAllPackages() {

		packageDao.displayPackages();

	}

	public PackageDaoJpaImpl getPackageDao() {
		return packageDao;
	}

	public void setPackageDao(PackageDaoJpaImpl packageDao) {
		this.packageDao = packageDao;
	}

	public void viewSearchedPackages(String theme, String cityName, String departureDate) {

		packageDao.findPackage(theme, cityName, departureDate);
	}

	
	
	
}
