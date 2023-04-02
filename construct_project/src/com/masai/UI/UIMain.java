package com.masai.UI;


import java.util.InputMismatchException;
import java.util.Scanner;

public class UIMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminOrCitizen(sc);
	}
	
	static void AdminOrCitizen(Scanner sc) {
		
		System.out.println(
				"+---------------------------+" + "\n"
			  + "| 1. Login As Administrator |" + "\n"
			  + "| 2. Login As Citizen       |" + "\n"
			  + "| 3. Exit                   |" + "\n"
			  + "+---------------------------+" );
		choice(sc);
	}
	
	static void choice(Scanner sc) {
				
		int choice = 0;
		try {
			choice = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Input type should be number");
			sc.nextLine();
			AdminOrCitizen(sc);
		}
		
		if (choice == 1) {
			System.out.println("Welcome Admin ! Please Login to your account");
			AdminLogin(sc);
			AdminOrCitizen(sc);
		}
		else if (choice == 2) {
			System.out.println("Welcome Citizen !");
			citizenLogin(sc);
			AdminOrCitizen(sc);
		}
		else if (choice == 3) {
			System.out.println("Thank you ! Visit again");
			//System.exit(0);
		}
		else {
			System.out.println("Please choose a number from below options");
			AdminOrCitizen(sc);
		}
	}
	
	static void AdminLogin(Scanner sc) {
		
		AdminUI.AdminLogin(sc);
	
	}
	
	static void citizenLogin(Scanner sc) {
		
		CitizenUI.citizenMethods(sc);
	}

}
