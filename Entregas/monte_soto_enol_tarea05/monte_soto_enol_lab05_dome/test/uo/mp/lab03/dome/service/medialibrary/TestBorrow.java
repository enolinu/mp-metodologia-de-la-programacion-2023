package uo.mp.lab03.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.service.MediaLibrary;

class TestBorrow {

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
     * WHEN Se presta.
     * THEN Se presta correctamente y se devuelve el libro.
     */
    @Test
    void availableTest() {

	ml.add(bk);
	bk.setOwn(true);

	assertEquals(ml.borrow(bk), bk);
	assertEquals(true, bk.isBorrowed());

    }

    /**
     * GIVEN Un libro no prestado y sin dueño.
     * WHEN Se presta.
     * THEN No se puede prestar, devuelve null.
     */
    @Test
    void notAvailableTest() {

	ml.add(bk);
	bk.setOwn(false);

	assertEquals(null, ml.borrow(bk));
	assertEquals(false, bk.isBorrowed());

    }

    /**
     * GIVEN Un libro con dueño y ya prestado.
     * WHEN Se presta.
     * THEN No se puede prestar, devuelve null.
     */
    @Test
    void alreadyBorrowedTest() {

	ml.add(bk);
	bk.setOwn(true);
	ml.borrow(bk);

	assertEquals(null, ml.borrow(bk));
	assertEquals(true, bk.isBorrowed());

    }

}
