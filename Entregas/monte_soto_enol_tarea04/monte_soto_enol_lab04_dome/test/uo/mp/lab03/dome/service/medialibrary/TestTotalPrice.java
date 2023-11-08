package uo.mp.lab03.dome.service.medialibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.Platform;
import uo.mp.lab03.dome.model.Videogame;
import uo.mp.lab03.dome.service.MediaLibrary;

class TestTotalPrice {

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

	cd = new Cd(theTitle, theArtist, theTime, theTracks, 20);
	dvd = new Dvd(theDvdTitle, theDirector, theDvdTime, 20);
	vg = new Videogame(vgTitle, vgAuthor, vgPlayers, vgPlatform, 10);
	ml = new MediaLibrary();

    }

    /**
     * GIVEN Un solo Dvd en la lista.
     * WHEN Se suman los precios.
     * THEN El precio es el mismo que el precio base del constructor.
     */
    @Test
    public void OneDvdTest() {

	ml.add(dvd);

	assertEquals(20, ml.getItemsForTesting()
	    .get(0)
	    .getBasePrice());
	assertEquals(20, ml.getTotalPrice());

    }

    /**
     * GIVEN Un solo Cd en la lista.
     * WHEN Se suman los precios.
     * THEN El precio es el mismo que el precio base del constructor + 2.
     */
    @Test
    public void OneCdTest() {

	ml.add(cd);

	assertEquals(20, ml.getItemsForTesting()
	    .get(0)
	    .getBasePrice());
	assertEquals(22, ml.getTotalPrice());

    }

    /**
     * GIVEN Un solo Cd en la lista.
     * WHEN Se suman los precios.
     * THEN El precio es el mismo que el precio base del constructor + 10%.
     */
    @Test
    public void OneVgTest() {

	ml.add(vg);

	assertEquals(10, ml.getItemsForTesting()
	    .get(0)
	    .getBasePrice());
	assertEquals(11, ml.getTotalPrice());

    }

}
