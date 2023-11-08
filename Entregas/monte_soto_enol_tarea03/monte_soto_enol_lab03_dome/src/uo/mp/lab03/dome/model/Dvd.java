package uo.mp.lab03.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public class Dvd extends Item {

    private String director;
    private int playingTime;

    /**
     * Creates a new Dvd with default values for gotIt and comment
     * 
     * @param theTitle    String for title
     * @param theDirector String for director
     * @param time        integer for time
     */
    public Dvd(String theTitle, String theDirector, int time) {

	super(theTitle);
	setDirector(theDirector);
	setPlayingTime(time);

    }

    /**
     * 
     * @param arg String with the new director
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setDirector(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid director");
	this.director = arg;
    }

    /**
     * @return the director of the dvd
     */
    public String getDirector() {
	return this.director;
    }

    private void setPlayingTime(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid playing time");
	this.playingTime = arg;
    }

    /**
     * @return playing time
     */
    public int getPlayingTime() {
	return this.playingTime;
    }

    /**
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
	out.println("DVD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Director: " + getDirector());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
    }

    /**
     * Redefinición del método "equals" para items tipo DVD.
     */
    @Override
    public boolean equals(Item item) {

	if (item == this) {
	    return true;
	}

	if (!(item instanceof Dvd)) {
	    return false;
	}

	Dvd dvd = (Dvd) item;

	return dvd.getDirector()
	    .equals(this.getDirector())
		&& dvd.getTitle()
		    .equals(this.getTitle())
		&& dvd.getPlayingTime() == this.getPlayingTime();
    }

    @Override
    public String getResponsible() {

	return this.getDirector();

    }

}
