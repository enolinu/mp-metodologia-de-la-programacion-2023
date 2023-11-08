package uo.mp.lab03.socialnetwork.model;

/**
 * Clase que define un post de tipo imagen.
 * 
 * @author enolmontesoto
 */
public class Image extends Post {

	private final String filename;
	private String caption;
	
	/**
	 * Método constructor con los tres parámetros siguientes.
	 * @param user
	 * @param filename
	 * @param caption
	 */
	public Image(String user, String filename, String caption) {
		
		super(user);
		super.validarCampo(filename);
		super.validarCampo(caption);
		this.filename = filename;
		setCaption(caption);
		
	}
	
	/**
	 * Método get del nombre del fichero.
	 * @return El nombre del fichero.
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Método get de la descripción.
	 * @return La descripción.
	 */
	public String getCaption() {
		return caption;
	}

	private void setCaption(String caption) {
		this.caption = caption;
	}
	
	/**
	 * Redefinición del método toString() para posts de tipo Imagen.
	 * @return Una cadena con todos los campos de la imagen.
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("IMAGE Posted By: " + super.getUser());
		sb.append(", File: " + getFilename());
		sb.append(", Caption: " + getCaption());
		return sb.toString();
		
	}

}
