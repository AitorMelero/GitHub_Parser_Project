package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gpp.view.component.VSearchFieldContainer;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

/**
 * 
 * Clase que implementa el dise�o de los filtros generales de una b�squeda de
 * repositorios.
 * 
 * @author Aitor Melero
 *
 */
public class VFilter extends JPanel {

	private JScrollPane scrollContainer; // contenedor con scroll general
	private JPanel container; // contenedor dentro del scroll
	private VSearchFieldContainer ownerField; // campo de filtro de autores
	private VSearchFieldContainer inRepositoryNameField; // campo de filtro de palabras en nombre del repositorio
	private VSearchFieldContainer descriptionField; // campo de filtro de palabras en la descripci�n del repositorio
	private VSearchFieldContainer createdDateField; // campo de filtro de fecha de creaci�n del repositorio

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * Constructor
	 */
	public VFilter() {
		setLayout(new BorderLayout(0, 0));
		setBounds(20, 144, 807, 319);

		scrollContainer = new JScrollPane();
		scrollContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollContainer);

		container = new JPanel();
		scrollContainer.setViewportView(container);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		ownerField = new VSearchFieldContainer("Autores del repositorio", "");
		container.add(ownerField);

		inRepositoryNameField = new VSearchFieldContainer("En el repositorio", "");
		container.add(inRepositoryNameField);

		descriptionField = new VSearchFieldContainer("Palabras en la descripci�n", "");
		container.add(descriptionField);

		createdDateField = new VSearchFieldContainer("Fecha de creaci�n", "");
		container.add(createdDateField);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el contenedor para el par�metro de autores del repositorio.
	 * 
	 * @return Contenedor para par�metro de autores del repositorio.
	 */
	public VSearchFieldContainer getOwnerField() {
		return ownerField;
	}

	/**
	 * 
	 * Devuelve el contenedor para el par�metro de cadenas en el nombre del
	 * repositorio.
	 * 
	 * @return Contenedor para par�metro de cadenas en el nombre del repositorio.
	 */
	public VSearchFieldContainer getInRepositoryNameField() {
		return inRepositoryNameField;
	}

	/**
	 * 
	 * Devuelve el contenedor para los par�metros del filtro de cadenas en la
	 * descripci�n del repositorio.
	 * 
	 * @return Contenedor para los par�metros del filtro de cadenas en la
	 *         descripci�n del repositorio.
	 */
	public VSearchFieldContainer getDescriptionField() {
		return descriptionField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro de la fecha de creaci�n.
	 * 
	 * @return Contenedor con la fecha de creaci�n.
	 */
	public VSearchFieldContainer getCreatedDateField() {
		return createdDateField;
	}

}
