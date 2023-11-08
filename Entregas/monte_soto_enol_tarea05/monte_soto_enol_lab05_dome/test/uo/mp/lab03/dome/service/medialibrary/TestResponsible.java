package uo.mp.lab03.dome.service.medialibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Platform;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.service.MediaLibrary;

class TestResponsible {

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
	vg = new Videogame(vgTitle, vgAuthor, vgPlayers, vgPlatform, 20);
	ml = new MediaLibrary();

	ml.add(cd);
	ml.add(dvd);
	ml.add(vg);

    }

    /**
     * GIVEN Una librería con tres items de cada tipo.
     * WHEN Se devuelven los responsables.
     * THEN Aparecen los responsables que corresponden a cada tipo.
     */
    @Test
    void GeneralTest() {

	String responsables = ml.getResponsibles();
	assertEquals(responsables, "Beatles, Monty Python, Hudson Soft, ");

    }

}
