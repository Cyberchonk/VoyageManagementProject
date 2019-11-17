package com.fdmgroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.CustomizedPackage;
import com.fdmgroup.model.Package;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;

public class PackageDaoJpaImpl implements IPackageDao{
	
	private static Logger log = Logger.getLogger(PackageDaoImpl.class);
	
	@Override
	public void create(Package p) {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	public void createCustomizedPackage(String cityName1, String hotelName1, String departureDate1, int duration1,
			int budget1, String comment){
		CustomizedPackage cP = new CustomizedPackage(cityName1, hotelName1, departureDate1, duration1, budget1, comment);
		
		EntityManager em = JpaUtility.getInstance().getEntityManger();
		User u = em.find(User.class, UserSession.getLoggedInUser().getId());
		
		em.getTransaction().begin();
		em.persist(cP);
		cP.getuList().add(u);
		u.getpCList().add(cP);
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Customized Package Registered, we will get back to you soon!");
		System.out.println();
	}
	
	@Override
	public Boolean findById(int pID) {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		Package foundPackage = em.find(Package.class, pID);  
		
		if(foundPackage != null){
		System.out.println(foundPackage);
		return true;
		
		} else {
			System.out.println("There is no package associated with this ID");
			return false;
		}
		
	}
	
	public Package findPackageById(int pID) {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		Package foundPackage = em.find(Package.class, pID);  
		
		if(foundPackage != null){
		System.out.println(foundPackage);
		return foundPackage;
		
		} else {
			System.out.println("There is no package associated with this ID");
			return null;
		}
		
	}

	@Override
	public void update(Package t) {
		
	}

	@Override
	public boolean delete(Package p) {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		em.getTransaction().begin();
		em.remove(p); // Can only remove managed entity
		em.getTransaction().commit();
		
		return true;
	}

	public List<Package> findPackage(String theme, String cityName, String departureDate) {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		List<Package> packageList = null;
		
		if (!theme.isEmpty() && !cityName.isEmpty() && !departureDate.isEmpty()){

			Query namedQuery = em.createNamedQuery("findPackageByCityNameThemeAndDepartureDate");
			namedQuery.setParameter("city", cityName);
			namedQuery.setParameter("theme", theme);
			namedQuery.setParameter("dDate", departureDate);
			packageList = namedQuery.getResultList();

			
		} else if (!theme.isEmpty() && !departureDate.isEmpty()){
			
			Query namedQuery = em.createNamedQuery("findPackageByThemeAndDepartureDate");
			namedQuery.setParameter("theme", theme);
			namedQuery.setParameter("dDate", departureDate);
			packageList = namedQuery.getResultList();

			
		} else if (!cityName.isEmpty() && !departureDate.isEmpty()){
			
			Query namedQuery = em.createNamedQuery("findPackageByCityNameAndDepartureDate");
			namedQuery.setParameter("city", cityName);
			namedQuery.setParameter("dDate", departureDate);
			packageList = namedQuery.getResultList();

			
		} else {
			
			Query namedQuery = em.createNamedQuery("findPackageByDepartureDate");
			namedQuery.setParameter("dDate", departureDate);
			packageList = namedQuery.getResultList();

		}
		
		if (packageList.isEmpty()){
			System.out.println("No available package found");
		}else{
			System.out.println(packageList);
		}
		
		em.close();
		return packageList;

	}

	@Override
	public void displayPackages() {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		Query namedQuery = em.createNamedQuery("displayAllPackages");
		List<Package> packageList = namedQuery.getResultList();
		
		for(Package p : packageList){
			
			System.out.println(p);
			System.out.println();
		}
		
		em.close();
		
	}

	@Override
	public List<Package> findPackage(String theme, String cityName, String hotelName, String departureDate,
			int duration, int budget) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Package> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void displayUserPackage() {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		User u = em.find(User.class, UserSession.getLoggedInUser().getId());
		List<CustomizedPackage> cPList = u.getpCList();
		List<Package> pList = u.getpList();
		
		if (pList.isEmpty() && cPList.isEmpty()){
			System.out.println("You have not signed up for any package !");
		}
		
		if (!pList.isEmpty()){
			for (Package package1 : pList) {
				System.out.println();
				System.out.println(package1);
				System.out.println();
			}
		}
		
		if (!cPList.isEmpty()){
			for (CustomizedPackage package2 : cPList) {
				System.out.println(package2);
				System.out.println();
			}
		} 
		
	}

	public void pRegister(int pID) {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		Package pack = em.find(Package.class, pID);
		User u = em.find(User.class, UserSession.getLoggedInUser().getId());
		
		em.getTransaction().begin();
		u.getpList().add(pack);
		pack.getuList().add(u);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void pCancel(int pID) {

		EntityManager em = JpaUtility.getInstance().getEntityManger();
		Package pack = em.find(Package.class, pID);
		User u = em.find(User.class, UserSession.getLoggedInUser().getId());
		
		em.getTransaction().begin();
		u.getpList().remove(pack);
		pack.getuList().remove(u);
		em.getTransaction().commit();
		
		em.close();
	}
	
}
