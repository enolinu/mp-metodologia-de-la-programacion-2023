package uo.mp.lab03.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab03.dome.model.Item;

/**
 * Clase de servicio que guarda la librería.
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
     * Vuelca en el objeto out los datos de todos los items.
     * 
     * @param out, de tipo PrintStream.
     */
    public void list(PrintStream out) {

	for (Item itemInList : items) {
	    itemInList.print(out);
	    out.print("\n");
	}

    }

    /**
     * Método que devuelve el item que se le pasa por parametro.
     * 
     * @param itemABuscar
     * @return El item en cuestión si lo encuentra, "null" en caso contrario.
     */
    public Item searchItem(Item itemABuscar) {

	for (Item i : items) {
	    if (i.equals(itemABuscar)) {
		return i;
	    }
	}

	return null;
    }

    /**
     * Método que devuelve una cadena de caracteres separadas por comas con el
     * responsable de cada item de la lista.
     * 
     * @return String con la lista de responsables.
     */
    public String getResponsibles() {

	StringBuilder sb = new StringBuilder();

	for (Item i : items) {
	    sb.append(i.getResponsible());
	    sb.append(", ");
	}

	return sb.toString();

    }

    public ArrayList<Item> getItemsForTesting() {

	ArrayList<Item> aux = new ArrayList<Item>();

	for (Item i : items) {
	    aux.add(i);
	}

	return aux;

    }

}
