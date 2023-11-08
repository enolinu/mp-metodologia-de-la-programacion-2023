package uo.mp2223.newsstand.ui;

import java.util.List;

import uo.mp.util.console.Console;
import uo.mp2223.newsstand.domain.Publication;
import uo.mp2223.newsstand.service.Newsstand;
import uo.mp2223.util.log.Logger;


/**
 * It is in charge of interacting with the user:
 * 	- Shows the menu of options
 *  - Process the option chosen by the user
 *  	- For that it asks the user the necessary data to fulfill the request
 *  	- Shows the result of the request
 *  - In case of error shows an explaining message
 *  
 *  Note: This is the unique class allowed to show information to the user
 */
public class UserInterface {
	private static final int EXIT = 0;

	private Menu menu = new Menu();
	private Newsstand newsStand = new Newsstand();
	
	public void show()  {
		int option = EXIT;
		do {
			
			// Capturar cualquier error de programación o sistema.
			
			try {
				
				menu.show();
				option = menu.readOption();
				processOption(option);
				
			} catch(RuntimeException e) {
				handleSystemError(e);
			}
			
		} while (option != EXIT);
	}

	private void handleSystemError(RuntimeException e) {
		
		Logger.log("Error irrecuperable. Por favor contacte con el administador.");
		Logger.log(e.getMessage());
		
	}

	private void processOption(int option) {
		switch( option ) {
			case EXIT: return;
			case 1: loadFile(); break;
			case 2: showPublications(); break;				
			case 3: addPublication(); break;
			case 4: removePublication(); break;				
			case 5: createOrders(); break; 				
			case 6: saveOrdersToFile(); break;
			case 7: importFromZip(); break;
			case 8: exportToZip(); break;
		}
	}

	private void loadFile() {
		String fileName = Console.readString("File name?");
		newsStand.loadFile( fileName );
	}
	
	private void addPublication() {
		Publication p = new PublicationForm().askForPublication();
		newsStand.addPublication( p );
	}

	private void removePublication() {
		String name = Console.readString("publication name?");
		newsStand.removePublication( name );
	}
	
	private void showPublications() {
		List<Publication> publications = newsStand.getPublications();
		listPublications( publications );
	}

	private void createOrders() {
		newsStand.createOrders();
	}

	private void listPublications(List<Publication> publications) {
		Console.println("\nList of publications");
		Console.println("------------------");
		for (Publication p: publications) {
			System.out.println( p );
		} 
	
		Console.println("------------------");
   }	
	
	private void saveOrdersToFile() {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile( fileName );
	}
	
	private void importFromZip() {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile( fileName );
	}
	
	private void exportToZip() {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile( fileName );
	}

}
