package uo.mp.lab03.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.service.MediaLibrary;

class TestGiveBack {

    private MediaLibrary ml;
    private Book bk;

    @BeforeEach
    private void setup() {

	String bkTitle = "Cronica De Una Muerte Anunciada";
	String bkAuthor = "Gabriel Garcia Marquez";
	String bkEditorial = "Bruguera";
	String bkIsbn = "978-0130449290";

	ml = new MediaLibrary();
	bk = new Book(bkTitle, bkAuthor, bkEditorial, bkIsbn, 20);

    }

    /**
     * GIVEN Un libro no prestado.
     * WHEN Se devuelve.
     * THEN El método devuelve false porue no está prestado.
     */
    @Test
    void availableTest() {

	ml.add(bk);
	bk.setOwn(true);

	assertFalse(ml.giveBack(bk));
	assertFalse(bk.isBorrowed());

    }

    /**
     * GIVEN Un libro con dueño y ya prestado.
     * WHEN Se presta.
     * THEN No se puede prestar, devuelve null.
     */
    @Test
    void correctCaseTest() {

	ml.add(bk);
	bk.setOwn(true);
	ml.borrow(bk);

	assertTrue(ml.giveBack(bk));
	assertEquals(false, bk.isBorrowed());

    }

}
