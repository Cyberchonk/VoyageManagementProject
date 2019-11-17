package com.fdmgroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.Package;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.util.CPIdGenerator;

public class PackageDaoImpl implements IPackageDao {

	private static Logger log = Logger.getLogger(PackageDaoImpl.class);
	
	private StringBuilder sb = new StringBuilder();
	private ArrayList<String> params = new ArrayList<>();
	private ArrayList<Integer> paramsInt = new ArrayList<>();
	private List<Package> packageList = new ArrayList<Package>();
	
	@Override
	public List<Package> findPackage(String theme, String cityName, String hotelName, String departureDate,
			int duration, int budget) {
		
		sb.append("SELECT * FROM VOYAGE_PACKAGE WHERE 1=1");
		
		System.out.println(theme + "|" + cityName + "|" + hotelName + "|" + departureDate + "|" + duration + "|" + budget);
		
		if (!theme.isEmpty()){
			sb.append(" AND THEME = ?");
			params.add(theme);
		} 
		
		if (!cityName.isEmpty()){
			sb.append(" AND CITY_NAME = ?");
			params.add(cityName);
		} 
		
		if (!hotelName.isEmpty()){
			sb.append(" AND HOTEL = ?");
			params.add(hotelName);
		} 
		
		if (!departureDate.isEmpty()){
			sb.append(" AND DEPARTUREDATE = ?");
			params.add(departureDate);
		} 
		
		if (duration != 0){
			sb.append(" AND DURATION = ?");
			paramsInt.add(duration);
		} 
		
		if (budget != 0){
			sb.append(" AND PRICE < ?");
			paramsInt.add(budget);
		} 
		
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sb.toString());){			
			
			System.out.println("Statement prepared " + sb.toString());
			    // Set ? for the Dynamic Array    
					
			    int j = 1;	
			    int k = 0;
			    
				for (int i = 1; i <= params.size(); i++) {
				    ps.setString(i, params.get(k));
				    j++;
				    k++;
				}
				
				for (int i = 0; i < paramsInt.size(); i++) {
					ps.setInt(j, paramsInt.get(i));
				}
				
				ResultSet rs = ps.executeQuery();
				
				sb.setLength(0);
				params.clear();
				paramsInt.clear();
				
				if(!rs.next()){
					System.out.println("No available package found");
					return null;
				}else{System.out.println("Available package found");}
				
				do{
					System.out.println("Package ID: " + rs.getInt(1));
					System.out.println("Theme: " + rs.getString(2));
					System.out.println("Destination: " + rs.getString(3));
					System.out.println("Hotel: " + rs.getString(4));
					System.out.println("Departure Date: " + rs.getString(5));
					System.out.println("Duration: " + rs.getInt(6));
					System.out.println("Total Price: " + rs.getInt(7));
					System.out.println("=================================================");
				} while (rs.next());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Return package list logic
		
		return null;
	}

	@Override
	public void displayPackages() {
		
		String query = "SELECT * FROM VOYAGE_PACKAGE";
		
		try(Connection con = DataSource.getInstance().getConnection();
				Statement stmt = con.createStatement();){
			
				ResultSet rs = stmt.executeQuery(query);
				
				if(!rs.next()){
					System.out.println("No Available Package At The Moment!");
				}
				
				do{
					System.out.println("Package ID: " + rs.getInt("package_id"));
					System.out.println("Theme: " + rs.getString("theme"));
					System.out.println("Destination: " + rs.getString("city_name"));
					System.out.println("Hotel: " + rs.getString("hotel"));
					System.out.println("Departure Date: " + rs.getString("departureDate"));
					System.out.println("Duration: " + rs.getInt("duration"));
					System.out.println("Total Price: " + rs.getInt("price"));
					System.out.println("=================================================");
					
				} while (rs.next());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void createCustomizedPackage(String cityName1, String hotelName1, String departureDate1, int duration1,
			int budget1, String comment) {
		
		String query = "INSERT INTO VOYAGE_PACKAGE_CUSTOMIZED (package_id, city_name, hotel, departureDate, duration, price, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";
		String query1 = "INSERT INTO VOYAGE_ENROLLMENT (user_id, package_id) VALUES (?, ?)";
		
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				PreparedStatement ps1 = con.prepareStatement(query1);){	
			
			    int packageID = CPIdGenerator.generate();
			    System.out.println(packageID + " | " + cityName1 + " | " +  hotelName1 + " | " +  departureDate1 + " | " +  duration1 + " | " +  budget1 + " | " +  comment);
			    ps.setInt(1, packageID);
			    ps.setString(2, cityName1);
			    ps.setString(3, hotelName1);
			    ps.setString(4, departureDate1);
			    ps.setInt(5, duration1);
			    ps.setInt(6, budget1);
			    ps.setString(7, comment);
				int rowsAffected = ps.executeUpdate();
				
				ps1.setInt(1, UserSession.getLoggedInUser().getId());
				ps1.setInt(2, packageID);
				int rowsAffected1 = ps1.executeUpdate();
				
				System.out.println(rowsAffected + " rows inserted into CP table");
				System.out.println(rowsAffected1 + " rows inserted into enrollment table");
				System.out.println();
				System.out.println("Your package ID is: " + packageID);
				System.out.println("Please save this ID for future reference");
				System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayUserPackage() {

		String query = "SELECT * FROM VOYAGE_PACKAGE WHERE USER_ID = ?";
		
		try(Connection con = DataSource.getInstance().getConnection();
				Statement stmt = con.createStatement();){
			
				ResultSet rs = stmt.executeQuery(query);
				
				if(!rs.next()){
					System.out.println("No Available Package At The Moment!");
				}
				
				do{
					System.out.println("Package ID: " + rs.getInt("package_id"));
					System.out.println("Theme: " + rs.getString("theme"));
					System.out.println("Destination: " + rs.getString("city_name"));
					System.out.println("Hotel: " + rs.getString("hotel"));
					System.out.println("Departure Date: " + rs.getString("departureDate"));
					System.out.println("Duration: " + rs.getInt("duration"));
					System.out.println("Total Price: " + rs.getInt("price"));
					System.out.println("=================================================");
					
				} while (rs.next());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Package t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Package> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Package t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Package t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean findById(int pID) {
		// TODO Auto-generated method stub
		return null;
	}



}
