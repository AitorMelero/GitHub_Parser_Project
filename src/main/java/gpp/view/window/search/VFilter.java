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
	private VSearchFieldContainer updatedDateField; // campo de filtro de fecha de actualizaci�n del repositorio
	private VSearchFieldContainer mainLanguageField; // campo de filtro de lenguaje principal del repositorio
	private VSearchFieldContainer starsNumberField; // campo de filtro de n�mero de estrellas del repositorio
	private VSearchFieldContainer forksNumberField; // campo de filtro de n�mero de forks del repositorio
	private VSearchFieldContainer sizeField; // campo de filtro para el tama�o del repositorio
	private VSearchFieldContainer licenseField; // campo de filtro para la licencia del repositorio
	private VSearchFieldContainer topicsField; // campo de filtro para los topics
	private VSearchFieldContainer topicsNumberField; // campo de filtro para n�mero de topics

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

		updatedDateField = new VSearchFieldContainer("Fecha del �ltimo push", "");
		container.add(updatedDateField);

		mainLanguageField = new VSearchFieldContainer("Lenguaje principal", "");
		container.add(mainLanguageField);

		starsNumberField = new VSearchFieldContainer("N�mero de estrellas", "");
		container.add(starsNumberField);

		forksNumberField = new VSearchFieldContainer("N�mero de forks", "");
		container.add(forksNumberField);

		sizeField = new VSearchFieldContainer("Tama�o en KB", "");
		container.add(sizeField);

		licenseField = new VSearchFieldContainer("Licencia", "");
		container.add(licenseField);

		topicsField = new VSearchFieldContainer("Topics", "");
		container.add(topicsField);

		topicsNumberField = new VSearchFieldContainer("N�mero de topics", "");
		container.add(topicsNumberField);

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

	/**
	 * 
	 * Devuelve el contenedor con el filtro de la fecha del �ltimo push.
	 * 
	 * @return Contenedor con la fecha del �ltimo push.
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
	 * Devuelve el contenedor con el filtro de n�mero de estreallas.
	 * 
	 * @return Contenedor con el filtro de n�mero de estrellas.
	 */
	public VSearchFieldContainer getStarsNumberField() {
		return starsNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro de n�mero de forks.
	 * 
	 * @return Contenedor con el filtro de n�mero de forks.
	 */
	public VSearchFieldContainer getForksNumberField() {
		return forksNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el filtro del tama�o.
	 * 
	 * @return Contenedor con el filtro del tama�o.
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
	 * Devuelve el contenedor con el filtro del n�mero de topics.
	 * 
	 * @return Contenedor con el filtro del n�mero de topics.
	 */
	public VSearchFieldContainer getTopicsNumberField() {
		return topicsNumberField;
	}

}
