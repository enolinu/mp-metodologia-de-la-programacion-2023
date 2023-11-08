package uo.mp.lab03.socialnetwork.ui;

import uo.mp.lab03.socialnetwork.model.Image;
import uo.mp.lab03.socialnetwork.model.TextMessage;
import uo.mp.lab03.socialnetwork.service.SocialNetwork;

/**
 * Clase que crea una instancia de la clase Social Network, añade posts a la
 * misma, y invoca a uno de sus métodos que los muestra por consola.
 * @author enolmontesoto
 *
 */
public class NetworkApp {
	
	/**
	 * Método que crea una instancia de la clase Social Network, añade posts a la
	 * misma, y invoca a uno de sus métodos que los muestra por consola.
	 */
	public void simulateClient() {
		
		SocialNetwork sn = new SocialNetwork();
		
		sn.addPost("manolo33", new TextMessage("manolo33", "De cañas."));
		sn.addPost("blasa_fdez", new Image("blasa_fdez", "geranios.jpg", "Mis geranios."));
		
		sn.listAllPosts(System.out);
		System.out.println("");
		sn.listHtml(System.out);
		
	}

}
