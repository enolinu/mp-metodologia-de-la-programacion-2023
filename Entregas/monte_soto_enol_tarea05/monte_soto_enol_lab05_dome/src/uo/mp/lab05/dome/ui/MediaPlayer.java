package uo.mp.lab05.dome.ui;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Platform;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.service.MediaLibrary;

public class MediaPlayer {

    public void run() {

	int basePrice = 20;

	String theTitle = "Come Together";
	String theArtist = "Beatles";
	int theTime = 70;
	int theTracks = 4;

	String dvdTitle = "La Vida De Brian";
	String dvdDir = "Monty Python";
	int dvdTime = 120;

	String vgTitle = "Mario Party";
	String vgAuthor = "Hudson Soft";
	int vgPlayers = 70;
	Platform vgPlatform = Platform.NINTENDO;

	String bkTitle = "Cronica De Una Muerte Anunciada";
	String bkAuthor = "Gabriel Garcia Marquez";
	String bkEditorial = "Bruguera";
	String bkIsbn = "978-0130449290";

	Cd cd = new Cd(theTitle, theArtist, theTime, theTracks, basePrice);
	Dvd dvd = new Dvd(dvdTitle, dvdDir, dvdTime, basePrice);
	Videogame vg = new Videogame(vgTitle, vgAuthor, vgPlayers, vgPlatform, basePrice);
	Book bk = new Book(bkTitle, bkAuthor, bkEditorial, bkIsbn, basePrice);

	MediaLibrary ml = new MediaLibrary();
	ml.add(cd);
	ml.add(dvd);
	ml.add(vg);
	ml.add(bk);

	System.out.println("Listado De Items: ");
	System.out.println("------------------\n");
	// System.out.println(ml);
	ml.list(System.out);
	// System.out.println("Listado con list2: ");
	// ml.list2(System.out);
	System.out.println("Precio Total: " + ml.getTotalPrice() + "€");
	System.out.println("Código: " + ml.generateCode());

    }

}
