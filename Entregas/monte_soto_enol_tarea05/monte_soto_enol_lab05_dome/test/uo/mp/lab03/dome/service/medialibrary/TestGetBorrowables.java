package uo.mp.lab03.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Platform;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.service.MediaLibrary;

class TestGetBorrowables {

    private MediaLibrary ml;
    private Cd cd;
    private Dvd dvd;
    private Videogame vg;
    private Book bk;

    @BeforeEach
    private void setup() {

	String theTitle = "Come Together";
	String theArtist = "Beatles";
	int theTime = 70;
	int theTracks = 4;

	String theDvdTitle = "La Vida De Brian";
	String theDirector = "Monty Python";
	int theDvdTime = 125;

	String vgTitle = "Mario Party";
	String vgAuthor = "Hudson Soft";
	int vgPlayers = 70;
	Platform vgPlatform = Platform.NINTENDO;

	String bkTitle = "Cronica De Una Muerte Anunciada";
	String bkAuthor = "Gabriel Garcia Marquez";
	String bkEditorial = "Bruguera";
	String bkIsbn = "978-0130449290";

	cd = new Cd(theTitle, theArtist, theTime, theTracks, 20);
	dvd = new Dvd(theDvdTitle, theDirector, theDvdTime, 20);
	vg = new Videogame(vgTitle, vgAuthor, vgPlayers, vgPlatform, 20);
	ml = new MediaLibrary();
	bk = new Book(bkTitle, bkAuthor, bkEditorial, bkIsbn, 20);

    }

    /**
     * GIVEN Una lista de items.
     * WHEN No hay ninguno prestable y se invoca a getBorrowables()
     * THEN Devuelve la cadena vacía.
     */
    @Test
    void noBorrowablesTest() {

	ml.add(dvd);
	ml.add(vg);

	assertEquals("", ml.getBorrowables());

    }

    /**
     * GIVEN Una lista de items.
     * WHEN Solo hay prestables y se invoca a getBorrowables()
     * THEN Devuelve la cadena con los prestables.
     */
    @Test
    void onlyBorrowablesTest() {

	ml.add(cd);
	ml.add(bk);

	assertTrue(ml.getBorrowables()
	    .contains(cd.toString()));
	assertTrue(ml.getBorrowables()
	    .contains(bk.toString()));

    }

    /**
     * GIVEN Una lista de items.
     * WHEN Hay prestables y no prestables y se invoca a getBorrowables()
     * THEN Devuelve la cadena con los prestables.
     */
    @Test
    void mixedItemsTest() {

	ml.add(cd);
	ml.add(dvd);
	ml.add(vg);
	ml.add(bk);

	assertTrue(ml.getBorrowables()
	    .contains(cd.toString()));
	assertTrue(ml.getBorrowables()
	    .contains(bk.toString()));
	assertFalse(ml.getBorrowables()
	    .contains(dvd.toString()));
	assertFalse(ml.getBorrowables()
	    .contains(vg.toString()));

    }

}
