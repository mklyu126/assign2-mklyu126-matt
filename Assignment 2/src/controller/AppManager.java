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
	ArrayList<Toy> tempToys;
	Scanner scanner;
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
	scanner = new Scanner(System.in);
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
				String serialNum = appMenu.promptSerialNum();
				String toyName = appMenu.promptToyName();
				String toyBrand = appMenu.promptToyBrand();
				float toyPrice = appMenu.promptToyPrice();
				int availableCount = appMenu.promptNumAvailable();
				int minimumAge = appMenu.promptMinimumAge();
				
				
				
				try { //problem code in try block, if any exceptions are met > moves into catch block.
					addNewToy(serialNum, toyName, toyBrand, toyPrice, availableCount, minimumAge);
				} catch (Exception e) {
					System.out.println("Error: ");
					e.printStackTrace();
				}
				break;
			case 3:
				
				serialNum = appMenu.promptSerialNum(); //Prompts user for serial number, finds toy and removes it.
				removeToy(serialNum);
				break;
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
		String serialNum = appMenu.promptSerialNum();
		
		searchBySerialNum(serialNum);
		break;
	case 2:
		String toyName;
		toyName = appMenu.promptToyName();
		searchByToyName(toyName);
		break;
	case 3:
		String toyType;
		toyType = appMenu.promptToyType();
		
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




/**
 * takes in users input and searches for the toy
 * @param toyType
 */
private void searchByType(String toyType) {
	int category = -1;
	int inventory;
	long serialNum;
	
	tempToys = new ArrayList<>();
	boolean found = false;
	
	if (toyType.toLowerCase().contains("figures")) {
		for(Toy t: toys) {
			
			String firstDigitTostring = t.getSerialNum();
			char getfirstDigit = firstDigitTostring.charAt(0);
			long firstDigitToLong = Character.getNumericValue(getfirstDigit);
			
			if(firstDigitToLong == 0 || firstDigitToLong == 1) {
				tempToys.add(t);
				found = true;
			}
		}
	}
	
	else if (toyType.toLowerCase().contains("animals")) {
		for(Toy t: toys) {
			
			String firstDigitTostring = t.getSerialNum();
			char getfirstDigit = firstDigitTostring.charAt(0);
			long firstDigitToLong = Character.getNumericValue(getfirstDigit);
			
			if(firstDigitToLong == 4 || firstDigitToLong == 5 || firstDigitToLong == 6) {
				tempToys.add(t);
				found = true;
			}
		}
	}
	
	else if (toyType.toLowerCase().contains("puzzles")) {
		for(Toy t: toys) {
			
			String firstDigitTostring = t.getSerialNum();
			char getfirstDigit = firstDigitTostring.charAt(0);
			long firstDigitToLong = Character.getNumericValue(getfirstDigit);
			
			if(firstDigitToLong == 4 || firstDigitToLong == 5 || firstDigitToLong == 6) {
				tempToys.add(t);
				found = true;
			}
		}
	}
	
	else if (toyType.toLowerCase().contains("board games")) {
		for(Toy t: toys) {
			
			String firstDigitTostring = t.getSerialNum();
			char getfirstDigit = firstDigitTostring.charAt(0);
			long firstDigitToLong = Character.getNumericValue(getfirstDigit);
			
			if(firstDigitToLong == 7 || firstDigitToLong == 8 || firstDigitToLong == 9) {
				tempToys.add(t);
				found = true;
			}
		}
	}
	else {
		System.out.println(toyType + " is not found.");
		tempToys.clear();
	}
	
	
	
	if(found) {
		category += 1;
		
		System.out.println("Here are the search results: ");
		for (Toy t : tempToys) {
			String toyClass = t.getClass().toString();
			int indexClass = toyClass.lastIndexOf(".") + 1;
			String actClass = toyClass.substring(indexClass);
			System.out.printf("(%d) Category: %s %s %n", category,actClass, t);
			category += 1;
		}
		

		System.out.printf("(%d) Back to Menu %n", category);
		int purchaseOption = appMenu.promptNumberToPurchase();

//		System.out.println("Inventory before " + tempToys.get(purchaseOption).getAvailableCount());

		if (purchaseOption >= tempToys.size() || purchaseOption < 0) {
			tempToys.clear();
			Search();
		} else if (purchaseOption < tempToys.size()) {
			inventory = tempToys.get(purchaseOption).getAvailableCount();

			if (inventory > 0) {
				inventory -= 1;
				tempToys.get(purchaseOption).setAvailableCount(inventory);
				System.out.println("The Transaction Successfully Purchased \n");
				System.out.println("Press Enter to continue...");
				scanner.nextLine();
				Search();
				tempToys.clear();
			} else {
				System.out.println("Out of stock");
				tempToys.clear();
				
			}

		}

//		System.out.println("Inventory After " + tempToys.get(purchaseOption).getAvailableCount());
	}
	
}



