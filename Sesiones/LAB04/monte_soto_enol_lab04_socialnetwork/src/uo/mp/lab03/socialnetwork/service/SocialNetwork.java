package uo.mp.lab03.socialnetwork.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab03.socialnetwork.model.Post;

/**
 * Clase de servicio que almanena, ordena y gestiona los posts.
 * 
 * @author enolmontesoto
 *
 */
public class SocialNetwork {
	
	List<Post> posts = new ArrayList<Post>(); 
	
	public List<Post> getPostsForTesting() {
		
		List<Post> aux = new ArrayList<Post>();
		
		for(Post p: posts) {
			aux.add(p);
		}
		
		return aux;
		
	}
	
	/**
	 * Método que añade un post a la lista.
	 * @param user
	 * @param post
	 */
	public void addPost(String user, Post post) {
		
		ArgumentChecks.isTrue(post != null, "Se pasó un post nulo.");
		post.setUser(user);
		posts.add(post);
		
	}
	
	/**
	 * Método que muestra por pantalla todos los posts.
	 * @param out
	 */
	public void listAllPosts(PrintStream out) {
		
		for(Post post: posts) {
			out.println(post);
		}
		
	}
	
	/**
	 * Método que devuelvve todos los posts de un determinado usuario que se le
	 * pase como parámetro.
	 * @param userId
	 * @return Lista con los post que publicó el usuario.
	 */
	public ArrayList<Post> findPostsByUser(String userId) {
		
		ArrayList<Post> aux = new ArrayList<Post>();
		
		for(Post post: posts) {
			if(post.getUser().equals(userId)) {
				aux.add(post);
			}
		}
		
		return aux;
		
	}
	
	

}
