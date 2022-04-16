package gpp.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
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
	private int filesNumber; // número de ficheros del repositorio
	private Set<String> extensionsList;  // lista con las extensiones que aparecen en el repositorio

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
		this.extensionsList = new HashSet<String>();

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
				// Añadimos las extensiones de los ficheros
				/*String[] nameParts = fileName.split(".");
				if (nameParts.length > 0) {
					extensionsList.add(nameParts[nameParts.length-1]);
				} else {
					System.out.println("FICHERO: " + fileName);
				}*/
				
				// Guardamos las extensiones
				String ext = "";
				if (fileName.contains(".")) {
					
					extensionsList.add(fileName.substring(fileName.lastIndexOf(".") + 1));
					ext = fileName.substring(fileName.lastIndexOf(".") + 1);
					
				}
				
				try {
					// Sacamos el tamaño del fichero
					long tam = Files.size(Paths.get(f.getPath()));
					if (ext.equals("java")) {
					//if (tam >= 300000 || aux.equals("classpath") || aux.equals("gitignore") || aux.equals("project") || aux.equals("gitattributes")) {
						System.out.println("FILE: " + fileName + ", SIZE: " + tam);
						filesNumber--;
					}
				} catch (IOException e) {

					e.printStackTrace();
					
				}
				
				// jpg -> 1
				// css -> 4
				// classpath -> nan
				// gitignore -> nan
				// png -> 18
				// project -> nan
				// js -> 9
				// gitattributes -> nan
				// g4 -> 5
				// prefs -> 1
				// gradle -> 2
				// drawio -> 3
				// java -> 27
				// bat -> 1
				// tokens -> 6
				// html -> 740
				// jar -> 1
				// class -> 326
				// properties -> 1

			}

		}

	}

}
