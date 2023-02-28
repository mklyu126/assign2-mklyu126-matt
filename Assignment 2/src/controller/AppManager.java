package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toy;

import view.AppMenu;

public class AppManager {

	private final String FILE_PATH = "res/toys.txt";
	AppMenu appMenu;
	ArrayList<Toy> toys;




public AppManager() {
	toys = new ArrayList<>();
	appMenu = new AppMenu();
	loadData();
	launchApplication();
	
}




private void launchApplication() {
		
		
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
				int toyPrice = appMenu.promptToyPrice();
				int availableCount = appMenu.promptNumAvailable();
				int appropriateAge = appMenu.promptAppropriateAge();
				int minNumPlayers = appMenu.promptMinNumPlayers();
				int maxNumPlayers = appMenu.promptMaxNumPlayers();
				String designerNames = appMenu.promptDesignerNames();
				
				addNewToy(serialNum, toyName, toyBrand, toyPrice, availableCount, appropriateAge, minNumPlayers, maxNumPlayers, designerNames);
				break;
			case 3:
				
				serialNum = appMenu.promptSerialNum();
				removeToy(serialNum);
			case 4:
				try {
					Save();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				flag = false;
			}
		}
}
		
				
			
	
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

private void Save() throws IOException {
	File db = new File(FILE_PATH);
	PrintWriter pw = new PrintWriter(db);
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
(int serialNum, String toyName, String toyBrand, int toyPrice, int availableCount, 
int appropriateAge, int minNumPlayers, int maxNumPlayers, String designerNames) 
{
	// TODO Auto-generated method stub
	
}




private void loadData() {
	File db = new File(FILE_PATH);
	String currentLine;
	String[] splittedLine;

	
	if (db.exists()) {
		Scanner fileReader = null;
		try {
			
			fileReader = new Scanner(db);
		} catch (FileNotFoundException e) {
			
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

