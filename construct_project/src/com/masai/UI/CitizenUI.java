package com.masai.UI;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.DAO.CrimeDAO;
import com.masai.DAO.CrimeDAOImpl;
import com.masai.DTO.CrimeDTO;
import com.masai.DTO.CrimeStationDTO;

public class CitizenUI {
	static void citizenMethods(Scanner sc) {
		System.out.println(
				   "+---------------------------------------------------------------------------------------+" + "\n"
				 + "| Welcome Citizen ! Choose Any option from below                                        |" + "\n"
				 + "| 1. View Total Crime for Each Police Station By Date Range                             |" + "\n"
				 + "| 2. View Total Crime for Each Crime Type By Date Range                                 |" + "\n"
				 + "| 3. Search Criminal By Name                                                            |" + "\n"
				 + "| 4. Search Criminal By Description                                                     |" + "\n"
				 + "| 5. Assign Request                                                                     |" + "\n"
				 + "| 6. Logout & Exit                                                                      |" + "\n"
				 + "+---------------------------------------------------------------------------------------+" );

int choice = 0;
try {
	choice = sc.nextInt();
	if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5
			&& choice != 6 ) {
		System.out.println("Please choose a number from below options");
		sc.nextLine();
		citizenMethods(sc);
	}
	else citizenChoice(choice,sc);
}
catch (InputMismatchException e) {
	
	System.out.println("Input type should be number");
	sc.nextLine();
	citizenMethods(sc);
}
	}
	//==================== OPTIONS AVAILABLE TO CITIZENS ============================
	static void citizenChoice(int choice, Scanner sc) {
		switch(choice) {
		case 1 : {
			viewCrimeByStation(sc);
			citizenMethods(sc);
		}
		break;
		case 2 : {
			viewCrimeByDesc(sc);
		}
		break;
		case 3 : {
			searchByName(sc);
		}
		break;
		case 4 : {
			searchByDesc(sc);
		}
		break;	
		case 5 : {
			//================= PENDING HERE EXTRA METHOD ==================
		}
		break;				
		case 6 : {
			System.out.println("Thank you ! Visit again");
			//System.exit(0);
		}
	}
	}
	
	//========= TOTAL CRIME FOR EACH POLICE STATION AREA FOR DATE RANGE  =================
	static void viewCrimeByStation(Scanner sc) {
//		sc.nextLine();
//		System.out.println("Enter a Police Station Name: ");
//		String ps_name = sc.nextLine();
		
		System.out.println("Enter a Start Date: ");
		LocalDate sd = LocalDate.parse(sc.next());
		
		System.out.println("Enter a Last Date: ");
		LocalDate ed = LocalDate.parse(sc.next());
		
		CrimeDAO cdo = new CrimeDAOImpl();
		
		ArrayList<CrimeStationDTO> list = new ArrayList<>();
		try {
			list = cdo.viewCrByDRange(sd, ed);
			System.out.println("============================================================");
			System.out.println();
			list.stream().forEach(a ->{
				System.out.println("Police Station Name: "+a.getP_station()+" ="+a.getCount());
			});
			System.out.println();
			System.out.println("=============================================================");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
		
	}
	
	// ======== TOTAL CRIME FOR EACH CRIME TYPE FOR DATE RANGE ============================
	static void viewCrimeByDesc(Scanner sc) {
		
	}
	
	//============ SEARCH FOR CRIMINAL BY NAME ============================================
	static void searchByName(Scanner sc) {
		
	}
	
	//=============== SEARCH FOR CRIMINAL FOR DESCRIPTION =================================
	static void searchByDesc(Scanner sc) {
		
	}
}
