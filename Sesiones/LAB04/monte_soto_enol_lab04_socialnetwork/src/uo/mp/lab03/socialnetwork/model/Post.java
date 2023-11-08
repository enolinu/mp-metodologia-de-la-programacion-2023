package uo.mp.lab03.socialnetwork.model;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;

/**
 * Superclase que define aquello que es común para cualquier tipo de post.
 * 
 * @author enolmontesoto
 *
 */
public abstract class Post {
	
	private String user;
	private int likes;
	private List<String> comments = new ArrayList<String>();
	
	/**
	 * Constructor con el parámetro del usuario que lo emite.
	 * @param user
	 */
	public Post(String user) {
		
		setUser(user);
		
		// No haría falta porque los int se inicializan por defecto a cero. 
		this.setLikes(0);
		
	}
	
	/**
	 * Método get del atributo usuario.
	 * @return El usuario que emite el post.
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Método set del usuario.
	 * @param user
	 */
	public void setUser(String user) {	
		validarCampo(user);
		this.user = user;
	}
	
	/**
	 * Método get del número de likes.
	 * @return Numero de likes.
	 */
	public int getLikes() {
		return likes;
	}
	
	// Set de los likes.
	private void setLikes(int likes) {
		this.likes = likes;
	}
	
	/**
	 * Método que añade un comentario a la publicación.
	 * @param comment
	 */
	public void addComment(String comment) {
		this.comments.add(comment);
	}
	
	protected void validarCampo(String campo) {
		
		ArgumentChecks.isTrue((campo != null && !campo.isBlank()),
							   "Este campo no es válido!");
		
	}
	
	public abstract String toString();

}
