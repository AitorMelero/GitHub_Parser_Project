package gpp.model;

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

	public Repository(String ownerName, String name) {

		this.ownerName = ownerName;
		this.name = name;

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

}
