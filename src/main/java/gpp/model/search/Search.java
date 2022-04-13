package gpp.model.search;

import java.time.LocalDate;

import com.google.gson.JsonArray;

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

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor de una b�squeda.
	 * 
	 * @param name. Nombre de la b�squeda.
	 */
	public Search(String name) {

		date = LocalDate.now();
		this.name = name;
		result = new JsonArray();
		query = new Query();

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

}
