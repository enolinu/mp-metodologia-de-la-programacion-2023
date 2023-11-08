package uo.mp.lab03.test.socialnetwork;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.socialnetwork.model.Image;
import uo.mp.lab03.socialnetwork.model.Post;
import uo.mp.lab03.socialnetwork.model.TextMessage;
import uo.mp.lab03.socialnetwork.service.SocialNetwork;

class TestAdd {
	
	private SocialNetwork sn;
	private Post msp;
	private Post imp;
	
	@BeforeEach
	public void setup() {
		
		sn = new SocialNetwork();
		msp =  new TextMessage("manolo33", "De cañas.");
		imp = new Image("blasa_fdez", "geranios.jpg", "Mis geranios.");
		
	}
	
	/**
	 * GIVEN Un mensaje de texto.
	 * WHEN Se añade.
	 * THEN Se añade correctamente.
	 */
	@Test
	void addedMessageCorrectly() {
		
		sn.addPost("manolo33", msp);
		List<Post> posts = sn.getPostsForTesting();
		assertTrue(posts.contains(msp));
		
	}
	
	/**
	 * GIVEN Una imagen.
	 * WHEN Se añade.
	 * THEN Se añade correctamente.
	 */
	@Test
	void addedImageCorrectly() {
		
		sn.addPost("manolo33", msp);
		sn.addPost("blasa_fdez", imp);
		List<Post> posts = sn.getPostsForTesting();
		assertTrue(posts.contains(msp));
		assertTrue(posts.contains(imp));
		
	}
	
	/**
	 * GIVEN Un parametro nulo.
	 * WHEN Se intenta añadir.
	 * THEN Salta excepcion.
	 */
	@Test
	void nullPost() {
		
		try {
			sn.addPost("cachelo03", null);
			fail();
		} catch(IllegalArgumentException iae) {
			assertTrue(true);
		}
		
	}

}
