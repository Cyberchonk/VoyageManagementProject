package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.PackageController;
import com.fdmgroup.model.UserSession;

public class DashboardViewer {

	private Scanner scanner;
	private AuthenticationController authController;
	private PackageController packController;
	
	public DashboardViewer() {
		super();
	}

	public DashboardViewer(Scanner scanner, AuthenticationController authController, PackageController packController) {
		super();
		this.scanner = scanner;
		this.authController = authController;
		this.packController = packController;
	}

	public void displayDashboard() {

		System.out.println("Welcome Dear " + UserSession.getLoggedInUser().getFirstName() + " " 
		+ UserSession.getLoggedInUser().getLastName() + "!!!"); // get user name logic
		System.out.println("Please choose from the follwing options:");
		System.out.println("1) View My Package");
		System.out.println("2) View Recommeded Packages");
		System.out.println("3) Search For A Package");
		System.out.println("4) Customize Your Own Package");
		System.out.println("5) Sign Up For A Package");
		System.out.println("6) Log Out");
		System.out.println("7) Leave FDM Voyage");
		System.out.println("===========================================");
		
		String userInput = scanner.nextLine();
		
		switch (userInput) {
		case "1":
			System.out.println("Displaying your package info:");
            packController.showUserPackages();
			displayDashboard();
		case "2":
			System.out.println();
			System.out.println("Displaying all packages:");
			System.out.println();
            packController.showAllPackages();
			System.out.println("Please take note of the ID of the package that you want to sign up for");
			displayDashboard();
		case "3":
			System.out.println("What are you looking for?");
			System.out.println("Please enter a theme: Holiday, Adventure, Culture");
			String theme = scanner.nextLine();
			System.out.println("Please enter a destination:");
			String cityName = scanner.nextLine();
			
			String departureDate = "";
			while (departureDate.isEmpty()){
			System.out.println("Please enter a departure date: (Mandatory)");
			departureDate = scanner.nextLine();
			}
			
			packController.findPackages(theme, cityName, departureDate);
			System.out.println("Please take note of the ID of the package that you want to sign up for");
			displayDashboard();
			
		case "4":
			String cityName1 = "";
			while(cityName1.isEmpty()){
			System.out.println("Where do you want to go? (Mandatory Field)");
			cityName1 = scanner.nextLine();
			}
			
			System.out.println("Which hotel would you like to stay at?");
			String hotelName1 = scanner.nextLine();
			if (hotelName1.isEmpty()){
				hotelName1 = "N/A";
			}
			
			String departureDate1 = "";
			while(departureDate1.isEmpty()){
			System.out.println("When do you want to depart? (Mandatory Field)");
			departureDate1 = scanner.nextLine();
			}
			
			System.out.println("How long do you want to stay?");
			String dur1 = scanner.nextLine();
			int duration1 = 0;
			if (!dur1.isEmpty()){
				duration1 = Integer.parseInt(dur1);
			}
			
			System.out.println("What is your bedget if applicable?");
			String cost1 = scanner.nextLine();
			int budget1 = 10000;
			if (!cost1.isEmpty()){
				budget1 = Integer.parseInt(cost1);
				}
			
			System.out.println("Any other requirement?");
			String comment = scanner.nextLine();
			if (comment.isEmpty()){
				comment = "N/A";
			}
			packController.customizePackage(cityName1, hotelName1, departureDate1, duration1, budget1, comment);
			displayDashboard();
			break;
		case "5":
			System.out.println("Please Enter the Package ID: ");
			int pID = Integer.parseInt(scanner.nextLine());
			Boolean result = packController.findPackageByID(pID);
			
			if (result){
			
			System.out.println();
			System.out.println("Do you want to sign up for this package? Yy/Nn");
			System.out.println();
			
			String option = scanner.nextLine();
			
			if (option.equalsIgnoreCase("Y")){
				
				packController.pSignUp(pID);
				
				System.out.println();
				System.out.println("Registration Successful !");
				System.out.println();
				displayDashboard();
				
			} else {
				
				System.out.println();
				System.out.println("Registration cancelled, returning to main menu...");
				System.out.println();
				displayDashboard();
			}
						
			} else {
				displayDashboard();
			}
			
			
		case "6":
			System.out.println("Logging out...");
            authController.logout();	
            break;
		case "7":
			System.out.println("Leaving FDM Voyage, hope to see you soon!");
            System.exit(0);			
		default:
			System.out.println("Invalid option, please try again");
			displayDashboard();
		    
		}
		
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public AuthenticationController getAuthController() {
		return authController;
	}

	public void setAuthController(AuthenticationController authController) {
		this.authController = authController;
	}

	public PackageController getPackController() {
		return packController;
	}

	public void setPackController(PackageController packController) {
		this.packController = packController;
	}

	
}
