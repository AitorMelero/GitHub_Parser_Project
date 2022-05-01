package gpp.model.search;

import gpp.model.Repository;

/**
 * 
 * Clase que implementa los filtros de una b�squeda.
 * 
 * @author Aitor Melero
 *
 */
public class Filter {

	private String owner; // nombre del propietario del repositorio
	private String inRepositoryName; // cadena que aparece en el nombre del repositorio
	private String description; // cadena que aparece en la descripci�n del repositorio
	private String createdDate; // fecha de creaci�n del repositorio
	private String updatedDate; // fecha de actualizaci�n del repositorio
	private String mainLanguage; // lenguaje principal del repositorio
	private String starsNumber; // n�mero de estrellas del repositorio
	private String forksNumber; // n�mero de forks del repositorio
	private String size; // tama�o total del repositorio
	private String license; // licencia del repositorio
	private String topics; // topics del repositorio
	private String topicsNumber; // n�mero de topics del repositorio
	private String filesNumber; // n�mero de ficheros del repositorio
	private String extensions; // extensiones del repositorio
	private String avgSize; // tama�o medio por ficheros

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve la cadena de propietarios.
	 * 
	 * @return Cadena con los propietarios del repositorio a filtrar.
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
	 * Devuelve la cadena con las cadenas que aparecen en la descripci�n del
	 * repositorio.
	 * 
	 * @return Cadena con cadenas que aparecen en la descripci�n.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * Modifica la cadena con cadenas que aparecen en la descripci�n del
	 * repositorio.
	 * 
	 * @param description. Cadena con cadenas que aparecen en la descripci�n del
	 *                     repositorio.
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * Devuelve la cadena de la fecha de actualizaci�n del repositorio.
	 * 
	 * @return Cadena con la fecha de actualizaci�n del repositorio.
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 
	 * Modifica la cadena con la fecha de actualizaci�n del repositorio.
	 * 
	 * @param updatedDate. Cadena con la fecha de actualizaci�n del repositorio.
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
	 * Devuelve la cadena con el n�mero de topics del repositorio.
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
	 * Devuelve la cadena con el n�mero de ficheros del repositorio.
	 * 
	 * @return Cadena con el n�mero de ficheros del repositorio.
	 */
	public String getFilesNumber() {
		return filesNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el n�mero de ficheros del repositorio.
	 * 
	 * @param filesNumber. Cadena con el n�mero de ficheros del repositorio.
	 */
	public void setFilesNumber(String filesNumber) {
		this.filesNumber = filesNumber;
	}

	/**
	 * 
	 * Devuelve la cadena con las extensiones del repositorio.
	 * 
	 * @return Cadena con las extensiones del repositorio.
	 */
	public String getExtensions() {
		return extensions;
	}

	/**
	 * 
	 * Modifica la cadena con las extensiones del repositorio.
	 * 
	 * @param extensions. Cadena con las extensiones del repositorio.
	 */
	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	/**
	 * 
	 * Devuelve la cadena con la media de tama�o por ficheros del repositorio.
	 * 
	 * @return Cadena con la media de tama�o por ficheros del repositorio.
	 */
	public String getAvgSize() {
		return avgSize;
	}

	/**
	 * 
	 * Modifica la cadena con la media de tama�o por ficheros del repositorio.
	 * 
	 * @param avgSize. Cadena con la media de tama�o por ficheros del repositorio.
	 */
	public void setAvgSize(String avgSize) {
		this.avgSize = avgSize;
	}

	/**************************************************************************
	 * M�TODOSS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Filtra un repositorio.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple con los filtros, false en caso
	 *         contrario.
	 */
	public boolean filterRepository(Repository repository) {

		boolean isValid = true;

		if (!filterOwner(repository)) {

			return false;

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por autores.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro de autor, false en caso
	 *         contrario.
	 */
	private boolean filterOwner(Repository repository) {

		boolean isValid = false;
		String[] ownersList;

		// Comprobamos que hay autores en el filtro
		if (owner != null && !owner.equals("")) {

			// Sacamos los autores a comparar
			ownersList = owner.replace(" ", "").split(",");

			for (int i = 0; i < ownersList.length && !isValid; i++) {

				if (repository.getOwnerName().equals(ownersList[i])) {

					isValid = true;

				}

			}

		} else {

			owner = "";
			
			isValid = true;

		}

		return isValid;

	}

}
