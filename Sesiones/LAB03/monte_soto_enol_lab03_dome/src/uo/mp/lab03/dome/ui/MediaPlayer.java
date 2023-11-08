package uo.mp.lab03.dome.ui;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.service.MediaLibrary;

public class MediaPlayer {

    public void run() {

	String theTitle = "Come Together";
	String theArtist = "Beatles";
	int theTime = 70;
	int theTracks = 4;

	Cd cd = new Cd(theTitle, theArtist, theTime, theTracks);
	MediaLibrary ml = new MediaLibrary();
	ml.add(cd);
	ml.list(System.out);

    }

}