/**
 * takes in userinput and look up the toy the user asks for 
 * @param toyName
 */
private void searchByToyName(String toyName) {
	int category = -1;
	int inventory;
	
	tempToys = new ArrayList<>();
	boolean found = false;
	
	
	
	
	
	for(Toy t :toys) {
		if (t.getName().trim().toLowerCase().contains(toyName)) {
			found = true;
			tempToys.add(t);

		} 
	}
	
	if (found) {

		
		category += 1;
		
		System.out.println("Here are the search results: ");
		for (Toy t : tempToys) {
			String toyClass = t.getClass().toString();
			int indexClass = toyClass.lastIndexOf(".") + 1;
			String actClass = toyClass.substring(indexClass);
//			System.out.println(actClass);
			System.out.printf("(%d) Category: %s %s %n", category, actClass, t);
			category += 1;
		}
		System.out.printf("(%d) Back to Menu %n", category);
		int purchaseOption = appMenu.promptNumberToPurchase();
		

		
//		System.out.println("Inventory before " + tempToys.get(purchaseOption).getAvailableCount());
		
		if (purchaseOption >= tempToys.size() || purchaseOption < 0) {

			tempToys.clear();
			for(Toy t : tempToys) {
				System.out.println(t);
				Search();
			}
		}
		else if (purchaseOption < tempToys.size()) {
			inventory = tempToys.get(purchaseOption).getAvailableCount();
			
			if(inventory > 0) {
				inventory -= 1;
				tempToys.get(purchaseOption).setAvailableCount(inventory);
				System.out.println("The Transaction Successfully Purchased \n");
				System.out.println("Press Enter to continue...");
				scanner.nextLine();
				Search();
				tempToys.clear();
			}
			else {
				System.out.println("Out of stock");
				tempToys.clear();
			}

		}
		
//		System.out.println("Inventory After " +  tempToys.get(purchaseOption).getAvailableCount());
	}
	
}



/**
 * takes ina serial number the user input and find toy that matches the serial number
 * @param serialNum
 */
private void searchBySerialNum(String serialNum) {
	int category = -1;
	int inventory;
	
	tempToys = new ArrayList<>();
	boolean found = false;
	
	
	
	
	
	for(Toy t :toys) {
		if (Long.parseLong(serialNum) == Long.parseLong(t.getSerialNum())) {
			found = true;
			tempToys.add(t);

		} 
	}
	if (found) {
				
		category += 1;
		
		System.out.println("Here are the search results: ");
		for (Toy t : tempToys) {
			String toyClass = t.getClass().toString();
			int indexClass = toyClass.lastIndexOf(".") + 1;
			String actClass = toyClass.substring(indexClass);
			System.out.printf("(%d) Category: %s %s %n", category,actClass, t);
			category += 1;
		}
		System.out.printf("(%d) Back to Menu %n", category);
		int purchaseOption = appMenu.promptNumberToPurchase();
		

		
//		System.out.println("Inventory before " + tempToys.get(purchaseOption).getAvailableCount());
		
		if (purchaseOption >= tempToys.size() || purchaseOption < 0) {

			tempToys.clear();
			for(Toy t : tempToys) {
				System.out.println(t);
				Search();
			}
		}
		else if (purchaseOption < tempToys.size()) {
			inventory = tempToys.get(purchaseOption).getAvailableCount();
			
			if(inventory > 0) {
				inventory -= 1;
				tempToys.get(purchaseOption).setAvailableCount(inventory);
				System.out.println("The Transaction Successfully Purchased \n");
				System.out.println("Press Enter to continue...");
				scanner.nextLine();
				Search();
				tempToys.clear();
			}
			else {
				System.out.println("Out of stock");
				tempToys.clear();
			}

		}
		
//		System.out.println("Inventory After " +  tempToys.get(purchaseOption).getAvailableCount());
	}

}








/**
 * takes in serial number from user find the serial number that matches and asks the user if they want to remove the toy
 * @param serialNum
 */
private void removeToy(String serialNum) {

	int index = -1;

	for (Toy t : toys) {
		index += 1;
		if (Long.parseLong(serialNum) == Long.parseLong(t.getSerialNum())) {
			System.out.println("This item is found:");
			String toyClass = t.getClass().toString();
			int indexClass = toyClass.lastIndexOf(".") + 1;
			String actClass = toyClass.substring(indexClass);
			System.out.printf("Category: %s %s %n",actClass, t);
			break;
		}
	}
	String answer = appMenu.promptYesandNo();
	if (answer.equalsIgnoreCase("y")) {
        System.out.println("Item Removed!");
        toys.remove(index);
        System.out.println("Press Enter to continue");
		scanner.nextLine();

	}
	else{
		Search();
	}

}




