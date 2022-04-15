package gpp.model.search;

import java.time.LocalDate;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import gpp.model.User;
import gpp.model.github.api.caller.GitHubAPICaller;

/**
 * 
 * Clase que implementa una búsqueda de repositorios de GitHub.
 * 
 * @author Aitor Melero
 *
 */
public class Search {

	private LocalDate date; // fecha de creación de la búsqueda
	private String name; // nombre asignado por el usuario a la búsqueda
	private JsonArray result; // resultado de la búsqueda
	private Query query; // datos de la consulta de la búsqueda
	private User user;  // usuario que realiza la búsqueda

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor de una búsqueda.
	 * 
	 * @param name. Nombre de la búsqueda.
	 * @param user. Usuario que realiza la búsqueda.
	 */
	public Search(String name, User user) {

		date = LocalDate.now();
		this.name = name;
		result = new JsonArray();
		query = new Query();
		this.user = user;

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve la fecha de la búsqueda.
	 * 
	 * @return Fecha de la búsqueda.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 
	 * Modifica la fecha de la búsqueda.
	 * 
	 * @param date. La fecha a modificar.
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * 
	 * Devuelve el nombre de la búsqueda.
	 * 
	 * @return Nombre de la búsqueda.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Modifica el nombre de la búsqueda.
	 * 
	 * @param name. Nombre a modificar de la búsqueda.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Devuelve el resultado de la búsqueda.
	 * 
	 * @return Resultado de la búsqueda.
	 */
	public JsonArray getResult() {
		return result;
	}

	/**
	 * 
	 * Modifica el resultado de la búsqueda.
	 * 
	 * @param result. Resultado de la búsqueda a modificar.
	 */
	public void setResult(JsonArray result) {
		this.result = result;
	}

	/**
	 * 
	 * Devuelve la query de la búsqueda.
	 * 
	 * @return Query de la búsqueda.
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * 
	 * Modifica la query de la búsqueda.
	 * 
	 * @param query. Query de la búsqueda a modificar.
	 */
	public void setQuery(Query query) {
		this.query = query;
	}
	
	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */
	
	public void search() {
		
		// Realizamos la búsqueda
		query.setRepositoriesMaxNumber("1000");  // 1000 de prueba, BORRAR
		int pagesNumber = 1;
		JsonObject resultQuery =  GitHubAPICaller.searchRepositories(user.getToken(), query.getPath(), "best-match", "desc", 100, pagesNumber);
		int repositoriesMaxNumber = Integer.parseInt(query.getRepositoriesMaxNumber());
		long totalCount = resultQuery.get("total_count").getAsLong();
		result.add(resultQuery);
		
		if (repositoriesMaxNumber > 100 && totalCount > 100) {
			
			// Sacamos el número de páginas que necesitamos devolver
			if (totalCount >= repositoriesMaxNumber) {
				
				pagesNumber = repositoriesMaxNumber / 100;
				
				if (repositoriesMaxNumber % 100 != 0) {
					
					pagesNumber++;
					
				}
				
			} else {
				
				pagesNumber = (int) (totalCount / 100);
				
				if (totalCount % 100 != 0) {
					
					pagesNumber++;
					
				}
				
			}
			
			// Vamos guardando los resultados
			for (int i = 1; i < pagesNumber; i++) {
				
				resultQuery = GitHubAPICaller.searchRepositories(user.getToken(), query.getPath(), "best-match", "desc", 100, i+1);
				result.add(resultQuery);
				
			}
			
		}
		
	}

}
