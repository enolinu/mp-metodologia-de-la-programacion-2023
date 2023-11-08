package uo.mp.lab05.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab05.dome.model.interfaces.Borrowable;

/**
 * Clase Book
 * 
 * @author enolmontesoto
 */
public class Book extends Item implements Borrowable {

    private String author;
    private String editorial;
    private String isbn;
    private boolean borrowed;

    public Book(String theTitle, String theAuthor, String theEditorial, String theIsbn, double basePrice) {

	super(theTitle, basePrice);

	ArgumentChecks.isTrue(!theAuthor.equals(null));
	ArgumentChecks.isTrue(!theEditorial.equals(null));
	ArgumentChecks.isTrue(!theIsbn.equals(null));
	ArgumentChecks.isTrue(!theAuthor.isEmpty());
	ArgumentChecks.isTrue(!theEditorial.isEmpty());
	ArgumentChecks.isTrue(!theIsbn.isEmpty());

	setAuthor(theAuthor);
	setEditorial(theEditorial);
	setIsbn(theIsbn);
	setBorrowed(false);

    }

    /**
     * @return author
     */
    public String getAuthor() {
	return author;
    }

    private void setAuthor(String author) {
	this.author = author;
    }

    /**
     * @return editorial
     */
    public String getEditorial() {
	return editorial;
    }

    private void setEditorial(String editorial) {
	this.editorial = editorial;
    }

    /**
     * @return isbn
     */
    public String getIsbn() {
	return isbn;
    }

    public void setIsbn(String isbn) {
	this.isbn = isbn;
    }

    public boolean isBorrowed() {
	return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
	this.borrowed = borrowed;
    }

    /**
     * Redefinición del método "print", que muestra los atributos.
     */
    @Override
    public void print(PrintStream out) {

	out.println("Book: " + getTitle());
	out.println("Author: " + getAuthor());
	out.println("Editorial: " + getEditorial());
	out.println("ISBN: " + getIsbn());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());

    }

    /**
     * Indica y devuelve quién es el responsable del libro, en este caso el autor.
     * 
     * @return El autor del libro.
     */
    @Override
    public String getResponsible() {
	return this.getAuthor();
    }

    /*
     * Obsoleto.
     */
    @Override
    public boolean lsLike(Item itemABuscar) {
	// TODO Auto-generated method stub
	return false;
    }

    /**
     * Devuelve el precio final.
     * 
     * @return El precio base, pero sumándole un 4%.
     */
    @Override
    public double getPrice() {
	return getBasePrice() + (0.04 * getBasePrice());
    }

    /**
     * El método toString()
     * 
     * @return Una cadena representativa del objeto.
     */
    @Override
    public String toString() {
	return super.toString() + "Book [author=" + author + ", editorial=" + editorial + ", isbn=" + isbn + "]";
    }

    /**
     * Redefinición del método "equals".
     * 
     * @return True en el caso de que sean iguales, false en cualquier otro caso.
     */
    @Override
    public boolean equals(Object obj) {

	if (this == obj) {
	    return true;
	}

	if (!(obj instanceof Book)) {
	    return false;
	}

	Book book = (Book) obj;
	return book.getTitle()
	    .equals(this.getTitle())
		&& book.getIsbn()
		    .equals(this.getIsbn());

    }

    /**
     * Metodo para comprobar que está disponible.
     * 
     * @return true si lo está.
     */
    @Override
    public boolean isAvailable() {

	return (!(isBorrowed()) && getOwn());

    }

    /**
     * Presta un item.
     */
    @Override
    public void borrow() {

	setBorrowed(true);

    }

    /**
     * Devolver el item.
     */
    @Override
    public void giveBack() {

	setBorrowed(false);

    }

}
