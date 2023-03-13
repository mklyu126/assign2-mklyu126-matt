package view;

import java.util.Scanner;

import exceptions.NegativeInputPrice;
/**
 * Starts user input 
 * @author Max
 *
 */
public class AppMenu {
Scanner input;


public AppMenu() {
	input = new Scanner(System.in);
}
/**
 * Prints main menu to user and prompts them for their choice.
 * Validates input to ensure a valid integer is given.
 * 
 * @return the user's choice in Int form.
 */
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
/**
 * Prints out sub menu to user, prompts them for their choice.
 * Validates user input.
 * @return user's choice in Int form.
 */
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
 /**
  * Prompts user for serial number of toy.
  * Validates input.
  * @return user's toy's serial number.
  */
public long promptSerialNum() {
	System.out.println("Enter a serial number here: ");
	while(!input.hasNextLong()) {
		input.nextLine();
		System.out.print("Enter a serial number here: ");
	}
	long serialNum = input.nextLong();
	
	input.nextLine();
	
	return serialNum;
}
/**
 * Prompts user for brand of toy.
 * Validates input.
 * @return user's toy's brand.
 */
public String promptToyBrand() {
	System.out.println("Enter the toy brand here: ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter the toy brand here: ");
	}
	
	input.nextLine();
	
	String toyBrand = input.nextLine().trim();
	
	
	return toyBrand;
}
/**
 * Prompts user for name of their toy.
 * Validates input.
 * @return user's toy's name.
 */
public String promptToyName() {
	System.out.println("Enter a toy name here: ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter a toy name here: ");
	}
	input.nextLine();
	
	String toyName = input.nextLine().trim();
	
	
	return toyName;
}
/**
 * Prompts user for type of their toy.
 * Validates input.
 * @return user's toy's type.
 */
public String promptToyType() {
	System.out.println("Enter a toy type here: ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter a toy type here: ");
	}
	input.nextLine();
	String toyType = input.nextLine().trim();
	return toyType;
}
/**
 * Prompts user for price of their toy.
 * Validates input.
 * @return user's toy's price.
 */
public double promptToyPrice() throws NegativeInputPrice {
	System.out.println("Enter the toy price here: ");
	while(!input.hasNextDouble()) {
		input.nextLine();
		System.out.print("Enter a toy price here: ");
	}
	double toyPrice = input.nextDouble();
	if (toyPrice < 0)
		throw new NegativeInputPrice();
	return toyPrice;
}
/**
 * Prompts user for the number of available units of their toy.
 * Validates input.
 * @return user's toy's available units.
 */
public int promptNumAvailable() {
	System.out.println("Enter the available count here: ");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.print("Enter the available count here: ");
	}
	int numAvailable = input.nextInt();
	return numAvailable;
}
/**
 * Prompts user for the appropriate age range of their toy.
 * Validates input.
 * @return user's toy's appropriate age range.
 */
public String promptMinimumAge() {
	System.out.println("Enter the minimum age here : ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter the minimum age here: ");
	}
	String minimumAge = input.nextLine();
	return minimumAge;
}

public String promptMaximumAge() {
	System.out.println("Enter the maximum age here : ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter the maximum age here: ");
	}
	String maximumAge = input.nextLine();
	return maximumAge;
}
/**
 * Prompts user for minimum number of players of their toy.
 * Validates input.
 * @return user's toy's minimum number of players.
 */
public int promptMinNumPlayers() {
	System.out.println("Enter the minimum number of players here");
	while(!input.hasNextInt() ) {
		input.nextLine();
		System.out.print("Enter the minimum number of players here: ");
	}
	int minNumPlayers = input.nextInt();
	return minNumPlayers;
}
/**
 * Prompts user for maximum number of players of their toy.
 * Validates input.
 * @return user's toy's maximum number of players.
 */
public int promptMaxNumPlayers() {
	System.out.println("Enter the maximum number of players here");
	while(!input.hasNextInt()) {
		input.nextLine();
		System.out.print("Enter the maximum number of players here: ");
	}
	int maxNumPlayers = input.nextInt();
	return maxNumPlayers;
}
/**
 * Prompts user for designer names of their toy.
 * Validates input.
 * @return user's toy's designer names.
 */
public String promptDesignerNames() {
	System.out.println("Enter designer names here, use ',' to seperate names if there is more than one: ");
	while(!input.hasNextLine()) {
		input.nextLine();
		System.out.print("Enter designer names here, use ',' to seperate names if there is more than one: ");
	}
	String designerNames = input.nextLine().trim();
	return designerNames;
}
public int promptNumberToPurcahse() {
	System.out.println("Enter option number to purchase: ");
	while(!input.hasNextInt()) {
		System.out.println("Enter option number to purchase: ");
		input.nextInt();
	}
	int optionNumber = input.nextInt();
	return optionNumber;
}

}

