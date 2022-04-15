package gpp.model.search;

import java.time.LocalDate;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import gpp.model.User;
import gpp.model.github.api.caller.GitHubAPICaller;

/**
 * 
 * Clase que implementa una b�squeda de repositorios de GitHub.
 * 
 * @author Aitor Melero
 *
 */
public class Search {

	private LocalDate date; // fecha de creaci�n de la b�squeda
	private String name; // nombre asignado por el usuario a la b�squeda
	private JsonArray result; // resultado de la b�squeda
	private Query query; // datos de la consulta de la b�squeda
	private User user;  // usuario que realiza la b�squeda

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor de una b�squeda.
	 * 
	 * @param name. Nombre de la b�squeda.
	 * @param user. Usuario que realiza la b�squeda.
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
	 * Devuelve la fecha de la b�squeda.
	 * 
	 * @return Fecha de la b�squeda.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 
	 * Modifica la fecha de la b�squeda.
	 * 
	 * @param date. La fecha a modificar.
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * 
	 * Devuelve el nombre de la b�squeda.
	 * 
	 * @return Nombre de la b�squeda.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Modifica el nombre de la b�squeda.
	 * 
	 * @param name. Nombre a modificar de la b�squeda.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Devuelve el resultado de la b�squeda.
	 * 
	 * @return Resultado de la b�squeda.
	 */
	public JsonArray getResult() {
		return result;
	}

	/**
	 * 
	 * Modifica el resultado de la b�squeda.
	 * 
	 * @param result. Resultado de la b�squeda a modificar.
	 */
	public void setResult(JsonArray result) {
		this.result = result;
	}

	/**
	 * 
	 * Devuelve la query de la b�squeda.
	 * 
	 * @return Query de la b�squeda.
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * 
	 * Modifica la query de la b�squeda.
	 * 
	 * @param query. Query de la b�squeda a modificar.
	 */
	public void setQuery(Query query) {
		this.query = query;
	}
	
	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */
	
	public void search() {
		
		// Realizamos la b�squeda
		query.setRepositoriesMaxNumber("1000");  // 1000 de prueba, BORRAR
		int pagesNumber = 1;
		JsonObject resultQuery =  GitHubAPICaller.searchRepositories(user.getToken(), query.getPath(), "best-match", "desc", 100, pagesNumber);
		int repositoriesMaxNumber = Integer.parseInt(query.getRepositoriesMaxNumber());
		long totalCount = resultQuery.get("total_count").getAsLong();
		result.add(resultQuery);
		
		if (repositoriesMaxNumber > 100 && totalCount > 100) {
			
			// Sacamos el n�mero de p�ginas que necesitamos devolver
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
