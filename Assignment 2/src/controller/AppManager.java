package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.toy;

import view.AppMenu;

public class AppManager {

	private final String FILE_PATH = "res/toys.txt";
	AppMenu appMenu;
	ArrayList<toy> toys;




public AppManager() throws Exception {
	toys = new ArrayList<>();
	appMenu = new AppMenu();
	loadData();
	launchApplication();
}




private void launchApplication() {

		
		boolean flag = true;
		int option;
//		toy curr_player = null;
		
		while (flag) {
			option = appMenu.showMainMenu();
			switch(option) {
			case 1:
				Search();
				break;
			case 2:
				addNewToy();
				break;
			case 3:
				removeToy();
			case 4:
				Save();
				flag = false;
			}
		}
}
		
				
			
	
private void Search() {
	int option = appMenu.showSubMenu();
	
	switch(option) {
	case '1':
		searchBySerialNum();
		break;
	case '2':
		searchByToyName();
		break;
	case '3':
		searchByType();
		break;
	case '4':	
		break;
		
	}
}

private void Save() throws IOException {
	File db = new File(FILE_PATH);
	String currentLine;
	String[] splittedLine;
	
	if (db.exists()) {
		Scanner fileReader = new Scanner(db);
		
		while (fileReader.hasNextLine()){
			
			currentLine = fileReader.nextLine();
			splittedLine = currentLine.split(";");
//			toy t = new toy(Integer.parseInt(splittedLine[0]), splittedLine[1].strip(), splittedLine[2].strip(), ) ;
//			players.add(p);
		}
	
	}
	
}





private void searchByType() {
	// TODO Auto-generated method stub
	
}




private void searchByToyName() {
	// TODO Auto-generated method stub
	
}




private void searchBySerialNum() {
	// TODO Auto-generated method stub
	
}









private void removeToy() {
	// TODO Auto-generated method stub
	
}




private void addNewToy() {
	// TODO Auto-generated method stub
	
}




private void loadData() {
	// TODO Auto-generated method stub
	
}


}