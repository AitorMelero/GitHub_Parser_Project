package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gpp.view.component.VSearchFieldContainer;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

/**
 * 
 * Clase que implementa el diseño de los filtros generales de una búsqueda de
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
	private VSearchFieldContainer descriptionField; // campo de filtro de palabras en la descripción del repositorio
	private VSearchFieldContainer createdDateField; // campo de filtro de fecha de creación del repositorio
	private VSearchFieldContainer updatedDateField; // campo de filtro de fecha de actualización del repositorio
	private VSearchFieldContainer mainLanguageField; // campo de filtro de lenguaje principal del repositorio
	private VSearchFieldContainer starsNumberField; // campo de filtro de número de estrellas del repositorio
	private VSearchFieldContainer forksNumberField; // campo de filtro de número de forks del repositorio
	private VSearchFieldContainer sizeField; // campo de filtro para el tamaño del repositorio
	private VSearchFieldContainer licenseField; // campo de filtro para la licencia del repositorio
	private VSearchFieldContainer topicsField; // campo de filtro para los topics
	private VSearchFieldContainer topicsNumberField; // campo de filtro para número de topics

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

		descriptionField = new VSearchFieldContainer("Palabras en la descripción", "");
		container.add(descriptionField);

		createdDateField = new VSearchFieldContainer("Fecha de creación", "");
		container.add(createdDateField);

		updatedDateField = new VSearchFieldContainer("Fecha del último push", "");
		container.add(updatedDateField);

		mainLanguageField = new VSearchFieldContainer("Lenguaje principal", "");
		container.add(mainLanguageField);

		starsNumberField = new VSearchFieldContainer("Número de estrellas", "");
		container.add(starsNumberField);

		forksNumberField = new VSearchFieldContainer("Número de forks", "");
		container.add(forksNumberField);

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
	 * Devuelve el contenedor para los parámetros del filtro de cadenas en la
	 * descripción del repositorio.
	 * 
	 * @return Contenedor para los parámetros del filtro de cadenas en la
	 *         descripción del repositorio.
	 */
	public VSearchFieldContainer getDescriptionField() {
		return descriptionField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro de la fecha de creación.
	 * 
	 * @return Contenedor con la fecha de creación.
	 */
	public VSearchFieldContainer getCreatedDateField() {
		return createdDateField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro de la fecha del último push.
	 * 
	 * @return Contenedor con la fecha del último push.
	 */
	public VSearchFieldContainer getUpdatedDateField() {
		return updatedDateField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro del lenguaje principal.
	 * 
	 * @return Contenedor con el filtro del lenguaje principal.
	 */
	public VSearchFieldContainer getMainLanguageField() {
		return mainLanguageField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro de número de estreallas.
	 * 
	 * @return Contenedor con el filtro de número de estrellas.
	 */
	public VSearchFieldContainer getStarsNumberField() {
		return starsNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro de número de forks.
	 * 
	 * @return Contenedor con el filtro de número de forks.
	 */
	public VSearchFieldContainer getForksNumberField() {
		return forksNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro del tamaño.
	 * 
	 * @return Contenedor con el filtro del tamaño.
	 */
	public VSearchFieldContainer getSizeField() {
		return sizeField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro de la licencia.
	 * 
	 * @return Contenedor con el filtro de la licencia.
	 */
	public VSearchFieldContainer getLicenseField() {
		return licenseField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro de los topics.
	 * 
	 * @return Contenedor con el filtro de los topics.
	 */
	public VSearchFieldContainer getTopicsField() {
		return topicsField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro del número de topics.
	 * 
	 * @return Contenedor con el filtro del número de topics.
	 */
	public VSearchFieldContainer getTopicsNumberField() {
		return topicsNumberField;
	}

}
