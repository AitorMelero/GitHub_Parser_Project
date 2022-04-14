package gpp.model.search;

/**
 * 
 * Clase que implementa la consulta de un b�squeda.
 * 
 * @author Aitor Melero
 *
 */
public class Query {

	private String path; // path para la b�squeda en la API
	private String owner; // nombre del propietario del repositorio
	private String inRepositoryName; // cadena que aparece en el nombre del repositorio
	private String repository; // repositorio concreto con propietario y nombre
	private String createdDate; // fecha de creaci�n del repositorio
	private String mainLanguage; // lenguaje principal del repositorio
	private String starsNumber; // n�mero de estrellas del repositorio
	private String forksNumber; // n�mero de forks del repositorio
	private String size; // tama�o total del repositorio
	private String pushedTo; // fecha del �ltimo push del repositorio
	private String license; // licencia del repositorio
	private String topics; // topics del repositorio
	private String topicsNumber; // n�mero de topics del repositorio
	private String sortOption; // opci�n de orden del resultado

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
	 * Devuelve la cadena la fecha de creaci�n del repositorio.
	 * 
	 * @return Cadena con la fecha de creaci�n del repositorio.
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * 
	 * Modifica la cadena con la fecha de creaci�n del repositorio.
	 * 
	 * @param createdDate. Cadena con la fecha de creaci�n del repositorio.
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
	 * Devuelve la cadena con el n�mero de estrellas del repositorio.
	 * 
	 * @return Cadena con el n�mero de estrellas del repositorio.
	 */
	public String getStarsNumber() {
		return starsNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el n�mero de estrellas del repositorio.
	 * 
	 * @param starsNumber. Cadena con el n�mero de estrellas del repositorio.
	 */
	public void setStarsNumber(String starsNumber) {
		this.starsNumber = starsNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con el n�mero de forks del repositorio.
	 * 
	 * @return Cadena con el n�mero de forks del repositorio.
	 */
	public String getForksNumber() {
		return forksNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el n�mero de forks del repositorio.
	 * 
	 * @param forksNumber. Cadena con el n�mero de forks del repositorio.
	 */
	public void setForksNumber(String forksNumber) {
		this.forksNumber = forksNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con el tama�o del repositorio.
	 * 
	 * @return Cadena con el tama�o del repositorio.
	 */
	public String getSize() {
		return size;
	}

	/**
	 * 
	 * Modifica la cadena con el tama�o del repositorio.
	 * 
	 * @param size. Cadena con el tama�o del repositorio.
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * 
	 * Devuelve la cadena con la fecha del �ltimo push del repositorio.
	 * 
	 * @return Cadena con la fecha del �ltimo push del repositorio.
	 */
	public String getPushedTo() {
		return pushedTo;
	}

	/**
	 * 
	 * Modifica la cadena con la fecha del �ltimo push del repositorio.
	 * 
	 * @param pushedTo. Cadena con la fecha del �ltimo push del repositorio.
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
	 * Cadena con el n�mero de topics del repositorio.
	 * 
	 * @return Cadena con el n�mero de topics del repositorio.
	 */
	public String getTopicsNumber() {
		return topicsNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el n�mero de topics del repositorio.
	 * 
	 * @param topicsNumber. Cadena con el n�mero de topics del repositorio.
	 */
	public void setTopicsNumber(String topicsNumber) {
		this.topicsNumber = topicsNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con la opci�n de ordenamiento de los resultados.
	 * 
	 * @return Cadena con la opci�n de ordenamiento de los resultados.
	 */
	public String getSortOption() {
		return sortOption;
	}

	/**
	 * 
	 * Modifica la cadena con la opci�n de ordenamiento de los resultados.
	 * 
	 * @param sortOption. Cadena con la opci�n de ordenamiento de los resultados.
	 */
	public void setSortOption(String sortOption) {
		this.sortOption = sortOption;
	}
	
	
	/**************************************************************************
	 * M�TODOSS
	 * ************************************************************************
	 */
	
	/**
	 * 
	 * Genera el path con los argumentos de la query.
	 * 
	 */
	public void generateQueryPath() {
		
		setPath("?q=");
		setPath(path + generateOwner());
		
	}
	
	/**
	 * 
	 * Genera la query con los argumentos para el propietario del repositorio a buscar.
	 * 
	 * @return Cadena con los argumentos para el propietario del repositorio a buscar.
	 */
	public String generateOwner() {
		
		String ownerQuery = "";
		String ownerWithoutSpaces;
		String[] ownerParams;
		
		if (owner != null) {
			
			// Reemplazamos espacios en blanco
			ownerWithoutSpaces = owner.replace(" ", "");
			
			if (!ownerWithoutSpaces.equals("")) {
				
				// Separamos por comas a los autores
				ownerParams = ownerWithoutSpaces.split(",");
				
				// Creamos la consulta
				for (String o: ownerParams) {
					
					ownerQuery += "+user:" + o;
					
				}
				
			}
			
		}
		
		return ownerQuery;
		
	}
	
	//public String 

}
