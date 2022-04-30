package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gpp.view.component.VSearchFieldContainer;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * 
 * Clase que implementa el dise�o de los par�metros de una b�squeda de
 * repositorios.
 * 
 * @author Aitor Melero
 *
 */
public class VQuery extends JPanel {

	private JScrollPane scrollContainer; // contenedor con scroll general
	private JPanel container; // contenedor dentro del scroll
	private VSearchFieldContainer ownerField; // campo de autores
	private VSearchFieldContainer inRepositoryNameField; // campo de palabras en nombre del repositorio
	private VSearchFieldContainer repositoryField; // autor y nombre del repositorio
	private VSearchFieldContainer descriptionField; // cadena que aparece en la descripci�n del repositorio
	private VSearchFieldContainer inReadmeField; // campo para las palabras que aparecen en el Readme del repositorio
	private VSearchFieldContainer createdField; // campo de fecha de creaci�n del repositorio
	private VSearchFieldContainer updatedField; // campo de fecha de actualizaci�n del repositorio

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * Constructor
	 */
	public VQuery() {
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

		repositoryField = new VSearchFieldContainer("Autor/Nombre del repositorio", "");
		container.add(repositoryField);

		descriptionField = new VSearchFieldContainer("Palabras en la descripci�n", "");
		container.add(descriptionField);

		inReadmeField = new VSearchFieldContainer("Palabras en el Readme", "");
		container.add(inReadmeField);

		createdField = new VSearchFieldContainer("Fecha de creaci�n", "");
		container.add(createdField);

		updatedField = new VSearchFieldContainer("Fecha del �ltimo push", "");
		container.add(updatedField);

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
	 * Devuelve el contenedor para el par�metro del nombre del repositorio.
	 * 
	 * @return Contenedor con el nombre del repositorio.
	 */
	public VSearchFieldContainer getRepositoryField() {
		return repositoryField;
	}

	/**
	 * 
	 * Devuelve el contenedor para los par�metros de las palabras de la descripci�n
	 * del repositorio.
	 * 
	 * @return Campo con palabras de la descripci�n del repositorio.
	 */
	public VSearchFieldContainer getDescriptionField() {
		return descriptionField;
	}

	/**
	 * 
	 * Devuelve el contenedor para los par�metros de las palabras del Readme del
	 * repositorio.
	 * 
	 * @return Campo con las palabras que aparecen en el Readme del repositorio.
	 */
	public VSearchFieldContainer getInReadmeField() {
		return inReadmeField;
	}

	/**
	 * 
	 * Devuelve el contenedor para los par�metros de la fecha de creaci�n del
	 * repositorio.
	 * 
	 * @return Contenedor con los par�metros con la fecha de creaci�n del
	 *         repositorio.
	 */
	public VSearchFieldContainer getCreatedField() {
		return createdField;
	}

	/**
	 * 
	 * Devuelve el contenedor para los par�metros de la fecha de actualizaci�n del
	 * repositorio.
	 * 
	 * @return Contenedor con los par�metros con la fecha de actualizaci�n del
	 *         repositorio.
	 */
	public VSearchFieldContainer getUpdatedField() {
		return updatedField;
	}

}
