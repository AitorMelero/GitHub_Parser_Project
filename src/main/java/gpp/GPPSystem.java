package gpp;

import java.awt.Desktop;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.gson.JsonObject;

import gpp.model.User;
import gpp.model.github.api.caller.GitHubAPICaller;
import gpp.model.search.Search;

/**
 * 
 * Clase que representa el sistema de la aplicaci�n.
 * 
 * @author Aitor Melero
 *
 */
public class GPPSystem implements Serializable {

	private static final long serialVersionUID = 1L;
	private static boolean globalSemaphoreTasks;
	private static GPPSystem instance = null;
	private static User user;
	private Search currentSearch; // b�squeda actual a mostrar
	private static int menuButtonSelected;
	private static int searchButtonSelected;
	public static final int BUSCAR = 0, BUSCAR_REPO = 1, FILTRAR_REPO = 2, FILTRAR_LENGUAJE_REPO = 3,
			BUSQUEDAS_GUARDADAS = 4;

	/**************************************************************************
	 * CONSTRUCTOR: PATR�N SINGLETON
	 * ************************************************************************
	 */

	/**
	 * Constructor.
	 */
	private GPPSystem() {

		globalSemaphoreTasks = false;

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
	 * Devuelve el valor del s�maforo global para procesos paralelos.
	 * 
	 * @return Valor del s�maforo global para procesos paralelos.
	 */
	public static boolean isGlobalSemaphoreTasks() {
		return globalSemaphoreTasks;
	}

	/**
	 * 
	 * Modifica el valor del s�maforo global para procesos paralelos.
	 * 
	 * @param globalSemaphoreTasks. Valor del s�maforo global para procesos
	 *                              paralelos.
	 */
	public static void setGlobalSemaphoreTasks(boolean globalSemaphoreTasks) {
		GPPSystem.globalSemaphoreTasks = globalSemaphoreTasks;
	}

	/**
	 * 
	 * Devuelve el usuario actual.
	 * 
	 * @return Usuario actual.
	 */
	public static User getUser() {
		return user;
	}

	/**
	 * 
	 * Modifica el usuario actual.
	 * 
	 * @param user. Nuevo usuario actual.
	 */
	public void setUser(User user) {
		GPPSystem.user = user;
	}

	/**
	 * 
	 * Devuelve la b�squeda actual.
	 * 
	 * @return B�squeda actual.
	 */
	public Search getCurrentSearch() {
		return currentSearch;
	}

	/**
	 * 
	 * Modifica la b�squeda actual.
	 * 
	 * @param currentSearch. Nueva b�squeda actual.
	 */
	public void setCurrentSearch(Search currentSearch) {
		instance.currentSearch = currentSearch;
	}

	/**
	 * 
	 * Devuelve el c�digo del bot�n del men� seleccionado.
	 * 
	 * @return C�digo del men� del bot�n seleccionado.
	 */
	public static int getMenuButtonSelected() {
		return menuButtonSelected;
	}

	/**
	 * 
	 * Modifica el c�digo del bot�n del men� seleccionado.
	 * 
	 * @param menuButtonSelected. C�digo del bot�n del men� seleccionado.
	 */
	public static void setMenuButtonSelected(int menuButtonSelected) {
		GPPSystem.menuButtonSelected = menuButtonSelected;
	}

	/**
	 * 
	 * Devuelve el c�digo del bot�n del men� de b�squeda seleccionado.
	 * 
	 * @return C�digo del bot�n del men� de b�squeda seleccionado.
	 */
	public static int getSearchButtonSelected() {
		return searchButtonSelected;
	}

	/**
	 * 
	 * Modifica el c�digo del bot�n del men� de b�squeda seleccionado.
	 * 
	 * @param searchButtonSelected. C�digo del bot�n del men� de b�squeda
	 *                              seleccionado.
	 */
	public static void setSearchButtonSelected(int searchButtonSelected) {
		GPPSystem.searchButtonSelected = searchButtonSelected;
	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Abre una p�gina web en el navegador por defecto del usuario.
	 * 
	 * @param uri. Uri a la que se accede en el navegador.
	 * @return True si todo fue bien, false en caso contrario.
	 */
	public static boolean openWebpage(URI uri) {

		// url info:
		// https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {

			try {

				desktop.browse(uri);
				return true;

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

		return false;
	}

	/**
	 * 
	 * Abre una p�gina web en el navegador por defecto del usuario.
	 * 
	 * @param url. Url a la que se accede en el navegador.
	 * @return True si todo fue bien, false en caso contrario.
	 */
	public static boolean openWebpage(URL url) {

		// url info:
		// https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
		try {

			return openWebpage(url.toURI());

		} catch (URISyntaxException e) {

			e.printStackTrace();

		}

		return false;
	}

	/**
	 * 
	 * Se encarga del inicio de sesi�n de un usuario.
	 * 
	 * @param token. Token generado en la cuenta de GitHub.
	 * @return True si es correcto el inicio de sesi�n, false en caso contrario.
	 */
	public boolean login(String token) {

		boolean correctLogin = false;
		JsonObject userData = GitHubAPICaller.getTheAuthenticatedUser(token);

		// Comprobamos el inicio de sesi�n
		if (userData.get("error") == null) {

			this.setUser(new User(userData.get("login").getAsString(), token));

			correctLogin = true;

		}

		return correctLogin;

	}

	/**
	 * M�todo para cerrar sesi�n.
	 */
	public void logout() {

	}

}
