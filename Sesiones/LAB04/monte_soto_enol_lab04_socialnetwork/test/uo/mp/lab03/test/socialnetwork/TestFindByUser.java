package uo.mp.lab03.test.socialnetwork;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.socialnetwork.model.Image;
import uo.mp.lab03.socialnetwork.model.Post;
import uo.mp.lab03.socialnetwork.model.TextMessage;
import uo.mp.lab03.socialnetwork.service.SocialNetwork;

class TestFindByUser {
	
	private SocialNetwork sn;
	private Post manolo1;
	private Post manolo2;
	private Post blasa1;
	private Post blasa2;
	
	@BeforeEach
	public void setup() {
		
		sn = new SocialNetwork();
		manolo1 =  new TextMessage("manolo33", "De cañas.");
		manolo2 =  new TextMessage("manolo33", "Estoy un poco borracho.");
		blasa1 = new Image("blasa_fdez", "geranios.jpg", "Mis geranios.");
		blasa2 = new Image("blasa_fdez", "regando.jpg", "Regando mis geranios.");
		sn.addPost("manolo33", manolo1);
		sn.addPost("manolo33", manolo2);
		sn.addPost("blasa_fdez", blasa1);
		sn.addPost("blasa_fdez", blasa2);
		
	}
	
	/**
	 * GIVEN El usuario "manolo33".
	 * WHEN Se invoca al método findPostsByUser("manolo33").
	 * THEN Devuelve una lista con los posts que publicó "manolo33".
	 */
	@Test
	void ListaCorrectamente() {
		
		ArrayList<Post> filtrado = sn.findPostsByUser("manolo33");
		assertEquals(filtrado.get(0), manolo1);
		assertEquals(filtrado.get(1), manolo2);
		assertEquals(filtrado.size(), 2);
		
		
	}
	
	@Test
	void ListaCorrectamenteVacia() {
		
		ArrayList<Post> filtrado = sn.findPostsByUser("cachelo03");
		assertEquals(filtrado.size(), 0);
		
	}

}
