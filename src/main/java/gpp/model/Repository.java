package gpp.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

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
	private int filesNumber; // número de ficheros del repositorio

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
		
		this.filesNumber = 0;

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

		// Clonamos, si no está ya clonado el repositorio
		if (clonePath == null) {
			
			repoIsClone = false;

			cloneRepo();

		}

		// Recorremos el repositorio fichero a fichero

		// Borramos el repositorio si no estaba ya clonado
		if (!repoIsClone) {
			
			//deleteCloneRepo();
			
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
		
		this.setClonePath(path);

		CredentialsProvider cp = new UsernamePasswordCredentialsProvider(user.getUsername(), user.getToken());

		try {

			System.out.println("Cloning " + repoUrl + " into " + path);
			Git.cloneRepository().setCredentialsProvider(cp).setURI(repoUrl).setDirectory(Paths.get(path).toFile()).call();
			System.out.println("Completed Cloning");

		} catch (GitAPIException e) {

			System.out.println("Exception occurred while cloning repo");
			e.printStackTrace();
			this.setClonePath(null);

		}

	}

	public void deleteCloneRepo() {

		try {
			Files.walk(Paths.get(clonePath)).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
			this.setClonePath(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
