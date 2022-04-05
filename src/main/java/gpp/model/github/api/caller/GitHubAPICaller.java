package gpp.model.github.api.caller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 
 * Clase que implementa todas las llamadas a la API de GitHub.
 * 
 * @author Aitor Melero
 *
 */
public class GitHubAPICaller {

	private static final String URL = "https://api.github.com"; // url general de la API

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Envía una petición get a la API de GitHub.
	 * 
	 * @param urlPath.   Url a enviar la petición.
	 * @param userToken. Token del usuario actual.
	 * @return Cadena con el resultado de la petición.
	 */
	public static String sendGetPetition(String urlPath, String userToken) {

		URL url;
		HttpURLConnection conn;
		BufferedReader buffer = null;
		String cadenaResultado = "";

		try {
			// creamos la url
			url = new URL(URL + urlPath);

			try {

				// creamos la conexion con el servidor
				conn = (HttpURLConnection) url.openConnection();

				// indicamos el tipo de la peticion
				conn.setRequestMethod("GET");

				// metemos el token en la peticion
				conn.setRequestProperty("Authorization", "token " + userToken);

				// metemos el formato a recibir
				conn.setRequestProperty("Accept", "application/vnd.github.v3+json");

				// guardamos la respuesta en el buffer
				buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				// sacamos el número de peticiones que nos quedan en la hora
				// String numPeticiones = conn.getHeaderField("X-RateLimit-Remaining");

				// transformamos el buffer en cadena y depues en un objeto JSON
				cadenaResultado = bufferedReaderToString(buffer);

				// cerramos la conexion
				buffer.close();

			} catch (IOException e) {

				cadenaResultado = "{\"error\": \"" + e.getMessage() + "\"}";

			}

		} catch (MalformedURLException e) {

			// e.printStackTrace();
			System.out.println("ERROR al generar url: " + e.getMessage());

		}

		return cadenaResultado;

	}

	/**********************************************************************************************
	 * BRANCHES
	 * ********************************************************************************************
	 */

	/**
	 * 
	 * Devuelve la lista de branches de un repositorio.
	 * 
	 * @param token.   Token del usuario.
	 * @param owner.   Nombre del dueño del repositorio.
	 * @param repo.    Nombre del repositorio.
	 * @param perPage. Número de branches devuelto por página, por defecto 30.
	 * @param page.    Número de páginas devueltas, por defecto 1.
	 * @return Branches del repositorio.
	 */
	public static JsonArray listBranches(String token, String owner, String repo, int perPage, int page) {

		String url = "/repos/" + owner + "/" + repo + "/branches?per_page=" + perPage + ";page=" + page;
		String resultString = sendGetPetition(url, token);

		return fromStringToJsonArray(resultString);

	}

	/**********************************************************************************************
	 * USERS
	 * ********************************************************************************************
	 */

	/**
	 * 
	 * Devuelve el usuario a partir de su token.
	 * 
	 * @param token. Token del usuario.
	 * @return Usuario actual.
	 */
	public static JsonObject getTheAuthenticatedUser(String token) {

		String url = "/user";

		return fromStringToJsonObject(sendGetPetition(url, token));

	}

	/**
	 * 
	 * Lista los followers de un usuario.
	 * 
	 * @param token.    Token del usuario.
	 * @param username. Nombre del usuario.
	 * @param perPage.  Número de seguidores por página, por defecto 30.
	 * @param page.     Número de la página, por defecto 1.
	 * @return Lista de seguidores del usuario.
	 */
	public static JsonArray listFollowersOfAUser(String token, String username, int perPage, int page) {

		String url = "/users/" + username + "/followers?per_page=" + perPage + ";page=" + page;
		String resultString = sendGetPetition(url, token);

		return fromStringToJsonArray(resultString);

	}

	/**
	 * 
	 * Devuelve la lista de correos del usuario actual.
	 * 
	 * @param token.   Token del usuario.
	 * @param perPage. Correos por página.
	 * @param page.    Número de página a mostrar.
	 * @return Lista de correos del usuario actual del número correspondiente de
	 *         página.
	 */
	public static JsonArray listEmailAddresses(String token, int perPage, int page) {

		String url = "/user/emails?per_page=" + perPage + ";page=" + page;
		String resultString = sendGetPetition(url, token);

		return fromStringToJsonArray(resultString);

	}

	/**********************************************************************************************
	 * AUX TRANSFORMER PRIVATE METHODS
	 * ********************************************************************************************
	 */

	/**
	 * 
	 * Transforma una cadena en una lista de objetos JSON.
	 * 
	 * @param jsonString. Cadena con la lista de objetos JSON.
	 * @return Lista de objetos JSON.
	 */
	private static JsonArray fromStringToJsonArray(String jsonString) {

		JsonArray resultado = new Gson().fromJson(jsonString, JsonArray.class);

		return resultado;

	}

	/**
	 * 
	 * Transforma una cadena en un objeto JSON.
	 * 
	 * @param jsonString. Cadena con el resultado en JSON.
	 * @return Objecto JSON con el resultado.
	 */
	private static JsonObject fromStringToJsonObject(String jsonString) {

		JsonObject resultado = new Gson().fromJson(jsonString, JsonObject.class);

		return resultado;

	}

	/**
	 * 
	 * Transforma un elemento de tipo BufferedReader a String.
	 * 
	 * @param buffer. Objeto a transformar.
	 * @return Objeto buffer transformado a tipo String.
	 * @throws IOException
	 */
	private static String bufferedReaderToString(BufferedReader buffer) throws IOException {

		String linea;
		StringBuilder resultado = new StringBuilder();

		// agregamos contenido a la cadena mientras se lee el buffer
		while ((linea = buffer.readLine()) != null) {
			resultado.append(linea);
		}

		// devolvemos la cadena
		return resultado.toString();

	}

}
