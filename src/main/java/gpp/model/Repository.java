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
	private String clonePath; // path donde está clonado el repositorio, null si no está clonado
	private String description; // descripción del repositorio
	private long starsNumber; // número de estrellas del repositorio
	private String license; // licencia del repositorio
	private String dateCreated; // fecha de creación
	private String dateUpdated; // fecha de actualización
	private int filesNumber; // número de ficheros del repositorio
	private Set<String> extensionsList; // lista con las extensiones que aparecen en el repositorio
	private long totalSize; // tamaño total del repositorio (sacado de la api y puede ser 0)
	private long avgSize; // tamaño medio de ficheros (en caso de un tamaño total de 0, será 0 la media)
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

		// Comprobamos si el repositorio está clonado
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
	 * Devuelve el path donde está clonado el repositorio.
	 * 
	 * @return Path donde está clonado el repositorio, null si no está clonado.
	 */
	public String getClonePath() {
		return clonePath;
	}

	/**
	 * 
	 * Modifica el path donde está clonado el repositorio.
	 * 
	 * @param clonePath. Path donde está clonado el repositorio.
	 */
	public void setClonePath(String clonePath) {
		this.clonePath = clonePath;
	}
	
	/**
	 * 
	 * Devuelve la descripción del repositorio.
	 * 
	 * @return Descripción del repositorio.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * Modifica la descripción del repositorio.
	 * 
	 * @param description. Descripción del repositorio.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * Devuelve el número de estrellas del repositorio.
	 * 
	 * @return Número de estrellas del repositorio.
	 */
	public long getStarsNumber() {
		return starsNumber;
	}

	/**
	 * 
	 * Modifica el número de estrellas del repositorio.
	 * 
	 * @param starsNumber. Número de estrellas del repositorio.
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
	 * Devuelve la cadena de la fecha de creación del repositorio.
	 * 
	 * @return Fecha de creación del repositorio.
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * 
	 * Modifica la fecha de creación del repositorio.
	 * 
	 * @param dateCreated. Fecha de creación del repositorio.
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 * Devuelve la cadena de la fecha de actualización del repositorio.
	 * 
	 * @return Fecha de actualización del repositorio.
	 */
	public String getDateUpdated() {
		return dateUpdated;
	}

	/**
	 * 
	 * Modifica la cadena de la fecha de actualización del repositorio.
	 * 
	 * @param dateUpdated. Fecha de actualización del repositorio.
	 */
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	/**
	 * 
	 * Devuelve el número de ficheros de un repositorio.
	 * 
	 * @return Número de ficheros del repositorio.
	 */
	public int getFilesNumber() {
		return filesNumber;
	}

	/**
	 * 
	 * Modifica el número de ficheros del repositorio
	 * 
	 * @param filesNumber. Número de ficheros del repositorio.
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
	 * Devuelve el tamaño total del repositorio en KBytes.
	 * 
	 * @return Tamaño total del repositorio en KBytes. Sacado de la API y puede ser
	 *         0 KB.
	 */
	public long getTotalSize() {
		return totalSize;
	}

	/**
	 * 
	 * Modifica el tamaño total del repositorio.
	 * 
	 * @param totalSize. Tamaño total del repositorio.
	 */
	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * 
	 * Devuelve el tamaño medio de ficheros del repositorio.
	 * 
	 * @return El tamaño medio de ficheros del repositorio. Como el tamaño total
	 *         puede ser 0, el tamaño medio también lo puede ser.
	 */
	public long getAvgSize() {
		return avgSize;
	}

	/**
	 * 
	 * Modifica el tamaño medio de los ficheros del repositorio.
	 * 
	 * @param avgSize. Tamaño medio de los ficheros del repositorio.
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
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Genera la información completa del repositorio.
	 * 
	 */
	public void generateFullInfo() {

		boolean repoIsClone = true;

		// Clonamos, si no está clonado el repositorio
		if (clonePath == null) {

			repoIsClone = false;

			cloneRepo();

		}

		// Recorremos el repositorio fichero a fichero
		File f = new File(clonePath);
		getFullInfo(f);
		// Calculamos el tamaño medio de ficheros
		avgSize = totalSize / filesNumber;

		// Borramos el repositorio si no estaba ya clonado
		if (!repoIsClone) {

			deleteCloneRepo(f);

			this.setClonePath(null);

		}

	}

	/**
	 * 
	 * Método para clonar el repositorio.
	 * 
	 */
	public void cloneRepo() {

		String repoUrl = "https://github.com/" + ownerName + "/" + name + ".git";
		User user = GPPSystem.getUser();
		String path = user.getClonePath() + ownerName + "/" + name + "/";

		// Comprobamos si el repositorio ya está clonado
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
	 * Método para eliminar repositorios clonados
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
	 * Método recursivo que saca toda la info del repositorio.
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

				// Sumamos el número de ficheros
				filesNumber++;

				// Guardamos las extensiones
				if (fileName.contains(".")) {

					extensionsList.add(fileName.substring(fileName.lastIndexOf(".") + 1));

				}

			}

		}

	}

}
