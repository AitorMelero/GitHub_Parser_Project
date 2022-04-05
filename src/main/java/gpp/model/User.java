package gpp.model;

/**
 * 
 * Clase que implementa las características del usuario de la aplicación.
 * 
 * @author Aitor Melero
 *
 */
public class User {

	private String username; // nombre de la cuenta de GitHub
	private String token; // uno de sus token de la cuenta de GitHub

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 * @param username. Nombre de usuario de GitHub.
	 * @param token.    Token generado en la cuenta de GitHub del usuario.
	 */
	public User(String username, String token) {

		this.username = username;
		this.token = token;

	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Getter del username del usuario.
	 * 
	 * @return Username del usuario.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * Getter del token del usuario.
	 * 
	 * @return Token del usuario.
	 */
	public String getToken() {
		return token;
	}

}
