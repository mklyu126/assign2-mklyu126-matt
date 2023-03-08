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

	private final String FILE_PATH = "res/toys.txt";
	AppMenu appMenu;
	ArrayList<Toy> toys;
/**
 * Initalizes the AppManager constructor, creates a new arrayList called toys.
 * Initializes a new instance of AppMenu called appMenu.
 * Calls loadData() to load data from toys.txt into the toys arrayList.
 * Catches any errors if user inputs a negative price for toy price using a custom exception class.
 */



public AppManager() {
	toys = new ArrayList<>();
	appMenu = new AppMenu();
	loadData();
	try {
		launchApplication();
	} catch (NegativeInputPrice e) {
		
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

		
		while (flag) {
			option = appMenu.showMainMenu();
			switch(option) {
			case 1:
				Search();
				break;
			case 2:
				int serialNum = appMenu.promptSerialNum();
				String toyName = appMenu.promptToyName();
				String toyBrand = appMenu.promptToyBrand();
				double toyPrice = appMenu.promptToyPrice();
				int availableCount = appMenu.promptNumAvailable();
				int appropriateAge = appMenu.promptAppropriateAge();
				int minNumPlayers = appMenu.promptMinNumPlayers();
				int maxNumPlayers = appMenu.promptMaxNumPlayers();
				String designerNames = appMenu.promptDesignerNames();
				
				
				try {
					addNewToy(serialNum, toyName, toyBrand, toyPrice, availableCount, appropriateAge, minNumPlayers, maxNumPlayers, designerNames);
				} catch (Exception e) {
					System.out.println("A problem occured");
					e.printStackTrace();
				}
				
			case 3:
				
				serialNum = appMenu.promptSerialNum();
				removeToy(serialNum);
			case 4:
				Save();
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
	
	switch(option) {
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
	
	
	try {
		pw = new PrintWriter(db);
	} catch (FileNotFoundException e) {
		System.out.println("Data cannot be saved as the file cannot be found");
		e.printStackTrace();
	}
	System.out.println("Saving...");
	System.out.println("Save Complete!");
	
	
	
	
	for (Toy t1: toys) {
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
	if (toyPrice < 0)
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
			
			fileReader = new Scanner(db);
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		}
		
		while (fileReader.hasNextLine()) {
			
			currentLine = fileReader.nextLine();
			splittedLine = currentLine.split(";");
			int serialNum= Integer.parseInt(splittedLine[0]);
			
			int firstDigit = Integer.parseInt(Integer.toString(serialNum).substring(0,1));
			
			if (firstDigit == (0 | 1)) {
				Figures f = new Figures(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].strip());
				toys.add(f);
				
			}
			
			else if (firstDigit == (2|3)) {
				Animals a = new Animals(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].strip(), splittedLine[7].strip());
				toys.add(a);
			}
			
			else if (firstDigit == (4|5|6)) {
				Puzzles p = new Puzzles(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].strip());
				toys.add(p);
			}
			
			else if (firstDigit == (7|8|9)) {
				BoardGames b = new BoardGames(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), Integer.parseInt(splittedLine[6]), splittedLine[7].strip());
				toys.add(b);
			}
				fileReader.close();
				
		}
		// if serialNum starts with 0 or 1 -> load into figures object
		
		
//		if serial num starts with 0 or 1 = figures
		// if serial num starts with 2 or 3 = Animals
		// if is figure load into figure object 
//		Toy t = new Toy(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(),
//				Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]));
	
	}
	
}
}

