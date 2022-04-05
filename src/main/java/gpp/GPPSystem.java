package gpp;

import java.io.Serializable;

import com.google.gson.JsonObject;

import gpp.model.User;
import gpp.model.github.api.caller.GitHubAPICaller;

/**
 * 
 * Clase que representa el sistema de la aplicación.
 * 
 * @author Aitor Melero
 *
 */
public class GPPSystem implements Serializable {

	private static final long serialVersionUID = 1L;
	private static GPPSystem instance = null;
	private User user;

	/**************************************************************************
	 * CONSTRUCTOR: PATRÓN SINGLETON
	 * ************************************************************************
	 */

	/**
	 * Constructor.
	 */
	private GPPSystem() {

	}

	/**
	 * Crea o devuelve la instancia del sistema.
	 */
	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new GPPSystem();
		}
	}

	/**
	 * 
	 * Devuelve la instancia del sistema.
	 * 
	 * @return Instancia del sistema.
	 */
	public static GPPSystem getInstance() {
		if (instance == null)
			createInstance();
		return instance;
	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el usuario actual.
	 * 
	 * @return Usuario actual.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * Modifica el usuario actual.
	 * 
	 * @param user. Nuevo usuario actual.
	 */
	public void setUser(User user) {
		instance.user = user;
	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Se encarga del inicio de sesión de un usuario.
	 * 
	 * @param token. Token generado en la cuenta de GitHub.
	 * @return True si es correcto el inicio de sesión, false en caso contrario.
	 */
	public boolean login(String token) {

		boolean correctLogin = false;
		JsonObject userData = GitHubAPICaller.getTheAuthenticatedUser(token);

		// Comprobamos el inicio de sesión
		if (userData.get("error") == null) {

			this.setUser(new User(userData.get("login").getAsString(), token));

			correctLogin = true;

		} else {

			System.out.println("Ups, ha ocurrido un error.");

		}

		return correctLogin;

	}

}
