package uo.mp.lab03.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab03.dome.model.Item;

/**
 * 
 * @author enolmontesoto
 *
 */
public class MediaLibrary {

    private List<Item> items = new ArrayList<Item>();;

    public MediaLibrary() {

    }

    /**
     * A�ade un item no nulo a la lista.
     * 
     * @param Item a a�adir.
     * @throws IllegalArgumentException si recibe null.
     */
    public void add(Item item) {

	ArgumentChecks.isTrue(item != null, "Recibido null en lugar de item!");
	items.add(item);

    }

    /**
     * Calcula el n�mero de items con propietario.
     * 
     * @return N�mero de items con propietario.
     */
    public int getNumberOfItemsOwned() {

	int owned = 0;

	for (Item itemInList : items) {
	    if (itemInList.getOwn()) {
		owned++;
	    }
	}

	return owned;
    }

    /**
     * Vuelva en el objeto out los datos de todos los items.
     * 
     * @param out, de tipo PrintStream.
     */
    public void list(PrintStream out) {

	for (Item itemInList : items) {
	    itemInList.print(out);
	}

    }

}
