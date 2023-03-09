package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.NegativeInputPrice;
import exceptions.TooManyMinNumPlayers;
import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toy;

import view.AppMenu;

/**
 *The brain of everything, loads toys.txt into an arraylist, launches application and menus.
 * @author Max, Matt
 *
 */
public class AppManager {

	private final String FILE_PATH = "Assignment 2/res/toys.txt";
	AppMenu appMenu;
	ArrayList<Toy> toys;
/**
 * Initializes the AppManager constructor, creates a new arrayList called toys.
 * Initializes a new instance of AppMenu called appMenu.
 * Calls loadData() to load data from toys.txt into the toys arrayList.
 * Catches any errors if user inputs a negative price for toy price using a custom exception class.
 */



public AppManager() {
	toys = new ArrayList<>();
	loadData();
	appMenu = new AppMenu();
	try { //problem code, if user enters negative input price-> go into catch block 
		launchApplication();
	} catch (NegativeInputPrice e) { 
		System.out.println("Error: Negative input price ");
		e.printStackTrace();
		
	}
	
}



/**
 * Initializes application by calling showMainMenu from appMenu.
 * Goes into search function, add new toy, remove toy or save and exit depending on user input.
 * @throws NegativeInputPrice
 */
private void launchApplication() throws NegativeInputPrice {
		
		
		boolean flag = true;
		int option;

		
		while (flag) { //Perform the body of the loop while value of flag = true.
			option = appMenu.showMainMenu();
			switch(option) {
			case 1:
				Search();
				break;
			case 2:
				//Store toy details in named variables
				int serialNum = appMenu.promptSerialNum();
				String toyName = appMenu.promptToyName();
				String toyBrand = appMenu.promptToyBrand();
				double toyPrice = appMenu.promptToyPrice();
				int availableCount = appMenu.promptNumAvailable();
				int appropriateAge = appMenu.promptAppropriateAge();
				int minNumPlayers = appMenu.promptMinNumPlayers();
				int maxNumPlayers = appMenu.promptMaxNumPlayers();
				String designerNames = appMenu.promptDesignerNames();
				
				
				try { //problem code in try block, if any exceptions are met > moves into catch block.
					addNewToy(serialNum, toyName, toyBrand, toyPrice, availableCount, appropriateAge, minNumPlayers, maxNumPlayers, designerNames);
				} catch (Exception e) {
					System.out.println("Error: ");
					e.printStackTrace();
				}
				
			case 3:
				
				serialNum = appMenu.promptSerialNum(); //Prompts user for serial number, finds toy and removes it.
				removeToy(serialNum);
			case 4:
				Save(); //Saves back into toys.txt file.
				flag = false;
			}
		}
}
		
				
			
	/**
	 * If user enters 1 at the main menu, the SubMenu is called from appMenu.
	 * Can search based on serialNum, toyName, or toyType, depending on user input.
	 * If user enters 4, program exits back to the main menu.
	 */
private void Search() {
	int option = appMenu.showSubMenu();
	
	switch(option) { //Switch/case based upon user choice (integers between 1 and 4)
	case 1:
		int serialNum = appMenu.promptSerialNum();
		searchBySerialNum(serialNum);
		break;
	case 2:
		String toyName = appMenu.promptToyName();
		searchByToyName(toyName);
		break;
	case 3:
		String toyType = appMenu.promptToyType();
		searchByType(toyType);
		break;
	case 4:	
		break;
		
	}
}
/**
 * Prints new data into the toys.txt file using the format method.
 * Toy subclasses overload format method depending on toy type.
 */
private void Save(){
	File db = new File(FILE_PATH);
	PrintWriter pw = null;
	
	
	try { // "Problem" code in try code, if file is not found, system prints a message and throws and exception
		pw = new PrintWriter(db); 
	} catch (FileNotFoundException e) {
		System.out.println("Data cannot be saved as the file cannot be found");
		e.printStackTrace();
	}
	System.out.println("Saving...");
	System.out.println("Save Complete!");
	
	
	
	
	for (Toy t1: toys) {//Loops thru toys array and instantiates changes using the .format method.
		pw.println(t1.format());
		
		
	}
	
	pw.close();
	
}





private void searchByType(String toyType) {
	
	
}




private void searchByToyName(String toyName) {
	
	
}




private void searchBySerialNum(int serialNum) {
	
	
}









private void removeToy(int serialNum) {
	// TODO Auto-generated method stub
	
}




private void addNewToy
(int serialNum, String toyName, String toyBrand, double toyPrice, int availableCount, 
int appropriateAge, int minNumPlayers, int maxNumPlayers, String designerNames) throws Exception 
{
	if (toyPrice < 0) //If statements to catch exceptions that may occur
		throw new NegativeInputPrice();
	if (minNumPlayers > maxNumPlayers)
		throw new TooManyMinNumPlayers();
	
}



/**
 * Uses a scanner and while loop to load data from toys.txt file into the toys array.
 * Depending on the first number of the serial number, different types of toys are created by splitting data.
 */
private void loadData() {
	File db = new File(FILE_PATH);
	String currentLine;
	String[] splittedLine;

	
	if (db.exists()) {
		Scanner fileReader = null;
		try {
			
			fileReader = new Scanner(db);//If file is not found, system goes into the filenotfoundexception and prints to the user.
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		}
		
		while (fileReader.hasNextLine()) {
			
			currentLine = fileReader.nextLine();
			splittedLine = currentLine.split(";");
			String serialNum= (splittedLine[0].trim());
			
			char firstDigit = serialNum.charAt(0);
			int firstDigitInt = Integer.parseInt(String.valueOf(firstDigit));
			System.out.println(firstDigitInt);
			if (firstDigitInt == (0 | 1)) {
				Figures f = new Figures(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].strip());
				toys.add(f);
				
			}
			
			else if (firstDigitInt == (2|3)) {
				System.out.println("this is working");
				Animals a = new Animals(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].strip(), splittedLine[7].strip());
				toys.add(a);
			}
			
			else if (firstDigitInt == (4|5|6)) {
				Puzzles p = new Puzzles(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].strip());
				toys.add(p);
			}
			
			else if (firstDigit == ('7'|'8'|'9')) {
				BoardGames b = new BoardGames(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), Integer.parseInt(splittedLine[6]), splittedLine[7].strip());
				toys.add(b);
			}
			
			
		}
		fileReader.close();
		// if serialNum starts with 0 or 1 -> load into figures object
		
		
//		if serial num starts with 0 or 1 = figures
		// if serial num starts with 2 or 3 = Animals
		// if is figure load into figure object 
//		Toy t = new Toy(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
//				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]));
	
	}
	
}
}

