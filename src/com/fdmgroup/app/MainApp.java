package com.fdmgroup.app;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.controller.PackageController;
import com.fdmgroup.controller.RegistrationController;
import com.fdmgroup.dao.PackageDaoImpl;
import com.fdmgroup.dao.PackageDaoJpaImpl;
import com.fdmgroup.dao.UserDaoImpl;
import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.view.DashboardViewer;
import com.fdmgroup.view.HomeViewer;
import com.fdmgroup.view.PackageViewer;

public class MainApp {

	private static Logger log = Logger.getLogger(MainApp.class);

	public static void main(String[] args) {
		
		DOMConfigurator.configure("log4j.xml");
		
		Scanner scanner = new Scanner(System.in);
		UserDaoJpaImpl userDao = new UserDaoJpaImpl();
		PackageDaoJpaImpl packDao = new PackageDaoJpaImpl();
		
		// Views
		HomeViewer hv = new HomeViewer();
		DashboardViewer dv = new DashboardViewer();
		PackageViewer pv = new PackageViewer();
		
		// Controllers
		HomeController hc = new HomeController(hv);
		AuthenticationController ac = new AuthenticationController(hv, dv, userDao);
		RegistrationController rc = new RegistrationController(userDao, hv);
		PackageController pc = new PackageController(pv);
		
		pc.setPackDao(packDao);
		dv.setPackController(pc);
		dv.setAuthController(ac);
		hv.setAuthController(ac);
		hv.setRegController(rc);
		hv.setPackController(pc);
		hv.setScanner(scanner);
		dv.setAuthController(ac);
		dv.setScanner(scanner);
		pv.setPackageDao(packDao);
		
		hc.displayHome();
		
		scanner.close();
	}

}
