package uo.mp.lab03.socialnetwork.model;

/**
 * Clase que define un post de tipo mensaje de texto.
 * @author enolmontesoto
 *
 */
public class TextMessage extends Post {
	
	private String message;
	
	/**
	 * Constructor con los parámeros de usuario y mensaje.
	 * @param user
	 * @param message
	 */
	public TextMessage(String user, String message) {
		
		super(user);
		super.validarCampo(message);
		setMessage(message);
		
	}
	
	/**
	 * Método get del contenido del mensaje.
	 * @return El contenido del mensaje.
	 */
	public String getMessage() {
		return message;
	}
	
	// Método set del mensaje.
	private void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Redefinición del método toString() del mensaje de texto.
	 * @return Cadena con el tipo del post, usuario que lo emite y contenido.
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("TEXTMESSAGE Posted By: " + super.getUser());
		sb.append(", Content: " + getMessage());
		return sb.toString();
		
	}

	@Override
	public String toHtml() {
		return "<p>"+getMessage()+"</p>";
	}

}
