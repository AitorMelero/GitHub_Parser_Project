package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gpp.view.component.VColor;
import gpp.view.component.VSearchParamLabel;
import gpp.view.component.VSearchTextField;

/**
 * 
 * Clase que implementa el diseño de los parámetros de una búsqueda de
 * repositorios.
 * 
 * @author Aitor Melero
 *
 */
public class VQuery extends JPanel {

	JPanel ownerContainer; // contenedor para autores
	VSearchParamLabel ownerLabel; // etiqueta para autores
	VSearchTextField owner; // campo de texto para autores
	JPanel inRepositoryNameContainer; // contenedor para cadenas en el nombre del repositorio
	VSearchParamLabel inRepositoryNameLabel; // etiqueta para cadenas en el nombre del repositorio
	VSearchTextField inRepositoryName; // campo de texto para cadenas en el nombre del repositorio

	public VQuery() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(VColor.getWHITE_MAIN());

		ownerContainer = new JPanel();
		inRepositoryNameContainer = new JPanel();
		ownerLabel = new VSearchParamLabel("Propietarios del repositorio: ");
		owner = new VSearchTextField();
		ownerContainer.add(ownerLabel);
		ownerContainer.add(owner);
		inRepositoryNameLabel = new VSearchParamLabel("Palabras del nombre del repositorio: ");
		inRepositoryName = new VSearchTextField();
		inRepositoryNameContainer.add(inRepositoryNameLabel);
		inRepositoryNameContainer.add(inRepositoryName);
		this.add(ownerContainer);
		this.add(inRepositoryNameContainer);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el campo de texto de los propietarios del repositorio.
	 * 
	 * @return Campo de texto de propietarios del repositorio.
	 */
	public VSearchTextField getOwner() {
		return owner;
	}

	/**
	 * 
	 * Modifica el campo de texto de los propietarios del repositorio.
	 * 
	 * @param owner. Nuevo campo de texto de los propietarios del repositorio.
	 */
	public void setOwner(VSearchTextField owner) {
		this.owner = owner;
	}

	/**
	 * 
	 * Devuelve el campo de texto de las cadenas que aparecen en el nombre del
	 * repositorio.
	 * 
	 * @return Campo de texto de las cadenas que aparecen en el nombre del
	 *         repositorio.
	 */
	public VSearchTextField getInRepositoryName() {
		return inRepositoryName;
	}

	/**
	 * 
	 * Modifica el campo de texto de las cadenas que aparecen en el nombre del
	 * repositorio.
	 * 
	 * @param inRepositoryName. Nuevo campo de texto de las cadenas que aparecen en
	 *                          el nombre del repositorio.
	 */
	public void setInRepositoryName(VSearchTextField inRepositoryName) {
		this.inRepositoryName = inRepositoryName;
	}

}
