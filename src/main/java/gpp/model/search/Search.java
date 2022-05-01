package gpp.model.search;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import gpp.model.Repository;
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
	private User user; // usuario que realiza la b�squeda
	private ArrayList<Repository> listRepoResult; // lista de repositorios del resultado
	private int currentPageNumber; // n�mero actual de la p�gina del resultado actual

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
		this.listRepoResult = new ArrayList<Repository>();
		this.currentPageNumber = -1;

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

	/**
	 * 
	 * Devuelve la lista de repositorios del resultado de la b�squeda.
	 * 
	 * @return Lista de repositorios devueltos en la b�squeda.
	 */
	public ArrayList<Repository> getListRepoResult() {
		return listRepoResult;
	}

	/**
	 * 
	 * Modifica la lista de repositorios devuelta en la b�squeda.
	 * 
	 * @param listRepoResult. Lista de repositorios devuelta en la b�squeda.
	 */
	public void setListRepoResult(ArrayList<Repository> listRepoResult) {
		this.listRepoResult = listRepoResult;
	}

	/**
	 * 
	 * Devuelve el n�mero actual de la p�gina a mostrar.
	 * 
	 * @return N�mero de p�gina actual a mostrar.
	 */
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	/**
	 * 
	 * Modifica el n�mero de p�gina a mostrar.
	 * 
	 * @param currentPageNumber. N�mero de p�gina a mostrar.
	 */
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Realiza la b�squeda de repositorios llamando a la API de GitHub seg�n los
	 * par�metros introducidos.
	 * 
	 */
	public void search() {

		// Variables para las p�ginas
		int pagesNumber = 1;
		int maxRepositoriesToSearch = 0;
		int repositoriesSearched = 0;
		int repositoriesMaxNumber = Integer.parseInt(query.getRepositoriesMaxNumber());
		int perPage = 100;
		if (repositoriesMaxNumber < 100) {

			perPage = repositoriesMaxNumber;

		}

		// Realizamos la b�squeda
		JsonObject resultQuery = GitHubAPICaller.searchRepositories(user.getToken(), query.getPath(),
				query.getSortOption(), query.getOrderOption(), perPage, pagesNumber);

		// Comprobamos si hay resultados
		JsonArray resultRepos = new JsonArray();
		if (!resultQuery.get("items").isJsonNull()) {

			resultRepos = resultQuery.get("items").getAsJsonArray();

		}

		// Calculamos los repositorios encontrados
		long totalCount = resultQuery.get("total_count").getAsLong();
		if (totalCount > repositoriesMaxNumber) {

			maxRepositoriesToSearch = repositoriesMaxNumber;

		} else {

			maxRepositoriesToSearch = (int) totalCount;

		}

		if (totalCount < perPage) {

			repositoriesSearched += totalCount;

		} else {

			repositoriesSearched += perPage;

		}

		// Guardamos los resultados de la primera p�gina
		setCurrentPageNumber(1);
		result.add(resultQuery);
		createRepositoriesFromResult(resultRepos);

		// Modificamos el n�mero de p�ginas a devolver
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

				// Sacamos el n�mero de repositorios por p�gina
				if ((maxRepositoriesToSearch - repositoriesSearched) < 100) {

					perPage = (maxRepositoriesToSearch - repositoriesSearched);

				}

				resultQuery = GitHubAPICaller.searchRepositories(user.getToken(), query.getPath(),
						query.getSortOption(), query.getOrderOption(), perPage, i + 1);
				resultRepos = resultQuery.get("items").getAsJsonArray();

				// Guardamos los resultados
				result.add(resultQuery);
				createRepositoriesFromResult(resultRepos);

			}

		}

	}

	/**
	 * 
	 * Filtra la lista de repositorios en funci�n de los filtros introducidos.
	 * 
	 */
	public void filter() {

		int i = 1;

		// listRepoResult.get(3).generateFullInfo();

		for (Repository r : listRepoResult) {

			System.out.println("Clonando " + i + " de " + listRepoResult.size());

			r.generateFullInfo();

			i++;

		}

	}

	/**
	 * 
	 * Recorre la lista de repositorios devueltos por la consulta a la API para ir
	 * creando dichos repositorios.
	 * 
	 * @param resultRepos. Lista de objetos JSON con la representaci�n de los
	 *                     repositorios devueltos.
	 */
	private void createRepositoriesFromResult(JsonArray resultRepos) {

		Repository repoResult;
		for (JsonElement re : resultRepos) {

			// Sacamos la informaci�n que nos proporciona la API
			JsonObject ro = (JsonObject) re;
			String ownerName = ro.get("full_name").getAsString().split("/")[0];
			String repoName = ro.get("name").getAsString();
			String description = "";
			if (!ro.get("description").isJsonNull()) {
				description = ro.get("description").getAsString();
			}
			long starsNumber = ro.get("stargazers_count").getAsLong();
			long forksNumber = ro.get("forks_count").getAsLong();
			long watchersNumber = ro.get("watchers_count").getAsLong();
			JsonObject license = null;
			String licenseString = "";
			if (!ro.get("license").isJsonNull()) {
				license = ro.get("license").getAsJsonObject();
				String licenseId = license.get("spdx_id").getAsString();
				if (!licenseId.equals("NOASSERTION")) {
					licenseString = licenseId + " license";
				}
			}
			String dateCreated = ro.get("created_at").getAsString().split("T")[0];
			String dateUpdated = ro.get("pushed_at").getAsString().split("T")[0];
			JsonElement topics = ro.get("topics");
			Type listType = new TypeToken<ArrayList<String>>() {
			}.getType();
			ArrayList<String> topicsList = new Gson().fromJson(topics, listType);
			long totalSize = ro.get("size").getAsLong();
			String mainLanguage = null;
			if (!ro.get("language").isJsonNull()) {
				mainLanguage = ro.get("language").getAsString();
			}

			// A�adimos la informaci�n obtenida al repositorio
			repoResult = new Repository(ownerName, repoName);
			repoResult.setDescription(description);
			repoResult.setStarsNumber(starsNumber);
			repoResult.setForksNumber(forksNumber);
			repoResult.setWatchersNumber(watchersNumber);
			repoResult.setLicense(licenseString);
			repoResult.setDateCreated(dateCreated);
			repoResult.setDateUpdated(dateUpdated);
			repoResult.setTopics(topicsList);
			repoResult.setTotalSize(totalSize);
			repoResult.setMainLanguage(mainLanguage);
			listRepoResult.add(repoResult);

		}

	}

}
