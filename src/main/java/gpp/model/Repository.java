package gpp.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import gpp.GPPSystem;

/**
 * 
 * Clase que implementa un repositorio.
 * 
 * @author AitorMelero.
 *
 */
public class Repository {

	private String ownerName; // nombre del propietario del repositorio
	private String name; // nombre del repositorio
	private String clonePath; // path donde est� clonado el repositorio, null si no est� clonado
	private String description; // descripci�n del repositorio
	private long starsNumber; // n�mero de estrellas del repositorio
	private String license; // licencia del repositorio
	private String dateCreated; // fecha de creaci�n
	private String dateUpdated; // fecha de actualizaci�n
	private int filesNumber; // n�mero de ficheros del repositorio
	private Set<String> extensionsList; // lista con las extensiones que aparecen en el repositorio
	private long totalSize; // tama�o total del repositorio (sacado de la api y puede ser 0)
	private long avgSize; // tama�o medio de ficheros (en caso de un tama�o total de 0, ser� 0 la media)
	private String mainLanguage; // lenguaje principal del repositorio

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 * @param ownerName. Propietario del repositorio.
	 * @param name.      Nombre del repositorio.
	 */
	public Repository(String ownerName, String name) {

		this.ownerName = ownerName;
		this.name = name;

		// Comprobamos si el repositorio est� clonado
		String path = GPPSystem.getUser().getClonePath() + ownerName + "/" + name + "/";
		File file = new File(path);
		if (file.isDirectory()) {

			this.clonePath = path;

		} else {

			this.clonePath = null;

		}

		this.description = "";
		this.starsNumber = 0;
		this.license = "";
		this.dateCreated = "";
		this.dateUpdated = "";
		this.filesNumber = 0;
		this.extensionsList = new HashSet<String>();
		this.totalSize = 0;
		this.avgSize = 0;
		this.mainLanguage = null;

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el nombre del propietario del repositorio.
	 * 
	 * @return Nombre del propietarios del repositorio.
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * 
	 * Modifica el nombre del propietario del repositorio.
	 * 
	 * @param ownerName. Nuevo nombre del propietario del repositorio.
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * 
	 * Devuelve el nombre del repositorio.
	 * 
	 * @return Nombre del repositorio.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Modifica el nombre del repositorio.
	 * 
	 * @param name. Nuevo nombre del repositorio.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Devuelve el path donde est� clonado el repositorio.
	 * 
	 * @return Path donde est� clonado el repositorio, null si no est� clonado.
	 */
	public String getClonePath() {
		return clonePath;
	}

	/**
	 * 
	 * Modifica el path donde est� clonado el repositorio.
	 * 
	 * @param clonePath. Path donde est� clonado el repositorio.
	 */
	public void setClonePath(String clonePath) {
		this.clonePath = clonePath;
	}
	
	/**
	 * 
	 * Devuelve la descripci�n del repositorio.
	 * 
	 * @return Descripci�n del repositorio.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * Modifica la descripci�n del repositorio.
	 * 
	 * @param description. Descripci�n del repositorio.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * Devuelve el n�mero de estrellas del repositorio.
	 * 
	 * @return N�mero de estrellas del repositorio.
	 */
	public long getStarsNumber() {
		return starsNumber;
	}

	/**
	 * 
	 * Modifica el n�mero de estrellas del repositorio.
	 * 
	 * @param starsNumber. N�mero de estrellas del repositorio.
	 */
	public void setStarsNumber(long starsNumber) {
		this.starsNumber = starsNumber;
	}
	
	/**
	 * 
	 * Devuelve la licencia del repositorio.
	 * 
	 * @return Licencia del repositorio.
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * 
	 * Modifica la licencia del repositorio.
	 * 
	 * @param license. Licencia del repositorio.
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	
	/**
	 * 
	 * Devuelve la cadena de la fecha de creaci�n del repositorio.
	 * 
	 * @return Fecha de creaci�n del repositorio.
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * 
	 * Modifica la fecha de creaci�n del repositorio.
	 * 
	 * @param dateCreated. Fecha de creaci�n del repositorio.
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 * Devuelve la cadena de la fecha de actualizaci�n del repositorio.
	 * 
	 * @return Fecha de actualizaci�n del repositorio.
	 */
	public String getDateUpdated() {
		return dateUpdated;
	}

	/**
	 * 
	 * Modifica la cadena de la fecha de actualizaci�n del repositorio.
	 * 
	 * @param dateUpdated. Fecha de actualizaci�n del repositorio.
	 */
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	/**
	 * 
	 * Devuelve el n�mero de ficheros de un repositorio.
	 * 
	 * @return N�mero de ficheros del repositorio.
	 */
	public int getFilesNumber() {
		return filesNumber;
	}

	/**
	 * 
	 * Modifica el n�mero de ficheros del repositorio
	 * 
	 * @param filesNumber. N�mero de ficheros del repositorio.
	 */
	public void setFilesNumber(int filesNumber) {
		this.filesNumber = filesNumber;
	}

	/**
	 * 
	 * Devuelve la lista de extensiones del repositorio.
	 * 
	 * @return Lista de extensiones del repositorio.
	 */
	public Set<String> getExtensionsList() {
		return extensionsList;
	}

	/**
	 * 
	 * Modifica la lista de extensiones del repositorio
	 * 
	 * @param extensionsList. Lista de extensiones del repositorio.
	 */
	public void setExtensionsList(Set<String> extensionsList) {
		this.extensionsList = extensionsList;
	}

	/**
	 * 
	 * Devuelve el tama�o total del repositorio en KBytes.
	 * 
	 * @return Tama�o total del repositorio en KBytes. Sacado de la API y puede ser
	 *         0 KB.
	 */
	public long getTotalSize() {
		return totalSize;
	}

	/**
	 * 
	 * Modifica el tama�o total del repositorio.
	 * 
	 * @param totalSize. Tama�o total del repositorio.
	 */
	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * 
	 * Devuelve el tama�o medio de ficheros del repositorio.
	 * 
	 * @return El tama�o medio de ficheros del repositorio. Como el tama�o total
	 *         puede ser 0, el tama�o medio tambi�n lo puede ser.
	 */
	public long getAvgSize() {
		return avgSize;
	}

	/**
	 * 
	 * Modifica el tama�o medio de los ficheros del repositorio.
	 * 
	 * @param avgSize. Tama�o medio de los ficheros del repositorio.
	 */
	public void setAvgSize(long avgSize) {
		this.avgSize = avgSize;
	}

	/**
	 * 
	 * Devuelve el lenguaje principal del repositorio, sacado de la API.
	 * 
	 * @return Lenguaje principal del repositorio.
	 */
	public String getMainLanguage() {
		return mainLanguage;
	}

	/**
	 * 
	 * Modifica el lenguaje principal del repositorio.
	 * 
	 * @param mainLanguage. Lenguaje principal del repositorio.
	 */
	public void setMainLanguage(String mainLanguage) {
		this.mainLanguage = mainLanguage;
	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Genera la informaci�n completa del repositorio.
	 * 
	 */
	public void generateFullInfo() {

		boolean repoIsClone = true;

		// Clonamos, si no est� clonado el repositorio
		if (clonePath == null) {

			repoIsClone = false;

			cloneRepo();

		}

		// Recorremos el repositorio fichero a fichero
		File f = new File(clonePath);
		getFullInfo(f);
		// Calculamos el tama�o medio de ficheros
		avgSize = totalSize / filesNumber;

		// Borramos el repositorio si no estaba ya clonado
		if (!repoIsClone) {

			deleteCloneRepo(f);

			this.setClonePath(null);

		}

	}

	/**
	 * 
	 * M�todo para clonar el repositorio.
	 * 
	 */
	public void cloneRepo() {

		String repoUrl = "https://github.com/" + ownerName + "/" + name + ".git";
		User user = GPPSystem.getUser();
		String path = user.getClonePath() + ownerName + "/" + name + "/";

		// Comprobamos si el repositorio ya est� clonado
		if (clonePath == null) {

			this.setClonePath(path);

			CredentialsProvider cp = new UsernamePasswordCredentialsProvider(user.getUsername(), user.getToken());

			try {

				// System.out.println("Cloning " + repoUrl + " into " + path);
				Git.cloneRepository().setCredentialsProvider(cp).setURI(repoUrl).setDirectory(Paths.get(path).toFile())
						.call().close();
				// System.out.println("Completed Cloning");

			} catch (GitAPIException e) {

				System.out.println("Exception occurred while cloning repo");
				e.printStackTrace();
				this.setClonePath(null);

			}

		}

	}

	/**
	 * 
	 * M�todo para eliminar repositorios clonados
	 * 
	 */
	private void deleteCloneRepo(File f) {

		if (f.isDirectory()) {
			for (File c : f.listFiles()) {
				deleteCloneRepo(c);
			}
		}

		if (!f.delete()) {
			System.out.println("NO SE PUEDE BORRAR: " + f.getName());
		}

	}

	/**
	 * 
	 * M�todo recursivo que saca toda la info del repositorio.
	 * 
	 * @param f. Fichero o directorio a analizar.
	 */
	private void getFullInfo(File f) {

		String fileName = f.getName();

		if (!fileName.equals(".git")) {

			if (f.isDirectory()) {

				for (File c : f.listFiles()) {
					getFullInfo(c);
				}

			} else {

				// Sumamos el n�mero de ficheros
				filesNumber++;

				// Guardamos las extensiones
				if (fileName.contains(".")) {

					extensionsList.add(fileName.substring(fileName.lastIndexOf(".") + 1));

				}

			}

		}

	}

}
