package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gpp.view.component.VSearchFieldContainer;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

/**
 * 
 * Clase que implementa el diseño de los parámetros de una búsqueda de
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
	private VSearchFieldContainer descriptionField; // cadena que aparece en la descripción del repositorio
	private VSearchFieldContainer inReadmeField; // campo para las palabras que aparecen en el Readme del repositorio
	private VSearchFieldContainer createdField; // campo de fecha de creación del repositorio
	private VSearchFieldContainer updatedField; // campo de fecha de actualización del repositorio
	private VSearchFieldContainer mainLanguageField; // campo con el lenguaje principal del repositorio
	private VSearchFieldContainer starsNumberField; // campo con el número de estrellas del repositorio
	private VSearchFieldContainer forksNumberField; // campo con el número de forks del repositorio
	private VSearchFieldContainer followersNumberField; // campo con el número de seguidores del repositorio
	private VSearchFieldContainer sizeField; // campo con el número de KB del repositorio
	private VSearchFieldContainer licenseField; // campo con la licencia del repositorio
	private VSearchFieldContainer topicsField; // campo para los topics del repositorio
	private VSearchFieldContainer topicsNumberField; // campo con el número de topics del repositorio

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

		descriptionField = new VSearchFieldContainer("Palabras en la descripción", "");
		container.add(descriptionField);

		inReadmeField = new VSearchFieldContainer("Palabras en el Readme", "");
		container.add(inReadmeField);

		createdField = new VSearchFieldContainer("Fecha de creación", "");
		container.add(createdField);

		updatedField = new VSearchFieldContainer("Fecha del último push", "");
		container.add(updatedField);

		mainLanguageField = new VSearchFieldContainer("Lenguaje principal", "");
		container.add(mainLanguageField);

		starsNumberField = new VSearchFieldContainer("Número de estrellas", "");
		container.add(starsNumberField);

		forksNumberField = new VSearchFieldContainer("Número de forks", "");
		container.add(forksNumberField);

		followersNumberField = new VSearchFieldContainer("Número de seguidores", "");
		container.add(followersNumberField);

		sizeField = new VSearchFieldContainer("Tamaño en KB", "");
		container.add(sizeField);

		licenseField = new VSearchFieldContainer("Licencia", "");
		container.add(licenseField);

		topicsField = new VSearchFieldContainer("Topics", "");
		container.add(topicsField);

		topicsNumberField = new VSearchFieldContainer("Número de topics", "");
		container.add(topicsNumberField);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el contenedor para el parámetro de autores del repositorio.
	 * 
	 * @return Contenedor para parámetro de autores del repositorio.
	 */
	public VSearchFieldContainer getOwnerField() {
		return ownerField;
	}

	/**
	 * 
	 * Devuelve el contenedor para el parámetro de cadenas en el nombre del
	 * repositorio.
	 * 
	 * @return Contenedor para parámetro de cadenas en el nombre del repositorio.
	 */
	public VSearchFieldContainer getInRepositoryNameField() {
		return inRepositoryNameField;
	}

	/**
	 * 
	 * Devuelve el contenedor para el parámetro del nombre del repositorio.
	 * 
	 * @return Contenedor con el nombre del repositorio.
	 */
	public VSearchFieldContainer getRepositoryField() {
		return repositoryField;
	}

	/**
	 * 
	 * Devuelve el contenedor para los parámetros de las palabras de la descripción
	 * del repositorio.
	 * 
	 * @return Campo con palabras de la descripción del repositorio.
	 */
	public VSearchFieldContainer getDescriptionField() {
		return descriptionField;
	}

	/**
	 * 
	 * Devuelve el contenedor para los parámetros de las palabras del Readme del
	 * repositorio.
	 * 
	 * @return Campo con las palabras que aparecen en el Readme del repositorio.
	 */
	public VSearchFieldContainer getInReadmeField() {
		return inReadmeField;
	}

	/**
	 * 
	 * Devuelve el contenedor para los parámetros de la fecha de creación del
	 * repositorio.
	 * 
	 * @return Contenedor con los parámetros con la fecha de creación del
	 *         repositorio.
	 */
	public VSearchFieldContainer getCreatedField() {
		return createdField;
	}

	/**
	 * 
	 * Devuelve el contenedor para los parámetros de la fecha de actualización del
	 * repositorio.
	 * 
	 * @return Contenedor con los parámetros con la fecha de actualización del
	 *         repositorio.
	 */
	public VSearchFieldContainer getUpdatedField() {
		return updatedField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el lenguaje principal del repositorio.
	 * 
	 * @return Contenedor con el lenguaje principal del repositorio.
	 */
	public VSearchFieldContainer getMainLanguageField() {
		return mainLanguageField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el número de estrellas del repositorio.
	 * 
	 * @return Contenedor con el número de estrellas del repositorio.
	 */
	public VSearchFieldContainer getStarsNumberField() {
		return starsNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el número de forks del repositorio.
	 * 
	 * @return Contenedor con el número de forks del repositorio.
	 */
	public VSearchFieldContainer getForksNumberField() {
		return forksNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el número de seguidores del repositorio.
	 * 
	 * @return Contenedor con el número de seguidores del repositorio.
	 */
	public VSearchFieldContainer getFollowersNumberField() {
		return followersNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el número en KB del repositorio.
	 * 
	 * @return Contenedor con el número en KB del repositorio.
	 */
	public VSearchFieldContainer getSizeField() {
		return sizeField;
	}

	/**
	 * 
	 * Devuelve el contenedor con la licencia del repositorio.
	 * 
	 * @return Contenedor con la licencia del repositorio.
	 */
	public VSearchFieldContainer getLicenseField() {
		return licenseField;
	}

	/**
	 * 
	 * Devuelve el contenedor con los topics del repositorio.
	 * 
	 * @return Contenedor con los topics del repositorio.
	 */
	public VSearchFieldContainer getTopicsField() {
		return topicsField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el número de topics del repositorio.
	 * 
	 * @return Contenedor con el número de topics del repositorio.
	 */
	public VSearchFieldContainer getTopicsNumberField() {
		return topicsNumberField;
	}

}
