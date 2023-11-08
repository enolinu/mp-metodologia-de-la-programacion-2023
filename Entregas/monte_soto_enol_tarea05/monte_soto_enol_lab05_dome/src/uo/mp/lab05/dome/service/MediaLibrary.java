package uo.mp.lab05.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab05.dome.model.Item;
import uo.mp.lab05.dome.model.interfaces.Borrowable;

/**
 * Clase de servicio que guarda la librería.
 * 
 * @author enolmontesoto
 *
 */
public class MediaLibrary {

    private List<Item> items = new ArrayList<Item>();
    private List<Borrowable> borrowables = new ArrayList<Borrowable>();

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

	if (item instanceof Borrowable) {
	    borrowables.add((Borrowable) item);
	}

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
     * Para pruebas: lista de los items prestables.
     */
    public String getBorrowables() {

	StringBuilder sb = new StringBuilder();

	for (Borrowable b : borrowables) {
	    sb.append(b)
		.append("\n");
	}

	return sb.toString();
    }

    /**
     * Vuelca en el objeto out los datos de todos los items.
     * 
     * @param out, de tipo PrintStream.
     */
    public void list(PrintStream out) {

	ArgumentChecks.isTrue(out != null, "Cannot be null!");

	for (Item itemInList : items) {
	    out.println(itemInList.toString());
	    out.print("\n");
	}

    }

    /**
     * Vuelca en el objeto out los datos de todos los items.
     * 
     * @param out, de tipo PrintStream.
     */
    public void list2(PrintStream out) {

	ArgumentChecks.isTrue(out != null, "Cannot be null!");

	for (Item itemInList : items) {
	    itemInList.print2(out);
	    out.print("\n");
	}

    }

    /**
     * Método que imprime únicamente los elementos prestables.
     * 
     * @param out
     */
    public void listBorrowableItems(PrintStream out) {

	for (Borrowable b : borrowables) {
	    out.println(b);
	}

    }

    /**
     * Metodo que imprime aquellos items prestables que estan disponibles.
     */
    public void listAvailableItems(PrintStream out) {

	for (Borrowable b : borrowables) {
	    if (b.isAvailable()) {
		out.println(b);
	    }
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
     * Busca un item igual al recibido como parámetro.
     * Dos CD son iguales si son iguales su titulo y autor.
     * Dos DVD son iguales si loo son su titulo y director.
     * Dos Videogames son iguales si lo son su título y plataforma.
     * 
     * @param itemABuscar
     * @return
     */
    public Item search(Item itemABuscar) {

	for (Item i : items) {
	    if (i.equals(itemABuscar)) {
		return i;
	    }
	}

	return null;

    }

    private Borrowable search(Borrowable b) {

	for (Borrowable borrowable : borrowables) {
	    if (b.equals(borrowable)) {
		return borrowable;
	    }
	}

	return null;

    }

    /**
     * Prestar un item.
     */
    public Borrowable borrow(Borrowable item) {

	Borrowable itemToBorrow = search(item);
	if (itemToBorrow == null)
	    return null;
	if (!itemToBorrow.isAvailable())
	    return null;
	itemToBorrow.borrow();
	return itemToBorrow;

    }

    /**
     * Devolver un item prestado.
     */
    public boolean giveBack(Borrowable item) {

	Borrowable itemToBorrow = search(item);
	if (itemToBorrow == null)
	    return false;
	if (itemToBorrow.isAvailable())
	    return false;
	itemToBorrow.giveBack();
	return true;

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

	return new ArrayList<Item>(items);

    }

    public String getComments() {

	StringBuilder sb = new StringBuilder("Lista De Comentarios:\n");

	for (Item item : items) {
	    sb.append(item.getComment())
		.append("\n");
	}

	return sb.toString();

    }

    public String toString() {

	StringBuilder sb = new StringBuilder("Lista de items:\n");

	for (Item itemInList : items) {
	    sb.append(itemInList.toString())
		.append("\n");
	}

	return sb.toString();

    }

    /**
     * Método que devuelve la suma de todos los precios finales.
     * 
     * @return EL total
     */
    public double getTotalPrice() {

	double total = 0;

	for (Item item : items) {
	    total += item.getPrice();
	}

	return total;
    }

    /**
     * Método que devuelve el código de la librería.
     * 
     * @return EL Codigo.
     */
    public String generateCode() {

	StringBuilder sb = new StringBuilder();
	int counter = 0;

	for (Item item : items) {
	    sb.append(item.getTitle()
		.substring(0, 3))
		.append(counter)
		.append("-");
	    counter++;
	}

	sb.delete(sb.toString()
	    .length() - 1, sb.toString()
		.length());

	return sb.toString();

    }
}
