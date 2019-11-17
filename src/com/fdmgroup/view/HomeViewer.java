package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.PackageController;
import com.fdmgroup.controller.RegistrationController;

public class HomeViewer {
	
	private Scanner scanner;
	private AuthenticationController authController;
	private RegistrationController regController;
	private PackageController packController;

	public HomeViewer(Scanner scanner, AuthenticationController authController, RegistrationController regController,
			PackageController packController) {
		super();
		this.scanner = scanner;
		this.authController = authController;
		this.regController = regController;
		this.packController = packController;
	}

	public HomeViewer(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public HomeViewer() {
		super();
	}

	public void displayHomePage(boolean option) {

		if (option){
			
			System.out.println("You have successfully signed out");
		}
		
		System.out.println("Welcome to FDM Voyage");
		System.out.println("Please choose from one of the following options: ");
		System.out.println("1) Log In");
		System.out.println("2) Register");
		System.out.println("3) Exit");
		System.out.println("4) View All Packages");
		System.out.println("5) Search for a package");
		System.out.println("6) Customize your own package");
		System.out.println("==================================================");
		
		String userInput = scanner.nextLine();
		
		switch (userInput) {
		case "1":
			displayLoginOptions(false);
			break;
		case "2":
			displayRegisterOptions(false);
			break;
		case "3":
			System.out.println("Leaving FDM Voyage, see you soon!");
			System.exit(0);
		case "4":
			System.out.println("Displaying all packages:");
			System.out.println();
			packController.showAllPackages();
			System.out.println();
			System.out.println("Please sign in to book or customize a package");
			System.out.println();
			displayHomePage(false);
		case "5":
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
			System.out.println();
			System.out.println("Please sign in to book or customize a package");
			System.out.println();
			displayHomePage(false);
		case "6":
			System.out.println("Please sign in to customize your own package");
			System.out.println();
			displayHomePage(false);
		default:
			System.out.println("Invalid option, please try again");
			displayHomePage(false);
		    
		}
		
	}

	private void displayRegisterOptions(boolean b) {

		System.out.println("Welcome to FDM Voyage User Registration Page:");
		
		System.out.println("Please enter your username:");
		String userName = scanner.nextLine();
		while(authController.checkUsernameDuplicate(userName)){
			System.out.println("Username already exist, please try again");
			userName = scanner.nextLine();
		}
		
		System.out.println("Please enter your password: ");
		String password = scanner.nextLine();
		
		String passwordConf = null;
		
		do {                                                       
		System.out.println("Please confirm your password:");
		passwordConf = scanner.nextLine();
		} while (!password.equalsIgnoreCase(passwordConf));
		
		System.out.println("Please enter your first name:");
		String firstName = scanner.nextLine();
		
		System.out.println("Please enter your last name:");
		String lastName = scanner.nextLine();
		
		System.out.println("Please enter a valid email address:");
		String email = scanner.nextLine();
		
		regController.register(userName, password, firstName, lastName, email);
	}

	public void displayLoginOptions(boolean b) {

		if (b){
			System.out.println("Invalid Username or Password, please try again");
		}
		
		System.out.println("Please enter your username:");
		String userName = scanner.nextLine();
		
		System.out.println("Please enter your password:");
		String password = scanner.nextLine();
		
		// Add duplication validation codes here
		
		authController.loginValidation(userName, password);
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

	public RegistrationController getRegController() {
		return regController;
	}

	public void setRegController(RegistrationController regController) {
		this.regController = regController;
	}

	public PackageController getPackController() {
		return packController;
	}

	public void setPackController(PackageController packController) {
		this.packController = packController;
	}

	


}
