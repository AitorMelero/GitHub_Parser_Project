package gpp.model.github.api.caller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

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

	public static final String URL = "https://api.github.com"; // url general de la API
	public static String USER_TOKEN = "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"; // token del usuario

	/**
	 * 
	 * Envía una petición get a la API de GitHub.
	 * 
	 * @param urlPath. Url a enviar la petición.
	 * @return Cadena con el resultado de la petición.
	 */
	public static String sendGetPetition(String urlPath) {

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
				conn.setRequestProperty("Authorization", "token " + USER_TOKEN);

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

				System.out.println("ERROR al crear conexión: " + e.getMessage());

			}

		} catch (MalformedURLException e) {

			// e.printStackTrace();
			System.out.println("ERROR al generar url: " + e.getMessage());

		}

		return cadenaResultado;

	}

	public static String sendPostPetition(String urlPath, Map<String, Object> listParams) {

		URL url;
		Map<String, Object> params = listParams;
		String cadenaResultado = "";

		// creamos la url
		try {

			url = new URL(URL + urlPath);

			// Pasamos los parámetros a una lista de bytes
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, Object> param : params.entrySet()) {

				if (postData.length() != 0)
					postData.append('&');

				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));

			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");

			// Creamos la conexión
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// Indicamos el tipo de la peticion
			conn.setRequestMethod("POST");

			// Metemos el token en la peticion
			conn.setRequestProperty("Authorization", "token " + USER_TOKEN);

			// Metemos el formato a recibir
			conn.setRequestProperty("Accept", "application/vnd.github.v3+json");
			
			//conn.setRequestProperty("Accept-Language", "UTF-8");

			// Longitud de los parámetros
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));

			// Escribimos los parámetros en la petición
			conn.setDoOutput(true);
			conn.getOutputStream().write(postDataBytes);
			/*OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());
	        outputStreamWriter.write(postData.toString());
	        outputStreamWriter.flush();*/

			// Obtenemos la respuesta en el buffer
			BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			// transformamos el buffer en cadena y depues en un objeto JSON
			cadenaResultado = bufferedReaderToString(buffer);

			// Cerramos el buffer
			buffer.close();

		} catch (MalformedURLException e) {

			// e.printStackTrace();
			System.out.println("ERROR al generar url: " + e.getMessage());

		} catch (UnsupportedEncodingException e) {

			// e.printStackTrace();
			System.out.println("ERROR con la codificación: " + e.getMessage());

		} catch (IOException e) {

			// e.printStackTrace();
			System.out.println("ERROR al crear conexión: " + e.getMessage());

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
	 * @param owner.   Nombre del dueño del repositorio.
	 * @param repo.    Nombre del repositorio.
	 * @param perPage. Número de branches devuelto por página, por defecto 30.
	 * @param page.    Número de páginas devueltas, por defecto 1.
	 * @return Branches del repositorio.
	 */
	public static JsonArray listBranches(String owner, String repo, int perPage, int page) {

		// COMPROBAR PAGINAS Y PERPAGINAS
		String url = "/repos/" + owner + "/" + repo + "/branches?per_page=" + perPage + ";page=" + page;
		String resultString = sendGetPetition(url);

		return fromStringToJsonArray(resultString);

	}

	/**********************************************************************************************
	 * USERS
	 * ********************************************************************************************
	 */

	/**
	 * 
	 * Lista los followers de un usuario.
	 * 
	 * @param username. Nombre del usuario.
	 * @param perPage.  Número de seguidores por página, por defecto 30.
	 * @param page.     Número de la página, por defecto 1.
	 * @return Lista de seguidores del usuario.
	 */
	public static JsonArray listFollowersOfAUser(String username, int perPage, int page) {

		String url = "/users/" + username + "/followers?per_page=" + perPage + ";page=" + page;
		String resultString = sendGetPetition(url);

		return fromStringToJsonArray(resultString);

	}

	public static JsonArray listEmailAddresses(int perPage, int page) {

		String url = "/user/emails?per_page=" + perPage + ";page=" + page;
		String resultString = sendGetPetition(url);

		return fromStringToJsonArray(resultString);

	}

	public static JsonArray addAnEmailAddress(ArrayList<String> emails) {

		String url = "/user/emails";
		Map<String, Object> params = new LinkedHashMap<>();

		// Añadimos los parámetros
		params.put("emails", emails);

		// Envíamos la petición post
		String resultString = sendPostPetition(url, params);

		return fromStringToJsonArray(resultString);

	}

	/**********************************************************************************************
	 * REPOSITORIES
	 * ********************************************************************************************
	 */

	public static JsonObject createARepository(String name, String description, boolean isPrivate) {

		String url = "/user/repos";
		Map<String, Object> params = new LinkedHashMap<>();
		
		// Añadimos los parámetros
		params.put("name", name);
		params.put("description", description);
		params.put("private", isPrivate);
		
		String resultString = sendPostPetition(url, params);
		
		return fromStringToJsonObject(resultString);
		
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
		
		JsonObject resultado = new JsonObject();
		
		return resultado.getAsJsonObject(jsonString);
		
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
