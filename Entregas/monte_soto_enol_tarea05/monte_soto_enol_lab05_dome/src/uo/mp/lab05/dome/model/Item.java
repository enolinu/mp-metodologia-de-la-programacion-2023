package uo.mp.lab05.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public abstract class Item {

    private String title;
    private boolean gotIt;
    private String comment = "No comment";
    private double basePrice;

    public Item(String theTitle, double basePrice) {

	setTitle(theTitle);
	setBasePrice(basePrice);
	setOwn(false);

    }

    /**
     * 
     * @param arg String with the new title
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    protected void setTitle(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid title");

	this.title = arg;
    }

    /**
     * 
     * @param boolean true means we own a copy; otherwise, false
     */
    public void setOwn(boolean ownIt) {
	gotIt = ownIt;
    }

    /**
     * 
     * @param arg String with a new comment to the element
     * @implNote If the argument is null or does not contain meaningful characters (other than blanks, new lines, etc)
     *           previous comment stays as it is
     */
    public void setComment(String arg) {
	if (arg != null && !arg.isBlank()) {
	    this.comment = arg;
	}
    }

    /**
     * @return the comment (if any) or default
     */
    public String getComment() {
	return comment;
    }

    /**
     * @return true if we own a copy; false otherwise
     */
    public boolean getOwn() {
	return gotIt;
    }

    /**
     * @return title
     */
    public String getTitle() {
	return this.title;
    }

    public double getBasePrice() {
	return basePrice;
    }

    public void setBasePrice(double basePrice) {
	this.basePrice = basePrice;
    }

    public abstract void print(PrintStream out);

    public abstract String getResponsible();

    public void print2(PrintStream out) {

	out.println("Titulo: " + getTitle());

    }

    public abstract boolean lsLike(Item itemABuscar);

    public abstract double getPrice();

    @Override
    public String toString() {
	return getTitle() + " | " + getComment() + " | ";
    }

}