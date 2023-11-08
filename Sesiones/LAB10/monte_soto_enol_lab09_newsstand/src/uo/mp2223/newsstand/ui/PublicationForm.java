package uo.mp2223.newsstand.ui;

import uo.mp.util.console.Console;
import uo.mp2223.newsstand.domain.Frequency;
import uo.mp2223.newsstand.domain.Magazine;
import uo.mp2223.newsstand.domain.Newspaper;
import uo.mp2223.newsstand.domain.Publication;


/**
 * Asks the user all the data for a new publication.
 * 
 */
public class PublicationForm {

	/**
	 * @return The new Publication object created. It will be be of any 
	 * of the child types of Publication.
	 */
	public Publication askForPublication() {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
			case "n": return askForNewsPaper();
			case "m": return askForMagazine();
			default:  return null;
		}

	}

	private Publication askForMagazine() {
		String name = Console.readString("name?");
		int stock = Console.readInt("stock?");
		int sales = Console.readInt("sales?");
		Frequency frequency = Frequency.valueOf(Console.readString("frequency?"));

		return new Magazine(name, stock, sales, frequency);
	}

	private Publication askForNewsPaper() {
		String name = Console.readString("name?");
		int stock = Console.readInt("stock?");
		int sales = Console.readInt("sales?");

		return new Newspaper(name, stock, sales);
	}

}
