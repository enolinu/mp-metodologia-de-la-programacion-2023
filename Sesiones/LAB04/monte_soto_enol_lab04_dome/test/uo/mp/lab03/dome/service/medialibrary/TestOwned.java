package uo.mp.lab03.dome.service.medialibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.service.MediaLibrary;

class TestOwned {

    private MediaLibrary ml;
    private Cd cd;
    private Dvd dvd;

    @BeforeEach
    private void setup() {

	String theTitle = "Come Together";
	String theArtist = "Beatles";
	int theTime = 70;
	int theTracks = 4;

	String theDvdTitle = "La Vida De Brian";
	String theDirector = "Monty Python";
	int theDvdTime = 125;

	cd = new Cd(theTitle, theArtist, theTime, theTracks);
	dvd = new Dvd(theDvdTitle, theDirector, theDvdTime);
	ml = new MediaLibrary();

    }

    /**
     * GIVEN Un item con dueño.
     * WHEN Se emite el número de items con dueño.
     * THEN Devuelve 1.
     */
    @Test
    void OwnedOneItemAtLeast() {

	cd.setOwn(true);
	ml.add(cd);
	ml.add(dvd);
	assertEquals(ml.getNumberOfItemsOwned(), 1);

    }

    /**
     * GIVEN Nungún item con dueño.
     * WHEN Se emite el número de items con dueño.
     * THEN Devuelve 0.
     */
    @Test
    void NoneOwned() {

	ml.add(cd);
	ml.add(dvd);
	assertEquals(ml.getNumberOfItemsOwned(), 0);

    }

}
