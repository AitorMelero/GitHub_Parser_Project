package gpp.model.search;

/**
 * 
 * Clase que implementa la consulta de un b?squeda.
 * 
 * @author Aitor Melero
 *
 */
public class Query {

	private String path; // path para la b?squeda en la API
	private String owner; // nombre del propietario del repositorio
	private String inRepositoryName; // cadena que aparece en el nombre del repositorio
	private String repository; // repositorio concreto con propietario y nombre
	private String description; // cadena que aparece en la descripci?n del repositorio
	private String inReadme; // cadena que aparece en el Readme del repositorio
	private String createdDate; // fecha de creaci?n del repositorio
	private String updatedDate; // fecha de actualizaci?n del repositorio
	private String mainLanguage; // lenguaje principal del repositorio
	private String starsNumber; // n?mero de estrellas del repositorio
	private String forksNumber; // n?mero de forks del repositorio
	private String followersNumber; // n?mero de seguidores del repositorio
	private String size; // tama?o total del repositorio
	private String license; // licencia del repositorio
	private String topics; // topics del repositorio
	private String topicsNumber; // n?mero de topics del repositorio
	private String sortOption; // opci?n de orden del resultado
	private String orderOption; // opci?n de orden ascendente o descendente del resultado
	private String repositoriesMaxNumber; // n?mero m?ximos de repositorios a devolver (m?x. 1000)

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el path de la consulta.
	 * 
	 * @return Path de la consulta.
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 
	 * Modifica el path de la consulta.
	 * 
	 * @param path. Nuevo path de la consulta.
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 
	 * Devuelve la cadena de propietarios.
	 * 
	 * @return Cadena con los propietarios del repositorio a buscar.
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * 
	 * Modifica la cadena de propietarios.
	 * 
	 * @param owner. La nueva cadena de propietarios.
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * 
	 * Devuelve la cadena que aparece en el nombre del repositorio.
	 * 
	 * @return Cadena que aparece en el nombre del repositorio.
	 */
	public String getInRepositoryName() {
		return inRepositoryName;
	}

	/**
	 * 
	 * Modifica la cadena que aparece en el nombre del repositorio.
	 * 
	 * @param inRepositoryName. Nueva cadena que aparece en el nombre del
	 *                          repositorio.
	 */
	public void setInRepositoryName(String inRepositoryName) {
		this.inRepositoryName = inRepositoryName;
	}

	/**
	 * 
	 * Devuelve la cadena con el autor y nombre del repositorio.
	 * 
	 * @return Cadena con el autor y nombre del repositorio.
	 */
	public String getRepository() {
		return repository;
	}

	/**
	 * 
	 * Modifica la cadena con el autor y nombre del repositorio.
	 * 
	 * @param repository. Cadena con el nombre del autor y del repositorio.
	 */
	public void setRepository(String repository) {
		this.repository = repository;
	}

	/**
	 * 
	 * Devuelve la cadena con las cadenas que aparecen en la descripci?n del
	 * repositorio.
	 * 
	 * @return Cadena con cadenas que aparecen en la descripci?n.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * Modifica la cadena con cadenas que aparecen en la descripci?n del
	 * repositorio.
	 * 
	 * @param description. Cadena con cadenas que aparecen en la descripci?n del
	 *                     repositorio.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * Devuelve la cadena con las palabras que aparecen en el Readme del
	 * repositorio.
	 * 
	 * @return Cadena con palabras que aparecen en el Readme del repositorio.
	 */
	public String getInReadme() {
		return inReadme;
	}

	/**
	 * 
	 * Modifica la cadena con palabras que aparecen en el Readme del repositorio.
	 * 
	 * @param inReadme. Cadena con palabras que aparecen en el Readme del
	 *                  repositorio.
	 */
	public void setInReadme(String inReadme) {
		this.inReadme = inReadme;
	}

