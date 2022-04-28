package gpp.model.search;

/**
 * 
 * Clase que implementa la consulta de un búsqueda.
 * 
 * @author Aitor Melero
 *
 */
public class Query {

	private String path; // path para la búsqueda en la API
	private String owner; // nombre del propietario del repositorio
	private String inRepositoryName; // cadena que aparece en el nombre del repositorio
	private String repository; // repositorio concreto con propietario y nombre
	private String description; // cadena que aparece en la descripción del repositorio
	private String inReadme; // cadena que aparece en el Readme del repositorio
	private String createdDate; // fecha de creación del repositorio
	private String mainLanguage; // lenguaje principal del repositorio
	private String starsNumber; // número de estrellas del repositorio
	private String forksNumber; // número de forks del repositorio
	private String size; // tamaño total del repositorio
	private String pushedTo; // fecha del último push del repositorio
	private String license; // licencia del repositorio
	private String topics; // topics del repositorio
	private String topicsNumber; // número de topics del repositorio
	private String sortOption; // opción de orden del resultado
	private String repositoriesMaxNumber; // número máximos de repositorios a devolver (máx. 1000)

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
	 * Devuelve la cadena con las cadenas que aparecen en la descripción del
	 * repositorio.
	 * 
	 * @return Cadena con cadenas que aparecen en la descripción.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * Modifica la cadena con cadenas que aparecen en la descripción del
	 * repositorio.
	 * 
	 * @param description. Cadena con cadenas que aparecen en la descripción del
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
	 * Devuelve la cadena la fecha de creación del repositorio.
	 * 
	 * @return Cadena con la fecha de creación del repositorio.
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * 
	 * Modifica la cadena con la fecha de creación del repositorio.
	 * 
	 * @param createdDate. Cadena con la fecha de creación del repositorio.
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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
	 * Devuelve la cadena con el número de estrellas del repositorio.
	 * 
	 * @return Cadena con el número de estrellas del repositorio.
	 */
	public String getStarsNumber() {
		return starsNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el número de estrellas del repositorio.
	 * 
	 * @param starsNumber. Cadena con el número de estrellas del repositorio.
	 */
	public void setStarsNumber(String starsNumber) {
		this.starsNumber = starsNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con el número de forks del repositorio.
	 * 
	 * @return Cadena con el número de forks del repositorio.
	 */
	public String getForksNumber() {
		return forksNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el número de forks del repositorio.
	 * 
	 * @param forksNumber. Cadena con el número de forks del repositorio.
	 */
	public void setForksNumber(String forksNumber) {
		this.forksNumber = forksNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con el tamaño del repositorio.
	 * 
	 * @return Cadena con el tamaño del repositorio.
	 */
	public String getSize() {
		return size;
	}

	/**
	 * 
	 * Modifica la cadena con el tamaño del repositorio.
	 * 
	 * @param size. Cadena con el tamaño del repositorio.
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * 
	 * Devuelve la cadena con la fecha del último push del repositorio.
	 * 
	 * @return Cadena con la fecha del último push del repositorio.
	 */
	public String getPushedTo() {
		return pushedTo;
	}

	/**
	 * 
	 * Modifica la cadena con la fecha del último push del repositorio.
	 * 
	 * @param pushedTo. Cadena con la fecha del último push del repositorio.
	 */
	public void setPushedTo(String pushedTo) {
		this.pushedTo = pushedTo;
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
	 * Cadena con el número de topics del repositorio.
	 * 
	 * @return Cadena con el número de topics del repositorio.
	 */
	public String getTopicsNumber() {
		return topicsNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el número de topics del repositorio.
	 * 
	 * @param topicsNumber. Cadena con el número de topics del repositorio.
	 */
	public void setTopicsNumber(String topicsNumber) {
		this.topicsNumber = topicsNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con la opción de ordenamiento de los resultados.
	 * 
	 * @return Cadena con la opción de ordenamiento de los resultados.
	 */
	public String getSortOption() {
		return sortOption;
	}

	/**
	 * 
	 * Modifica la cadena con la opción de ordenamiento de los resultados.
	 * 
	 * @param sortOption. Cadena con la opción de ordenamiento de los resultados.
	 */
	public void setSortOption(String sortOption) {
		this.sortOption = sortOption;
	}

	/**
	 * 
	 * Devuelve la cadena con el número máximo de repositorios a devolver en la
	 * búsqueda.
	 * 
	 * @return Cadena con el número máximo de repositorios a devolver en la
	 *         búsqueda.
	 */
	public String getRepositoriesMaxNumber() {
		return repositoriesMaxNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el número máximo de repositorios a devolver en la
	 * búsqueda.
	 * 
	 * @param sortOption. Cadena con el número máximo de repositorios a devolver en
	 *                    la búsqueda.
	 */
	public void setRepositoriesMaxNumber(String repositoriesMaxNumber) {
		this.repositoriesMaxNumber = repositoriesMaxNumber;
	}

	/**************************************************************************
	 * MÉTODOSS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Genera el path con los argumentos de la query.
	 * 
	 */
	public void generateQueryPath() {

		setPath("q=");
		setPath(path + generateOwner());
		setPath(path + generateInRepositoryName());
		setPath(path + generateRepository());
		setPath(path + generateDescription());
		setPath(path + generateInReadme());
		setPath(path + generateCreatedDate());

		// Comprobamos que la query no está vacía
		if (!path.equals("q=")) {

			setPath(path + ";");

		} else {

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
	 * Genera la cadena con los parámetros para la cadena que aparece en el
	 * repositorio.
	 * 
	 * @return Cadena con los parámetros para la cadena que aparece en el
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
	 * Genera la cadena con los parámetros para buscar un repositorio en concreto.
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
	 * Genera la cadena con los parámetros para la cadena que aparece en la
	 * descripción del repositorio.
	 * 
	 * @return Cadena con los parámetros para la cadena que aparece en la
	 *         descripción del repositorio.
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
	 * Genera la cadena con los parámetros para la cadena que aparece en el Readme
	 * del repositorio.
	 * 
	 * @return Cadena con los parámetros para la cadena que aparece en el Readme del
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
	 * Genera la cadena con los parámetros para la fecha de creación del
	 * repositorio.
	 * 
	 * @return Cadena con los parámetros para la fecha de creación del repositorio.
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
	 * Genera una lista de parámetros a partir de la cadena con los parámetros.
	 * 
	 * @param paramsString. Cadena con parámetros.
	 * @return Lista con parámetros.
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
