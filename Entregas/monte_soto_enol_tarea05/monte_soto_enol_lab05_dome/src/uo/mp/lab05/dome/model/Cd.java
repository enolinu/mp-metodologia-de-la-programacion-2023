package uo.mp.lab05.dome.model;

import java.io.PrintStream;
import java.util.Objects;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab05.dome.model.interfaces.Borrowable;

/**
 * Clase CD
 * 
 * @author enolmontesoto
 */
public class Cd extends Item implements Borrowable {

    private static final double TAX = 2;

    private String artist;
    private int numberOfTracks;
    private int playingTime;
    private boolean borrowed;

    /**
     * Creates a new Cd with default values for gotIt and comment
     * 
     * @param theTitle  String for title
     * @param theArtist String for artist
     * @param tracks    integer for tracks
     * @param time      integer for time
     */
    public Cd(String theTitle, String theArtist, int tracks, int time, double basePrice) {

	super(theTitle, basePrice);
	setArtist(theArtist);
	setNumberOfTracks(tracks);
	setPlayingTime(time);
	setBorrowed(false);

    }

    /**
     * 
     * @param arg String with the new artist name
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setArtist(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid artist");

	this.artist = arg;
    }

    /**
     * 
     * @param arg integer with the number of tracks in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal zero
     */
    private void setNumberOfTracks(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid number of tracks");
	this.numberOfTracks = arg;
    }

    /**
     * @return artist's name
     */
    public String getArtist() {
	return this.artist;
    }

    /**
     * @return number of tracks
     */
    public int getNumberOfTracks() {
	return this.numberOfTracks;
    }

    /**
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
	out.println("CD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Artist: " + getArtist());
	out.println("Tracks: " + getNumberOfTracks());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
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

    public boolean isBorrowed() {
	return borrowed;
    }

    private void setBorrowed(boolean borrowed) {
	this.borrowed = borrowed;
    }

    /**
     * Redefinición del método "equals" para items tipo CD.
     */
    @Override
    public boolean equals(Object object) {

	if (this == object) {
	    return true;
	}

	if (!(object instanceof Cd)) {
	    return false;
	}
	Cd cd = (Cd) object;

	return cd.getArtist()
	    .equals(this.getArtist())
		&& cd.getTitle()
		    .equals(this.getTitle());

    }

    /**
     * Devuelve el artista.
     */
    @Override
    public String getResponsible() {

	return this.getArtist();

    }

    /**
     * Método hashCode() redefinido()
     */
    @Override
    public int hashCode() {
	return Objects.hash(artist, playingTime);
    }

    /**
     * Version alternativa del print.
     */
    @Override
    public void print2(PrintStream out) {
	super.print2(out);
	out.println("Artista: " + getArtist());
    }

    /*
     * Obsoleto.
     */
    @Override
    public boolean lsLike(Item item) {

	if (this == item) {
	    return true;
	}

	if (!(item instanceof Cd)) { // Aqui si se puede usar el instaceof
	    return false;
	}

	Cd cd = (Cd) item;

	return cd.getArtist()
	    .equals(this.getArtist())
		&& cd.getTitle()
		    .equals(this.getTitle());
    }

    /**
     * Redefinición del método toString()
     */
    @Override
    public String toString() {
	return super.toString() + "Cd [artist=" + artist + ", numberOfTracks=" + numberOfTracks + ", playingTime="
		+ playingTime + "]";
    }

    /**
     * Método que devuelve el precio con el impuesto.
     */
    @Override
    public double getPrice() {
	return getBasePrice() + TAX;
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