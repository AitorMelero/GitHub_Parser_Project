package gpp.model;

import java.util.ArrayList;

import gpp.model.search.Search;

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
	private String clonePath; // path donde clonar los repositorios
	private ArrayList<Search> searches; // lista de búsquedas del usuario

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
		this.clonePath = System.getenv("SystemDrive") + "/GitHub_Parser_Project/ " + username + "/gpp-clone-repositories/";
		this.searches = new ArrayList<Search>();

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
	
	/**
	 * 
	 * Devuelve el path donde el usuario clona los repositorios.
	 * 
	 * @return Path donde el usuario clona los repositorios.
	 */
	public String getClonePath() {
		return clonePath;
	}

	/**
	 * 
	 * Modifica el path donde el usuario clona los repositorios.
	 * 
	 * @param clonePath. Path donde el usuario clona los repositorios.
	 */
	public void setClonePath(String clonePath) {
		this.clonePath = clonePath;
	}

	/**
	 * 
	 * Getter de la lista de búsquedas del usuario.
	 * 
	 * @return Lista de búsquedas del usuario.
	 */
	public ArrayList<Search> getSearches() {
		return searches;
	}

	/**
	 * 
	 * Setter de la lista de búsqedas del usuario.
	 * 
	 * @param searches. Nueva lista de búsquedas del usuario.
	 */
	public void setSearches(ArrayList<Search> searches) {
		this.searches = searches;
	}

}
