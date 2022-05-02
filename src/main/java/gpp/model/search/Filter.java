package gpp.model.search;

import gpp.model.Repository;

/**
 * 
 * Clase que implementa los filtros de una búsqueda.
 * 
 * @author Aitor Melero
 *
 */
public class Filter {

	private String owner; // nombre del propietario del repositorio
	private String inRepositoryName; // cadena que aparece en el nombre del repositorio
	private String description; // cadena que aparece en la descripción del repositorio
	private String createdDate; // fecha de creación del repositorio
	private String updatedDate; // fecha de actualización del repositorio
	private String mainLanguage; // lenguaje principal del repositorio
	private String starsNumber; // número de estrellas del repositorio
	private String forksNumber; // número de forks del repositorio
	private String size; // tamaño total del repositorio
	private String license; // licencia del repositorio
	private String topics; // topics del repositorio
	private String topicsNumber; // número de topics del repositorio
	private String filesNumber; // número de ficheros del repositorio
	private String extensions; // extensiones del repositorio
	private String avgSize; // tamaño medio por ficheros

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
	 * Devuelve la cadena de la fecha de actualización del repositorio.
	 * 
	 * @return Cadena con la fecha de actualización del repositorio.
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 
	 * Modifica la cadena con la fecha de actualización del repositorio.
	 * 
	 * @param updatedDate. Cadena con la fecha de actualización del repositorio.
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
	 * Devuelve la cadena con el número de topics del repositorio.
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
	 * Devuelve la cadena con el número de ficheros del repositorio.
	 * 
	 * @return Cadena con el número de ficheros del repositorio.
	 */
	public String getFilesNumber() {
		return filesNumber;
	}

	/**
	 * 
	 * Modifica la cadena con el número de ficheros del repositorio.
	 * 
	 * @param filesNumber. Cadena con el número de ficheros del repositorio.
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
	 * Devuelve la cadena con la media de tamaño por ficheros del repositorio.
	 * 
	 * @return Cadena con la media de tamaño por ficheros del repositorio.
	 */
	public String getAvgSize() {
		return avgSize;
	}

	/**
	 * 
	 * Modifica la cadena con la media de tamaño por ficheros del repositorio.
	 * 
	 * @param avgSize. Cadena con la media de tamaño por ficheros del repositorio.
	 */
	public void setAvgSize(String avgSize) {
		this.avgSize = avgSize;
	}