/**
 * takes in serial number, toy name, brand, price, available count, and age then it formats and create a new two
 * @param serialNum
 * @param toyName
 * @param toyBrand
 * @param toyPrice
 * @param availableCount
 * @param minimumAge
 * @throws Exception
 */
private void addNewToy
(String serialNum, String toyName, String toyBrand, float toyPrice, int availableCount, 
int minimumAge) throws Exception 
{
	if (toyPrice < 0) //If statements to catch exceptions that may occur
		throw new NegativeInputPrice();	
	
	
	String serialNumString;
	serialNumString = serialNum +"";
	
	
	char firstDigit = serialNumString.charAt(0);
	int firstDigitInt = Integer.parseInt(String.valueOf(firstDigit));
	
	if (firstDigitInt == 0 || firstDigitInt == 1) {
		String classification = appMenu.promptClassification();
		Figures f = new Figures(serialNumString.trim(), toyName, toyBrand, toyPrice, availableCount, minimumAge, classification );
		toys.add(f);
	}
	if (firstDigitInt == 2 || firstDigitInt == 3) {
		String material = appMenu.promptMaterial();
		String size = appMenu.promptSize();
		Animals a = new Animals(serialNumString.trim(), toyName, toyBrand, toyPrice, availableCount, minimumAge, material, size );
		toys.add(a);
	}
	if (firstDigitInt == 4 || firstDigitInt == 5 || firstDigitInt == 6) {
		String puzzleType = appMenu.promptPuzzleType();
		Puzzles p = new Puzzles(serialNumString.trim(), toyName, toyBrand, toyPrice, availableCount, minimumAge, puzzleType );
		toys.add(p);
	}
	if (firstDigitInt == 7 || firstDigitInt == 8 || firstDigitInt == 9) {
		int minNumPlayers = appMenu.promptMinNumPlayers();
		int maxNumPlayers = appMenu.promptMaxNumPlayers();
		if (minNumPlayers > maxNumPlayers)
			throw new TooManyMinNumPlayers();
		String designerNames = appMenu.promptDesignerNames();
		BoardGames g = new BoardGames(serialNumString.trim(), toyName, toyBrand, toyPrice, availableCount, minimumAge, minNumPlayers, maxNumPlayers, designerNames );
		toys.add(g);
	}
	
	
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
			
			fileReader = new Scanner(db);//If file is not found, system goes into the fil5enotfoundexception and prints to the user.
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		}
		
		while (fileReader.hasNextLine()) {
			
			currentLine = fileReader.nextLine();
			splittedLine = currentLine.split(";");
			
			
			String serialNum = (splittedLine[0].trim());
			
			char firstDigit = serialNum.charAt(0);
			int firstDigitInt = Integer.parseInt(String.valueOf(firstDigit));
			
			
			if (firstDigitInt == 0 || firstDigitInt == 1) {
				Figures f = new Figures(splittedLine[0].trim(), splittedLine[1].strip(), splittedLine[2].strip(),
				Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].strip());
				toys.add(f);
				
			}
			
			else if (firstDigitInt == 2 || firstDigitInt == 3){
				Animals a = new Animals(splittedLine[0].trim(), splittedLine[1].strip(), splittedLine[2].strip(),
				Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].strip(), splittedLine[7].strip());
				toys.add(a);
			}
			
			else if (firstDigitInt == 4 || firstDigitInt == 5 || firstDigitInt == 6) {
				Puzzles p = new Puzzles(splittedLine[0].trim(), splittedLine[1].strip(), splittedLine[2].strip(),
				Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].strip());
				toys.add(p);
			}
			
			else if (firstDigitInt == 7 || firstDigitInt == 8 || firstDigitInt == 9) {

				String [] minMaxPlayers = splittedLine[6].split("-");
				int minAge = Integer.parseInt(minMaxPlayers[0]);
				int maxAge = Integer.parseInt(minMaxPlayers[1]);
				

				
				BoardGames b = new BoardGames(splittedLine[0].trim(), splittedLine[1].strip(), splittedLine[2].strip(),
				Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]),minAge, maxAge, splittedLine[7].strip());
				toys.add(b);
			}
			
		
		}
		
		fileReader.close();
//		for (Toy t : toys) {
//			String toyClass = t.getClass().toString();
//			int indexClass = toyClass.lastIndexOf(".") + 1;
//			String actClass = toyClass.substring(indexClass);
//			System.out.println(actClass);
//		}
	
	}
	
}
}

