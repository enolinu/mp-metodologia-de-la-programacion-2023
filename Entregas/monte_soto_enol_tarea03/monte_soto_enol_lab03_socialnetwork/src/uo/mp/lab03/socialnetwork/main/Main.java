package uo.mp.lab03.socialnetwork.main;

import uo.mp.lab03.socialnetwork.ui.NetworkApp;

/**
 * Clase Main del proyecto "Social Network", que implementa una sencilla red
 * social basada en textos e imágenes.
 * 
 * @author enolmontesoto
 *
 */
public class Main {

	/**
	 * Método principal que lanza la aplicación.
	 * @param args
	 */
	public static void main(String[] args) {
		
		new NetworkApp().simulateClient();

	}

}