	/**************************************************************************
	 * MÉTODOSS
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

		} else if (!filterInRepositoryName(repository)) {

			return false;

		} else if (!filterDescription(repository)) {

			return false;

		} else if (!filterCreatedDate(repository)) {

			return false;

		} else if (!filterUpdatedDate(repository)) {

			return false;

		} else if (!filterMainLanguage(repository)) {

			return false;

		} else if (!filterStarsNumber(repository)) {

			return false;

		} else if (!filterForksNumber(repository)) {

			return false;

		} else if (!filterSize(repository)) {

			return false;

		} else if (!filterLicense(repository)) {

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

	/**
	 * 
	 * Filtra un repositorio por cadenas en el nombre.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro, false en caso contrario.
	 */
	private boolean filterInRepositoryName(Repository repository) {

		boolean isValid = false;
		String[] inRepositoryNameList;

		// Comprobamos que el filtro no está vacío
		if (inRepositoryName != null && !inRepositoryName.equals("")) {

			// Sacamos los valores a comparar
			inRepositoryNameList = inRepositoryName.replace(" ", "").split(",");

			for (int i = 0; i < inRepositoryNameList.length && !isValid; i++) {

				if (repository.getName().contains(inRepositoryNameList[i])) {

					isValid = true;

				}

			}

		} else {

			inRepositoryName = "";

			isValid = true;

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por cadenas en la descripción.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro, false en caso contrario.
	 */
	private boolean filterDescription(Repository repository) {

		boolean isValid = false;
		String[] descriptionList;
		String descriptionLowerCase = "";

		// Sacamos la descripción en minúsculas
		if (repository.getDescription() != null) {

			descriptionLowerCase = repository.getDescription().toLowerCase();

		}

		// Comprobamos que el filtro no está vacío
		if (description != null && !description.equals("") && !descriptionLowerCase.equals("")) {

			// Sacamos los valores a comparar
			descriptionList = description.replace(" ", "").split(",");

			for (int i = 0; i < descriptionList.length && !isValid; i++) {

				if (descriptionLowerCase.contains(descriptionList[i].toLowerCase())) {

					isValid = true;

				}

			}

		} else {

			description = "";

			isValid = true;

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por fecha de creación.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro, false en caso contrario.
	 */
	private boolean filterCreatedDate(Repository repository) {

		boolean isValid = true;
		String[] createdDateList;

		// Sacamos las cadenas con las fechas
		if (createdDate != null && !createdDate.replace(" ", "").equals("")) {

			createdDateList = createdDate.replace(" ", "").split(",");

			for (int i = 0; i < createdDateList.length && isValid; i++) {

				if (!compareStringDate(repository.getDateCreated(), createdDateList[i])) {

					isValid = false;

				}

			}

		} else {

			createdDate = "";

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por fecha de actualización.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro, false en caso contrario.
	 */
	private boolean filterUpdatedDate(Repository repository) {

		boolean isValid = true;
		String[] updatedDateList;

		// Sacamos las cadenas con las fechas
		if (updatedDate != null && !updatedDate.replace(" ", "").equals("")) {

			updatedDateList = updatedDate.replace(" ", "").split(",");

			for (int i = 0; i < updatedDateList.length && isValid; i++) {

				if (!compareStringDate(repository.getDateUpdated(), updatedDateList[i])) {

					isValid = false;

				}

			}

		} else {

			updatedDate = "";

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por lenguaje principal.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro, false en caso contrario.
	 */
	private boolean filterMainLanguage(Repository repository) {

		boolean isValid = false;
		String[] mainLanguagesList;
		String mainLanguageLowerCase = "";

		// Sacamos la descripción en minúsculas
		if (repository.getMainLanguage() != null && !repository.getMainLanguage().equals("")) {

			mainLanguageLowerCase = repository.getMainLanguage().toLowerCase();

			// Comprobamos que el filtro no está vacío
			if (mainLanguage != null && !mainLanguage.replace(" ", "").equals("")) {

				// Sacamos los valores a comparar
				mainLanguagesList = mainLanguage.replace(" ", "").split(",");

				for (int i = 0; i < mainLanguagesList.length && !isValid; i++) {

					if (mainLanguageLowerCase.equals(mainLanguagesList[i].toLowerCase())) {

						isValid = true;

					}

				}

			} else {

				mainLanguage = "";

				isValid = true;

			}

		} else {

			if (mainLanguage == null || mainLanguage.replace(" ", "").equals("")) {

				mainLanguage = "";

				isValid = true;

			}

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por número de estrellas.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro, false en caso contrario.
	 */
	private boolean filterStarsNumber(Repository repository) {

		boolean isValid = false;

		if (starsNumber != null && !starsNumber.replace(" ", "").equals("")) {

			if (repository.getStarsNumber() >= 0) {

				isValid = compareQuantityString(repository.getStarsNumber(), starsNumber.replace(" ", ""));

			}

		} else {

			starsNumber = "";
			isValid = true;

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por número de forks.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro, false en caso contrario.
	 */
	private boolean filterForksNumber(Repository repository) {

		boolean isValid = false;

		if (forksNumber != null && !forksNumber.replace(" ", "").equals("")) {

			if (repository.getForksNumber() >= 0) {

				isValid = compareQuantityString(repository.getForksNumber(), forksNumber.replace(" ", ""));

			}

		} else {

			forksNumber = "";
			isValid = true;

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por tamaño.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro, false en caso contrario.
	 */
	private boolean filterSize(Repository repository) {

		boolean isValid = false;

		if (size != null && !size.replace(" ", "").equals("")) {

			if (repository.getTotalSize() >= 0) {

				isValid = compareQuantityString(repository.getTotalSize(), size.replace(" ", ""));

			}

		} else {

			size = "";
			isValid = true;

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por licencia.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple el filtro, false en caso contrario.
	 */
	private boolean filterLicense(Repository repository) {

		boolean isValid = false;
		String[] licenseList;
		String licenseLowerCase = "";

		// Sacamos la descripción en minúsculas
		if (repository.getLicense() != null && !repository.getLicense().equals("")) {

			licenseLowerCase = repository.getLicense().replace(" license", "").toLowerCase();

			// Comprobamos que el filtro no está vacío
			if (license != null && !license.replace(" ", "").equals("")) {

				// Sacamos los valores a comparar
				licenseList = license.replace(" ", "").split(",");

				for (int i = 0; i < licenseList.length && !isValid; i++) {

					if (licenseLowerCase.equals(licenseList[i].toLowerCase())) {

						isValid = true;

					}

				}

			} else {

				license = "";

				isValid = true;

			}

		} else {

			if (license == null || license.replace(" ", "").equals("")) {

				license = "";

				isValid = true;

			}

		}

		return isValid;

	}

	/**
	 * 
	 * Compara la cadena de la fecha del repositorio con la cadena de la fecha a
	 * comparar.
	 * 
	 * @param repositoryDate. Cadena con la fecha del repositorio a comparar.
	 * @param compareDate.    Cadena con la fecha a comparar.
	 * @return True si se cumple la comparación, false en caso contrario.
	 */
	private boolean compareStringDate(String repositoryDate, String compareDate) {

		boolean dateValid = true;
		String[] repositoryDateList = repositoryDate.split("-");
		String[] compareDateList = compareDate.split("-");
		int repositoryYear = Integer.parseInt(repositoryDateList[0]);
		int repositoryMonth = Integer.parseInt(repositoryDateList[1]);
		int repositoryDay = Integer.parseInt(repositoryDateList[2]);
		int compareYear = 0;
		int compareMonth = 0;
		int compareDay = 0;
		String comparator = "";

		try {

			// Sacamos la comparación a hacer
			if (compareDate.substring(1, 2).equals("=")
					&& (compareDate.substring(0, 1).equals("<") || compareDate.substring(0, 1).equals(">"))) {

				comparator = compareDate.substring(0, 2);
				compareYear = Integer.parseInt(compareDateList[0].substring(2));
				compareMonth = Integer.parseInt(compareDateList[1].substring(0));
				compareDay = Integer.parseInt(compareDateList[2].substring(0));

				// Comparamos
				if (comparator.substring(0, 1).equals("<")) {

					if (repositoryYear > compareYear) {

						dateValid = false;

					} else if (repositoryYear == compareYear) {

						if (repositoryMonth > compareMonth) {

							dateValid = false;

						} else if (repositoryMonth == compareMonth) {

							if (repositoryDay > compareDay) {

								dateValid = false;

							}

						}

					}

				} else if (comparator.substring(0, 1).equals(">")) {

					if (repositoryYear < compareYear) {

						dateValid = false;

					} else if (repositoryYear == compareYear) {

						if (repositoryMonth < compareMonth) {

							dateValid = false;

						} else if (repositoryMonth == compareMonth) {

							if (repositoryDay < compareDay) {

								dateValid = false;

							}

						}

					}

				} else {

					dateValid = false;

				}

			} else if (compareDate.substring(0, 1).equals("<") || compareDate.substring(0, 1).equals(">")) {

				comparator = compareDate.substring(0, 1);
				compareYear = Integer.parseInt(compareDateList[0].substring(1));
				compareMonth = Integer.parseInt(compareDateList[1].substring(0));
				compareDay = Integer.parseInt(compareDateList[2].substring(0));

				// Comparamos
				if (comparator.substring(0).equals("<")) {

					if (repositoryYear > compareYear) {

						dateValid = false;

					} else if (repositoryYear == compareYear) {

						if (repositoryMonth > compareMonth) {

							dateValid = false;

						} else if (repositoryMonth == compareMonth) {

							if (repositoryDay >= compareDay) {

								dateValid = false;

							}

						}

					}

				} else if (comparator.substring(0).equals(">")) {

					if (repositoryYear < compareYear) {

						dateValid = false;

					} else if (repositoryYear == compareYear) {

						if (repositoryMonth < compareMonth) {

							dateValid = false;

						} else if (repositoryMonth == compareMonth) {

							if (repositoryDay <= compareDay) {

								dateValid = false;

							}

						}

					}

				}

			} else {

				compareYear = Integer.parseInt(compareDateList[0].substring(0));
				compareMonth = Integer.parseInt(compareDateList[1].substring(0));
				compareDay = Integer.parseInt(compareDateList[2].substring(0));

				if (!(repositoryYear == compareYear && repositoryMonth == compareMonth
						&& repositoryDay == compareDay)) {

					dateValid = false;

				}

			}

		} catch (NumberFormatException e) {

			dateValid = false;

		} catch (Exception e) {

			dateValid = false;

		}

		return dateValid;

	}

	/**
	 * 
	 * Compara dos cantidades una en formato de cadena y la otra de tipo long.
	 * 
	 * @param repositoryQuantity. Cantidad de una propiedad del repositorio.
	 * @param compareQuantity.    Cantidad a comparar.
	 * @return True si se cumple la comparación, false en caso contrario.
	 */
	private boolean compareQuantityString(Long repositoryQuantity, String compareQuantity) {

		boolean isValid = true;
		long qRepo = repositoryQuantity;
		long qComp = 0;
		String[] compareList = compareQuantity.split("\\.\\.");

		try {

			if (compareQuantity.contains("..")) {

				System.out.println("SPLIT ..: " + compareList.length);

				for (int i = 0; i < compareList.length; i++) {

					System.out.println("STRING: " + compareList[i]);

				}

				if (compareList.length != 2) {

					isValid = false;

				} else {

					qComp = Long.parseLong(compareList[0]);

					if (qRepo < qComp) {

						isValid = false;

					} else {

						qComp = Long.parseLong(compareList[1]);

						if (qRepo > qComp) {

							isValid = false;

						}

					}

				}

			} else if (compareQuantity.substring(1, 2).equals("=")) {

				if (compareQuantity.substring(0, 1).equals("<")) {

					qComp = Long.parseLong(compareQuantity.substring(2));

					if (qRepo > qComp) {

						isValid = false;

					}

				} else if (compareQuantity.substring(0, 1).equals(">")) {

					qComp = Long.parseLong(compareQuantity.substring(2));

					if (qRepo < qComp) {

						isValid = false;

					}

				} else {

					isValid = false;

				}

			} else if (compareQuantity.substring(0, 1).equals("<")) {

				qComp = Long.parseLong(compareQuantity.substring(1));

				if (qRepo >= qComp) {

					isValid = false;

				}

			} else if (compareQuantity.substring(0, 1).equals(">")) {

				qComp = Long.parseLong(compareQuantity.substring(1));

				if (qRepo <= qComp) {

					isValid = false;

				}

			} else {

				qComp = Long.parseLong(compareQuantity);

				if (qRepo != qComp) {

					isValid = false;

				}

			}

		} catch (NumberFormatException e) {

			isValid = false;

		} catch (Exception e) {

			isValid = false;

		}

		return isValid;

	}

}
