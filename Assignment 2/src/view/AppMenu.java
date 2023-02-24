package view;

import java.util.Scanner;

public class AppMenu {
Scanner input;

public AppMenu() {
	input = new Scanner(System.in);
}

public int showMainMenu() {
	System.out.println("************************************");
	System.out.println("*      WELCOME TO TOYS R US        *");
	System.out.println("************************************");
	
	System.out.println("How May We Help You?");
	System.out.println("(1) Search Inventory and Purchase Toy");
	System.out.println("(2) Add New Toy");
	System.out.println("(3) Remove Toy");
	System.out.println("(4) Save & Exit");
	System.out.println("Enter Option");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.print("Enter Option");
	}
	int option = input.nextInt();
	

		
	// Flushing out the Scanner buffer of previous inputs
	input.nextLine();
	return option;
}

public int showSubMenu() {
	System.out.println("Find Toys With:");
	System.out.println("(1) Serial Number (SN)");
	System.out.println("(2) Toy Name");
	System.out.println("(3) Type");
	System.out.println("(4) Back to Main Menu");
	System.out.println("Enter Option");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.println("Enter Option");
	}
	int option = input.nextInt();
	return option;
}
}
