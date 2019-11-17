package com.fdmgroup.view;

import java.util.ArrayList;
import java.util.List;

public class PackageListViewer {

	HomeViewer hv = new HomeViewer();
	DashboardViewer dv = new DashboardViewer();
	
	public void viewFoundPackages(List<Package> pList){
		
		for (Package package1 : pList) {
			
			System.out.println();
			System.out.println(package1);
			System.out.println();
			
		}
	}
	
}
