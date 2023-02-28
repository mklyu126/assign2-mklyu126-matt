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
public int promptSerialNum() {
	System.out.println("Enter a serial number here: ");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.print("Enter a serial number here: ");
	}
	int serialNum = input.nextInt();
	return serialNum;
}

public String promptToyName() {
	System.out.println("Enter a toy name here: ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter a toy name here: ");
	}
	String toyName = input.nextLine().trim();
	return toyName;
}
public String promptToyBrand() {
	System.out.println("Enter the toy brand here: ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter the toy brand here: ");
	}
	String toyBrand = input.nextLine().trim();
	return toyBrand;
}

public String promptToyType() {
	System.out.println("Enter a toy type here: ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter a toy type here: ");
	}
	String toyType = input.nextLine().trim();
	return toyType;
}

public int promptToyPrice() {
	System.out.println("Enter the toy price here: ");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.print("Enter a toy price here: ");
	}
	int toyPrice = input.nextInt();
	return toyPrice;
}
public int promptNumAvailable() {
	System.out.println("Enter the available count here: ");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.print("Enter the available count here: ");
	}
	int numAvailable = input.nextInt();
	return numAvailable;
}
public int promptAppropriateAge() {
	System.out.println("Enter the appropriate age here: ");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.print("Enter the appropriate here: ");
	}
	int appropriateAge = input.nextInt();
	return appropriateAge;
}
public int promptMinNumPlayers() {
	System.out.println("Enter the minimum number of players here");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.print("Enter the minimum number of players here: ");
	}
	int minNumPlayers = input.nextInt();
	return minNumPlayers;
}
public int promptMaxNumPlayers() {
	System.out.println("Enter the maximum number of players here");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.print("Enter the maximum number of players here: ");
	}
	int maxNumPlayers = input.nextInt();
	return maxNumPlayers;
}
public String promptDesignerNames() {
	System.out.println("Enter designer names here, use '.' to seperate names if there is more than one: ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter designer names here, use '.' to seperate names if there is more than one: ");
	}
	String designerNames = input.nextLine().trim();
	return designerNames;
}
}

