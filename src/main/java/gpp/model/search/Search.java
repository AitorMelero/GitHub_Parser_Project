package gpp.model.search;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import gpp.GPPSystem;
import gpp.model.Repository;
import gpp.model.User;
import gpp.model.github.api.caller.GitHubAPICaller;
import gpp.view.component.VSearchProgressBar;

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
	private Filter filter; // filtro generales de resultados
	private User user; // usuario que realiza la búsqueda
	private ArrayList<Repository> listRepoResult; // lista de repositorios del resultado
	private int currentPageNumber; // número actual de la página del resultado actual

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
		filter = new Filter();
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

	/**
	 * 
	 * Devuelve el filtro general de los resultados.
	 * 
	 * @return Filtro general de los resultados.
	 */
	public Filter getFilter() {
		return filter;
	}

	/**
	 * 
	 * Modifica el filtro general de los resultados.
	 * 
	 * @param filter. Filtro general de los resultados.
	 */
	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	/**
	 * 
	 * Devuelve la lista de repositorios del resultado de la búsqueda.
	 * 
	 * @return Lista de repositorios devueltos en la búsqueda.
	 */
	public ArrayList<Repository> getListRepoResult() {
		return listRepoResult;
	}

	/**
	 * 
	 * Modifica la lista de repositorios devuelta en la búsqueda.
	 * 
	 * @param listRepoResult. Lista de repositorios devuelta en la búsqueda.
	 */
	public void setListRepoResult(ArrayList<Repository> listRepoResult) {
		this.listRepoResult = listRepoResult;
	}

	/**
	 * 
	 * Devuelve el número actual de la página a mostrar.
	 * 
	 * @return Número de página actual a mostrar.
	 */
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	/**
	 * 
	 * Modifica el número de página a mostrar.
	 * 
	 * @param currentPageNumber. Número de página a mostrar.
	 */
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Realiza la búsqueda de repositorios llamando a la API de GitHub según los
	 * parámetros introducidos.
	 * 
	 */
	public void search() {

		// Variables para las páginas
		int pagesNumber = 1;
		int maxRepositoriesToSearch = 0;
		int repositoriesSearched = 0;
		int repositoriesMaxNumber = Integer.parseInt(query.getRepositoriesMaxNumber());
		int perPage = 100;
		if (repositoriesMaxNumber < 100) {

			perPage = repositoriesMaxNumber;

		}

		// Realizamos la búsqueda
		JsonObject resultQuery = GitHubAPICaller.searchRepositories(user.getToken(), query.getPath(),
				query.getSortOption(), query.getOrderOption(), perPage, pagesNumber);

		// Comprobamos si hay error
		if (resultQuery.has("error")) {

			return;

		}

		// Sacamos los resultados
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

		// Guardamos los resultados de la primera página
		setCurrentPageNumber(1);
		result.add(resultQuery);
		createRepositoriesFromResult(resultRepos);

		// Modificamos el número de páginas a devolver
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

				// Sacamos el número de repositorios por página
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
	 * Filtra la lista de repositorios en función de los filtros introducidos.
	 * 
	 * @param pb. Panel con la barra de progreso.
	 */
	public void filter(VSearchProgressBar pb) {

		int i = 1;
		ArrayList<Repository> listRepoFilter = new ArrayList<Repository>();
		boolean repoIsCorrect = true;

		// listRepoResult.get(3).generateFullInfo();

		for (Repository r : listRepoResult) {

			repoIsCorrect = true;
			
			pb.setProgressNumber(pb.getProgressNumber() + 1);

			// Generamos la información completa del repositorio si no hay error
			try {
				
				// Se cancela la tarea en paralelo
				// Se cancela la tarea
				if (!GPPSystem.isGlobalSemaphoreTasks()) {
					
					return;
					
				}
				
				r.generateFullInfo();
			} catch (Exception e) {
				repoIsCorrect = false;
			}

			// Filtramos el repositorio
			if (repoIsCorrect) {

				if (filter.filterRepository(r)) {

					listRepoFilter.add(r);

				}

			}

			i++;

		}

		// Modificamos la lista de resultados con la lista de filtrados
		this.setListRepoResult(listRepoFilter);

	}

	/**
	 * 
	 * Recorre la lista de repositorios devueltos por la consulta a la API para ir
	 * creando dichos repositorios.
	 * 
	 * @param resultRepos. Lista de objetos JSON con la representación de los
	 *                     repositorios devueltos.
	 */
	private void createRepositoriesFromResult(JsonArray resultRepos) {

		Repository repoResult;
		for (JsonElement re : resultRepos) {

			// Sacamos la información que nos proporciona la API
			JsonObject ro = (JsonObject) re;
			String ownerName = new String(ro.get("full_name").getAsString().split("/")[0].getBytes(),
					StandardCharsets.UTF_8);
			String repoName = new String(ro.get("name").getAsString().getBytes(), StandardCharsets.UTF_8);
			String description = "";
			if (!ro.get("description").isJsonNull()) {
				description = new String(ro.get("description").getAsString().getBytes(), StandardCharsets.UTF_8);
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
			String mainLanguage = "";
			if (!ro.get("language").isJsonNull()) {
				mainLanguage = ro.get("language").getAsString();
			}
			String mainBranch = ro.get("default_branch").getAsString();

			// Añadimos la información obtenida al repositorio
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
			repoResult.setMainBranch(mainBranch);
			listRepoResult.add(repoResult);

		}

	}

}