	/**
	 * 
	 * Devuelve la cadena la fecha de creaci?n del repositorio.
	 * 
	 * @return Cadena con la fecha de creaci?n del repositorio.
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * 
	 * Modifica la cadena con la fecha de creaci?n del repositorio.
	 * 
	 * @param createdDate. Cadena con la fecha de creaci?n del repositorio.
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 
	 * Devuelve la cadena de la fecha de actualizaci?n del repositorio.
	 * 
	 * @return Cadena con la fecha de actualizaci?n del repositorio.
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 
	 * Modifica la cadena con la fecha de actualizaci?n del repositorio.
	 * 
	 * @param updatedDate. Cadena con la fecha de actualizaci?n del repositorio.
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * 
	 * Devuelve la cadena con el lenguaje principal del repositorio.
	 * 
	 * @return Cadena con el lenguaje principal del repositorio.
	 */
	public String getMainLanguage() {
		return mainLanguage;
	}

	/**
	 * 
	 * Modifica la cadena con el lenguaje principal del repositorio.
	 * 
	 * @param mainLanguage. Cadena con el lenguaje principal del repositorio.
	 */
	public void setMainLanguage(String mainLanguage) {
		this.mainLanguage = mainLanguage;
	}

	/**
	 * 
	 * Devuelve la cadena con el n?mero de estrellas del repositorio.
	 * 
	 * @return Cadena con el n?mero de estrellas del repositorio.
	 */
	public String getStarsNumber() {
		return starsNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el n?mero de estrellas del repositorio.
	 * 
	 * @param starsNumber. Cadena con el n?mero de estrellas del repositorio.
	 */
	public void setStarsNumber(String starsNumber) {
		this.starsNumber = starsNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con el n?mero de forks del repositorio.
	 * 
	 * @return Cadena con el n?mero de forks del repositorio.
	 */
	public String getForksNumber() {
		return forksNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el n?mero de forks del repositorio.
	 * 
	 * @param forksNumber. Cadena con el n?mero de forks del repositorio.
	 */
	public void setForksNumber(String forksNumber) {
		this.forksNumber = forksNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con el n?mero de seguidores del repositorio.
	 * 
	 * @return Cadena con el n?mero de seguidores del repositorio.
	 */
	public String getFollowersNumber() {
		return followersNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el n?mero de seguidores del repositorio.
	 * 
	 * @param followersNumber. Cadena con el n?mero de seguidores del repositorio.
	 */
	public void setFollowersNumber(String followersNumber) {
		this.followersNumber = followersNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con el tama?o del repositorio.
	 * 
	 * @return Cadena con el tama?o del repositorio.
	 */
	public String getSize() {
		return size;
	}

	/**
	 * 
	 * Modifica la cadena con el tama?o del repositorio.
	 * 
	 * @param size. Cadena con el tama?o del repositorio.
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * 
	 * Devuelve la cadena con la licencia del repositorio.
	 * 
	 * @return Cadena de la licencia del repositorio.
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * 
	 * Modifica la cadena de la licencia del repositorio.
	 * 
	 * @param license. Cadena de la licencia del repositorio.
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * 
	 * Devuelve la cadena con los topics del repositorio.
	 * 
	 * @return Cadena con los topics del repositorio.
	 */
	public String getTopics() {
		return topics;
	}

	/**
	 * 
	 * Modifica la cadena con los topics del repositorio.
	 * 
	 * @param topics. Cadena con los topics del repositorio.
	 */
	public void setTopics(String topics) {
		this.topics = topics;
	}

	/**
	 * 
	 * Cadena con el n?mero de topics del repositorio.
	 * 
	 * @return Cadena con el n?mero de topics del repositorio.
	 */
	public String getTopicsNumber() {
		return topicsNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el n?mero de topics del repositorio.
	 * 
	 * @param topicsNumber. Cadena con el n?mero de topics del repositorio.
	 */
	public void setTopicsNumber(String topicsNumber) {
		this.topicsNumber = topicsNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con la opci?n de ordenamiento de los resultados.
	 * 
	 * @return Cadena con la opci?n de ordenamiento de los resultados.
	 */
	public String getSortOption() {
		return sortOption;
	}

	/**
	 * 
	 * Modifica la cadena con la opci?n de ordenamiento de los resultados.
	 * 
	 * @param sortOption. Cadena con la opci?n de ordenamiento de los resultados.
	 */
	public void setSortOption(String sortOption) {
		this.sortOption = sortOption;
	}

	/**
	 * 
	 * Devuelve la cadena con la opci?n de orden ascendente o descendente
	 * correspondiente.
	 * 
	 * @return Cadena con la opci?n de orden ascendente o descendente
	 *         correspondiente.
	 */
	public String getOrderOption() {
		return orderOption;
	}

	/**
	 * 
	 * Modifica la cadena con la opci?n de orden ascendente o descendente
	 * correspondiente.
	 * 
	 * @param orderOption. Cadena con la opci?n de orden ascendente o descendente
	 *                     correspondiente.
	 */
	public void setOrderOption(String orderOption) {
		this.orderOption = orderOption;
	}

	/**
	 * 
	 * Devuelve la cadena con el n?mero m?ximo de repositorios a devolver en la
	 * b?squeda.
	 * 
	 * @return Cadena con el n?mero m?ximo de repositorios a devolver en la
	 *         b?squeda.
	 */
	public String getRepositoriesMaxNumber() {
		return repositoriesMaxNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el n?mero m?ximo de repositorios a devolver en la
	 * b?squeda.
	 * 
	 * @param sortOption. Cadena con el n?mero m?ximo de repositorios a devolver en
	 *                    la b?squeda.
	 */
	public void setRepositoriesMaxNumber(String repositoriesMaxNumber) {
		this.repositoriesMaxNumber = repositoriesMaxNumber;
	}

	/**************************************************************************
	 * M?TODOSS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Genera el path con los argumentos de la query.
	 * 
	 */
	public void generateQueryPath() {

		// Path
		setPath("q=");
		setPath(path + generateOwner());
		setPath(path + generateInRepositoryName());
		setPath(path + generateRepository());
		setPath(path + generateDescription());
		setPath(path + generateInReadme());
		setPath(path + generateCreatedDate());
		setPath(path + generateUpdatedDate());
		setPath(path + generateMainLanguage());
		setPath(path + generateStarsNumber());
		setPath(path + generateForksNumber());
		setPath(path + generateFollowersNumber());
		setPath(path + generateSize());
		setPath(path + generateLicense());
		setPath(path + generateTopics());
		setPath(path + generateTopicsNumber());

		// Orden
		generateSortOrderOption();

		// Number pages
		generateRepositoriesMaxNumber();

		// Comprobamos que la query no est? vac?a
		if (path.equals("q=")) {

			setPath("");

		}

	}

	/**
	 * 
	 * Genera la query con los argumentos para el propietario del repositorio a
	 * buscar.
	 * 
	 * @return Cadena con los argumentos para el propietario del repositorio a
	 *         buscar.
	 */
	private String generateOwner() {

		String ownerQuery = "";

		if (owner != null && !owner.equals("")) {

			// Creamos la consulta
			for (String o : generateParamsQuery(owner)) {

				ownerQuery += "+user:" + o;

			}

		}

		return ownerQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para la cadena que aparece en el
	 * repositorio.
	 * 
	 * @return Cadena con los par?metros para la cadena que aparece en el
	 *         repositorio.
	 */
	private String generateInRepositoryName() {

		String inRepositoryNameQuery = "";
		String[] generateParams;

		if (inRepositoryName != null && !inRepositoryName.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(inRepositoryName);

			for (String i : generateParams) {

				inRepositoryNameQuery += "+" + i;

			}

			if (generateParams.length > 0) {

				inRepositoryNameQuery += "+in:name";

			}

		}

		return inRepositoryNameQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para buscar un repositorio en concreto.
	 * 
	 * @return Cadena a enviar en la consulta de repositorios en concreto.
	 */
	private String generateRepository() {

		String repositoryQuery = "";

		if (repository != null && !repository.equals("")) {

			repositoryQuery = "+repo:" + repository.replace(" ", "");

		}

		return repositoryQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para la cadena que aparece en la
	 * descripci?n del repositorio.
	 * 
	 * @return Cadena con los par?metros para la cadena que aparece en la
	 *         descripci?n del repositorio.
	 */
	private String generateDescription() {

		String descriptionQuery = "";
		String[] generateParams;

		if (description != null && !description.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(description);

			for (String i : generateParams) {

				descriptionQuery += "+" + i;

			}

			if (generateParams.length > 0) {

				descriptionQuery += "+in:description";

			}

		}

		return descriptionQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para la cadena que aparece en el Readme
	 * del repositorio.
	 * 
	 * @return Cadena con los par?metros para la cadena que aparece en el Readme del
	 *         repositorio.
	 */
	private String generateInReadme() {

		String inReadmeQuery = "";
		String[] generateParams;

		if (inReadme != null && !inReadme.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(inReadme);

			for (String i : generateParams) {

				inReadmeQuery += "+" + i;

			}

			if (generateParams.length > 0) {

				inReadmeQuery += "+in:readme";

			}

		}

		return inReadmeQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para la fecha de creaci?n del
	 * repositorio.
	 * 
	 * @return Cadena con los par?metros para la fecha de creaci?n del repositorio.
	 */
	private String generateCreatedDate() {

		String createdDateQuery = "";
		String[] generateParams;

		if (createdDate != null && !createdDate.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(createdDate);

			for (int i = 0; i < generateParams.length; i++) {

				if (i == 0) {

					createdDateQuery = "+created:" + generateParams[i];

				} else {

					createdDateQuery += "+" + generateParams[i];

				}

			}

		}

		return createdDateQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para la fecha de actualizaci?n del
	 * repositorio.
	 * 
	 * @return Cadena con los par?metros para la fecha de actualizaci?n del
	 *         repositorio.
	 */
	private String generateUpdatedDate() {

		String updatedDateQuery = "";
		String[] generateParams;

		if (updatedDate != null && !updatedDate.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(updatedDate);

			for (int i = 0; i < generateParams.length; i++) {

				if (i == 0) {

					updatedDateQuery = "+pushed:" + generateParams[i];

				} else {

					updatedDateQuery += "+" + generateParams[i];

				}

			}

		}

		return updatedDateQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para el lenguaje principal del
	 * repositorio.
	 * 
	 * @return Cadena con los par?metros para el lenguaje principal del repositorio.
	 */
	private String generateMainLanguage() {

		String mainLanguageQuery = "";
		String[] generateParams;

		if (mainLanguage != null && !mainLanguage.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(mainLanguage);

			for (String i : generateParams) {

				mainLanguageQuery += "+language:" + i;

			}

		}

		return mainLanguageQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para el n?mero de estrellas del
	 * repositorio.
	 * 
	 * @return Cadena con los par?metros para el n?mero de estrellas del
	 *         repositorio.
	 */
	private String generateStarsNumber() {

		String starsNumberQuery = "";
		String[] generateParams;

		if (starsNumber != null && !starsNumber.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(starsNumber);

			for (int i = 0; i < generateParams.length; i++) {

				starsNumberQuery += "+stars:" + generateParams[i];

			}

		}

		return starsNumberQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para el n?mero de forks del repositorio.
	 * 
	 * @return Cadena con los par?metros para el n?mero de forks del repositorio.
	 */
	private String generateForksNumber() {

		String forksNumberQuery = "";
		String[] generateParams;

		if (forksNumber != null && !forksNumber.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(forksNumber);

			for (int i = 0; i < generateParams.length; i++) {

				forksNumberQuery += "+forks:" + generateParams[i];

			}

		}

		return forksNumberQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para el n?mero de seguidores del
	 * repositorio.
	 * 
	 * @return Cadena con los par?metros para el n?mero de seguidores del
	 *         repositorio.
	 */
	private String generateFollowersNumber() {

		String followersNumberQuery = "";
		String[] generateParams;

		if (followersNumber != null && !followersNumber.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(followersNumber);

			for (int i = 0; i < generateParams.length; i++) {

				followersNumberQuery += "+followers:" + generateParams[i];

			}

		}

		return followersNumberQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para el n?mero de KB del repositorio.
	 * 
	 * @return Cadena con los par?metros para el n?mero de KB del repositorio.
	 */
	private String generateSize() {

		String sizeQuery = "";
		String[] generateParams;

		if (size != null && !size.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(size);

			for (int i = 0; i < generateParams.length; i++) {

				sizeQuery += "+size:" + generateParams[i];

			}

		}

		return sizeQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para la licencia del repositorio.
	 * 
	 * @return Cadena con los par?metros para la licencia del repositorio.
	 */
	private String generateLicense() {

		String licenseQuery = "";
		String[] generateParams;

		if (license != null && !license.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(license);

			for (String i : generateParams) {

				licenseQuery += "+license:" + i;

			}

		}

		return licenseQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para los topics del repositorio.
	 * 
	 * @return Cadena con los par?metros para los topics del repositorio.
	 */
	private String generateTopics() {

		String topicsQuery = "";
		String[] generateParams;

		if (topics != null && !topics.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(topics);

			for (String i : generateParams) {

				topicsQuery += "+topic:" + i;

			}

		}

		return topicsQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para el n?mero de topics del repositorio.
	 * 
	 * @return Cadena con los par?metros para el n?mero de topics del repositorio.
	 */
	private String generateTopicsNumber() {

		String topicsNumberQuery = "";
		String[] generateParams;

		if (topicsNumber != null && !topicsNumber.equals("")) {

			// Creamos la consulta
			generateParams = generateParamsQuery(topicsNumber);

			for (int i = 0; i < generateParams.length; i++) {

				topicsNumberQuery += "+topics:" + generateParams[i];

			}

		}

		return topicsNumberQuery;

	}

	/**
	 * 
	 * Genera la cadena con los par?metros para el criterio de orden de los
	 * resultados.
	 * 
	 * @return Cadena con los par?metros para el criterio de orden de los
	 *         resultados.
	 */
	private void generateSortOrderOption() {

		// Sort
		if (sortOption == null) {

			sortOption = "best-match";

		} else {

			setSortOption(sortOption.replace(" ", ""));

			if (!sortOption.equals("stars") && !sortOption.equals("forks") && !sortOption.equals("updated")) {

				setSortOption("best-match");

			}

		}

		// Order
		if (orderOption == null) {

			orderOption = "desc";

		} else {

			setOrderOption(orderOption.replace(" ", ""));

			if (!orderOption.equals("asc")) {

				setOrderOption("desc");

			}

		}

	}

	/**
	 * 
	 * Genera la cadena con el n?mero de repositorios m?ximo a devolver.
	 * 
	 * @return Cadena con el n?mero de repositorios m?ximo a devolver.
	 */
	private void generateRepositoriesMaxNumber() {

		if (repositoriesMaxNumber == null) {

			// Por defecto 50
			repositoriesMaxNumber = "50";

		} else {

			repositoriesMaxNumber = repositoriesMaxNumber.replace(" ", "");

			try {

				int maxNumber = Integer.parseInt(getRepositoriesMaxNumber());
				
				// Como m?ximo 1000 repositorios de b?squeda
				if (maxNumber > 1000) {
					
					repositoriesMaxNumber = "50";
					
				}

			} catch (NumberFormatException e) {

				repositoriesMaxNumber = "50";

			} catch (Exception e) {
				
				repositoriesMaxNumber = "50";
				
			}

		}

	}

	/**
	 * 
	 * Genera una lista de par?metros a partir de la cadena con los par?metros.
	 * 
	 * @param paramsString. Cadena con par?metros.
	 * @return Lista con par?metros.
	 */
	private String[] generateParamsQuery(String paramsString) {

		String withoutSpaces;
		String[] params = {};

		// Quitamos los espacios en blanco
		withoutSpaces = paramsString.replace(" ", "");

		if (!withoutSpaces.equals("")) {

			// Comprobamos que el primer caracter no sea una coma
			if (withoutSpaces.substring(0, 1).equals(",")) {

				withoutSpaces = withoutSpaces.substring(1);

			}

			// Separamos por comas
			params = withoutSpaces.split(",");

		}

		return params;

	}

}
