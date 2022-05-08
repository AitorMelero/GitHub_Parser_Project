package gpp;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import gpp.model.User;
import gpp.model.github.api.caller.GitHubAPICaller;
import gpp.model.search.Search;

/**
 * 
 * Clase que representa el sistema de la aplicación.
 * 
 * @author Aitor Melero
 *
 */
public class GPPSystem implements Serializable {

	private static final long serialVersionUID = 1L;
	private static boolean globalSemaphoreTasks;
	private static GPPSystem instance = null;
	private static User user;
	private Search currentSearch; // búsqueda actual a mostrar
	private static ArrayList<Search> searchesSavedList; // lista de búsquedas guardadas
	private static int menuButtonSelected;
	private static int searchButtonSelected;
	public static final int BUSCAR = 0, BUSCAR_REPO = 1, FILTRAR_REPO = 2, FILTRAR_LENGUAJE_REPO = 3,
			BUSQUEDAS_GUARDADAS = 4;

	/**************************************************************************
	 * CONSTRUCTOR: PATRÓN SINGLETON
	 * ************************************************************************
	 */

	/**
	 * Constructor.
	 */
	private GPPSystem() {

		globalSemaphoreTasks = false;
		searchesSavedList = new ArrayList<Search>();

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
	 * Devuelve el valor del sémaforo global para procesos paralelos.
	 * 
	 * @return Valor del sémaforo global para procesos paralelos.
	 */
	public static boolean isGlobalSemaphoreTasks() {
		return globalSemaphoreTasks;
	}

	/**
	 * 
	 * Modifica el valor del sémaforo global para procesos paralelos.
	 * 
	 * @param globalSemaphoreTasks. Valor del sémaforo global para procesos
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
	 * Devuelve la búsqueda actual.
	 * 
	 * @return Búsqueda actual.
	 */
	public Search getCurrentSearch() {
		return currentSearch;
	}

	/**
	 * 
	 * Modifica la búsqueda actual.
	 * 
	 * @param currentSearch. Nueva búsqueda actual.
	 */
	public void setCurrentSearch(Search currentSearch) {
		currentSearch.setCurrentPageNumber(1);
		instance.currentSearch = currentSearch;
	}

	/**
	 * 
	 * Devuelve la lista de búsquedas guardadas.
	 * 
	 * @return Lista de búsquedas guardadas.
	 */
	public ArrayList<Search> getSearchesSavedList() {
		return searchesSavedList;
	}

	/**
	 * 
	 * Modifica la lista de búsquedas guardadas.
	 * 
	 * @param searchesSavedList. Lista de búsquedas guardadas.
	 */
	public void setSearchesSavedList(ArrayList<Search> searchesSavedList) {
		this.searchesSavedList = searchesSavedList;
	}

	/**
	 * 
	 * Devuelve el código del botón del menú seleccionado.
	 * 
	 * @return Código del menú del botón seleccionado.
	 */
	public static int getMenuButtonSelected() {
		return menuButtonSelected;
	}

	/**
	 * 
	 * Modifica el código del botón del menú seleccionado.
	 * 
	 * @param menuButtonSelected. Código del botón del menú seleccionado.
	 */
	public static void setMenuButtonSelected(int menuButtonSelected) {
		GPPSystem.menuButtonSelected = menuButtonSelected;
	}

	/**
	 * 
	 * Devuelve el código del botón del menú de búsqueda seleccionado.
	 * 
	 * @return Código del botón del menú de búsqueda seleccionado.
	 */
	public static int getSearchButtonSelected() {
		return searchButtonSelected;
	}

	/**
	 * 
	 * Modifica el código del botón del menú de búsqueda seleccionado.
	 * 
	 * @param searchButtonSelected. Código del botón del menú de búsqueda
	 *                              seleccionado.
	 */
	public static void setSearchButtonSelected(int searchButtonSelected) {
		GPPSystem.searchButtonSelected = searchButtonSelected;
	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Abre una página web en el navegador por defecto del usuario.
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
	 * Abre una página web en el navegador por defecto del usuario.
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

			// Creamos los resultados de las búsquedas ya guardadas
			BufferedReader br = null;
			String datos = System.getenv("SystemDrive") + "/GitHub_Parser_Project/" + user.getUsername() + "/searches/";
			File f;
			
			// Reseteamos la lista de búsquedas guardadas
			searchesSavedList = new ArrayList<Search>();

			try {

				// Creamos el directorio
				f = new File(datos);
				if (f.exists()) {
					
					String line;
					String jsonString;

					for (File fs: f.listFiles()) {
						
						br = new BufferedReader(new FileReader(fs));
						line = br.readLine();
						jsonString = "";
						
						while(line != null) {
							
							jsonString += line;
							line = br.readLine();
							
						}
						
						searchesSavedList.add(new Search(JsonParser.parseString(jsonString).getAsJsonObject()));
						
					}
					
					if (br != null) {
						br.close();
						br = null;
					}
					
				}

			} catch (IOException e) {
				System.out.println("Error de entrada/salida. " + e);
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

		return correctLogin;

	}

	/**
	 * Método para cerrar sesión.
	 */
	public void logout() {

	}

	/**
	 * 
	 * Guarda los resultados de las búsquedas en formato json.
	 * 
	 * @throws IOException Error entrada/salida
	 */
	public void saveData() throws IOException {

		BufferedWriter bw = null;
		String datos = System.getenv("SystemDrive") + "/GitHub_Parser_Project/" + user.getUsername() + "/searches/";
		String searchPath = "";
		File f;
		GsonBuilder builder;
		Gson gson;

		try {

			// Creamos el directorio
			f = new File(datos);
			if (!f.exists()) {
				f.mkdirs();
			}
			// Guardamos las búsquedas
			for (Search s : searchesSavedList) {

				searchPath = s.getId() + ".json";
				f = new File(datos + searchPath);
				if (!f.exists()) {

					// Guardamos el json de las búsquedas
					builder = new GsonBuilder();
					builder.setPrettyPrinting();
					gson = builder.create();
					bw = new BufferedWriter(new FileWriter(f));
					bw.write(gson.toJson(s.infoSearchToJsonObject()));

					if (bw != null) {
						bw.close();
						bw = null;
					}

				}

			}

		} catch (IOException e) {
			System.out.println("Error de entrada/salida. " + e);
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}

	/**
	 * 
	 * Saca el id más alto de todas las búsquedas guardadas.
	 * 
	 * @return Id más alto de todas las búsquedas guardadas.
	 */
	public static long getMaxIdSearchesSaved() {

		long idMax = -1;

		for (Search s : searchesSavedList) {

			if (s.getId() > idMax) {

				idMax = s.getId();

			}

		}
		
		idMax++;

		return idMax;

	}

}
