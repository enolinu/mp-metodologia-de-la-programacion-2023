package uo.mp.lab03.dome.service.medialibrary;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.Item;
import uo.mp.lab03.dome.model.Platform;
import uo.mp.lab03.dome.model.Videogame;
import uo.mp.lab03.dome.service.MediaLibrary;

class TestAdd {

    private MediaLibrary ml;
    private Cd cd;
    private Dvd dvd;
    private Videogame vg;

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

	cd = new Cd(theTitle, theArtist, theTime, theTracks);
	dvd = new Dvd(theDvdTitle, theDirector, theDvdTime);
	vg = new Videogame(vgTitle, vgAuthor, vgPlayers, vgPlatform);
	ml = new MediaLibrary();

	ml.add(cd);
	ml.add(dvd);
	ml.add(vg);

    }

    /**
     * GIVEN Un CD.
     * WHEN Se añade.
     * THEN Aparece en la lista.
     */
    @Test
    void AddCd() {

	List<Item> contenido = ml.getItemsForTesting();
	assertTrue(contenido.contains(cd));

    }

    /**
     * GIVEN Un CD y un DVD.
     * WHEN Se añaden.
     * THEN Aparecen en la lista.
     */
    @Test
    void AddCdAndDvd() {

	List<Item> contenido = ml.getItemsForTesting();
	assertTrue(contenido.contains(cd));
	assertTrue(contenido.contains(dvd));
	assertTrue(contenido.contains(vg));
	assertEquals(contenido.size(), 3);

    }

    /**
     * GIVEN Un Item nulo.
     * WHEN Se intenta añadir.
     * THEN Salta Excepción.
     */
    @Test
    void AddNull() {

	try {
	    ml.add(null);
	    fail();
	} catch (IllegalArgumentException iae) {
	    assertTrue(true);
	}

    }

}
