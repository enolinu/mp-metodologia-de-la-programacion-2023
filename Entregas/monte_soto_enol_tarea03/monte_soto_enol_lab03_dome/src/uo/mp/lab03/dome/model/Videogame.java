package uo.mp.lab03.dome.model;

import java.io.PrintStream;

/**
 * Clase que define un item de tipo videojuego.
 * 
 * @author enolmontesoto
 *
 */
public class Videogame extends Item {

    private String author;
    private int numPlayers;
    private Platform platform;

    /**
     * Constructor con los parámetros citados.
     * 
     * @param theTitle
     * @param author
     * @param numPlayers
     * @param platform
     */
    public Videogame(String theTitle, String author, int numPlayers, Platform platform) {

	super(theTitle);
	setAuthor(author);
	setNumPlayers(numPlayers);
	setPlatform(platform);

    }

    /**
     * Método get de autor.
     * 
     * @return El autor.
     */
    public String getAuthor() {
	return author;
    }

    private void setAuthor(String author) {
	this.author = author;
    }

    /**
     * Get numero jugadores.
     * 
     * @return
     */
    public int getNumPlayers() {
	return numPlayers;
    }

    private void setNumPlayers(int numPlayers) {
	this.numPlayers = numPlayers;
    }

    /**
     * Método get de la plataforma.
     * 
     * @return La Plataforma.
     */
    public Platform getPlatform() {
	return platform;
    }

    private void setPlatform(Platform platform) {
	this.platform = platform;
    }

    /**
     * Muestra por pantalla todos los datos.
     */
    public void print(PrintStream out) {
	out.println("Videogame: " + getTitle());
	out.println("Author: " + getAuthor());
	out.println("Players: " + getNumPlayers());
	out.println("Platform: " + getPlatform());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
    }

    /**
     * Redefinición del método "equals" para items tipo Videogame.
     */
    @Override
    public boolean equals(Item item) {

	if (item == this) {
	    return true;
	}

	if (!(item instanceof Videogame)) {
	    return false;
	}
	Videogame vg = (Videogame) item;
	return vg.getTitle()
	    .equals(this.getTitle())
		&& vg.getAuthor()
		    .equals(this.getAuthor())
		&& vg.getPlatform() == this.getPlatform() && vg.getNumPlayers() == this.getNumPlayers();
    }

    /**
     * Método redefinido que devuelve el autor del videojuego.
     * 
     * @return El autor.
     */
    @Override
    public String getResponsible() {

	return this.author;

    }

}
