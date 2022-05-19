package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gpp.view.component.VSearchFieldContainer;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Point;

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
	private VSearchFieldContainer mainLanguageField; // campo con el lenguaje principal del repositorio
	private VSearchFieldContainer starsNumberField; // campo con el n�mero de estrellas del repositorio
	private VSearchFieldContainer forksNumberField; // campo con el n�mero de forks del repositorio
	private VSearchFieldContainer followersNumberField; // campo con el n�mero de seguidores del repositorio
	private VSearchFieldContainer sizeField; // campo con el n�mero de KB del repositorio
	private VSearchFieldContainer licenseField; // campo con la licencia del repositorio
	private VSearchFieldContainer topicsField; // campo para los topics del repositorio
	private VSearchFieldContainer topicsNumberField; // campo con el n�mero de topics del repositorio
	private VSearchFieldContainer sortOptionField; // campo de tipo de orden de los resultados
	private VSearchFieldContainer orderOptionField; // campo de tipo de orden ascendente o descendente de los resultados
	private VSearchFieldContainer repositoriesMaxNumberField; // n�mero m�ximo de repositorios a buscar

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
		ownerField.getParamTextField().addPlaceholder("github, atom, electron, octokit");
		container.add(ownerField);

		inRepositoryNameField = new VSearchFieldContainer("En el repositorio", "");
		inRepositoryNameField.getParamTextField().addPlaceholder("javascript, artificial, software");
		container.add(inRepositoryNameField);

		repositoryField = new VSearchFieldContainer("Autor/Nombre del repositorio", "");
		repositoryField.getParamTextField().addPlaceholder("twbs/bootstrap, rails/rails");
		container.add(repositoryField);

		descriptionField = new VSearchFieldContainer("Palabras en la descripci�n", "");
		descriptionField.getParamTextField().addPlaceholder("javascript, artificial, software");
		container.add(descriptionField);

		inReadmeField = new VSearchFieldContainer("Palabras en el Readme", "");
		inReadmeField.getParamTextField().addPlaceholder("javascript, artificial, software");
		container.add(inReadmeField);

		createdField = new VSearchFieldContainer("Fecha de creaci�n", "");
		createdField.getParamTextField().addPlaceholder(">YYYY-MM-DD, YYYY-MM-DD");
		container.add(createdField);

		updatedField = new VSearchFieldContainer("Fecha del �ltimo push", "");
		updatedField.getParamTextField().addPlaceholder(">YYYY-MM-DD, YYYY-MM-DD");
		container.add(updatedField);

		mainLanguageField = new VSearchFieldContainer("Lenguaje principal", "");
		mainLanguageField.getParamTextField().addPlaceholder("Java, Python, HTML, C");
		container.add(mainLanguageField);

		starsNumberField = new VSearchFieldContainer("N�mero de estrellas", "");
		starsNumberField.getParamTextField().addPlaceholder("0..100, 200, >1000");
		container.add(starsNumberField);

		forksNumberField = new VSearchFieldContainer("N�mero de forks", "");
		forksNumberField.getParamTextField().addPlaceholder("50..100, 200, <5");
		container.add(forksNumberField);

		followersNumberField = new VSearchFieldContainer("N�mero de seguidores", "");
		followersNumberField.getParamTextField().addPlaceholder("0..100, 200, >1000");
		container.add(followersNumberField);

		sizeField = new VSearchFieldContainer("Tama�o en KB", "");
		sizeField.getParamTextField().addPlaceholder("0..100, 200, >1000");
		container.add(sizeField);

		licenseField = new VSearchFieldContainer("Licencia", "");
		licenseField.getParamTextField().addPlaceholder("MIT, PostgreSQL, ISC");
		container.add(licenseField);

		topicsField = new VSearchFieldContainer("Topics", "");
		topicsField.getParamTextField().addPlaceholder("Java, Python, HTML, C");
		container.add(topicsField);

		topicsNumberField = new VSearchFieldContainer("N�mero de topics", "");
		topicsNumberField.getParamTextField().addPlaceholder("50..100, 200, <5");
		container.add(topicsNumberField);

		sortOptionField = new VSearchFieldContainer("Ordenar por", "");
		sortOptionField.getParamTextField().addPlaceholder("stars, forks, updated or best-match");
		container.add(sortOptionField);

		orderOptionField = new VSearchFieldContainer("Orden descendente o ascendente", "");
		orderOptionField.getParamTextField().addPlaceholder("desc or asc");
		container.add(orderOptionField);

		repositoriesMaxNumberField = new VSearchFieldContainer("N�mero m�ximo de repositorios (1000 m�x.)", "");
		repositoriesMaxNumberField.getParamTextField().addPlaceholder("Default 50, max. 1000");
		container.add(repositoriesMaxNumberField);

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
	 * Devuelve el contenedor con el n�mero de estrellas del repositorio.
	 * 
	 * @return Contenedor con el n�mero de estrellas del repositorio.
	 */
	public VSearchFieldContainer getStarsNumberField() {
		return starsNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el n�mero de forks del repositorio.
	 * 
	 * @return Contenedor con el n�mero de forks del repositorio.
	 */
	public VSearchFieldContainer getForksNumberField() {
		return forksNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el n�mero de seguidores del repositorio.
	 * 
	 * @return Contenedor con el n�mero de seguidores del repositorio.
	 */
	public VSearchFieldContainer getFollowersNumberField() {
		return followersNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el n�mero en KB del repositorio.
	 * 
	 * @return Contenedor con el n�mero en KB del repositorio.
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
	 * Devuelve el contenedor con el n�mero de topics del repositorio.
	 * 
	 * @return Contenedor con el n�mero de topics del repositorio.
	 */
	public VSearchFieldContainer getTopicsNumberField() {
		return topicsNumberField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el tipo de orden a seguir en los resultados.
	 * 
	 * @return Contenedor con el tipo de orden a seguir en los resultados.
	 */
	public VSearchFieldContainer getSortOptionField() {
		return sortOptionField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el tipo de orden ascendente o descendente a seguir
	 * en los resultados.
	 * 
	 * @return Contenedor con el tipo de orden ascendente o descendente a seguir en
	 *         los resultados.
	 */
	public VSearchFieldContainer getOrderOptionField() {
		return orderOptionField;
	}

	/**
	 * 
	 * Devuelve el contenedor con el n�mero m�ximo de repositorios a devolver.
	 * 
	 * @return Contenedor con el n�mero m�ximo de repositorios a devolver.
	 */
	public VSearchFieldContainer getRepositoriesMaxNumberField() {
		return repositoriesMaxNumberField;
	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Resetea todos los campos.
	 * 
	 */
	public void resetFields() {

		ownerField.getParamTextField().setText("");
		inRepositoryNameField.getParamTextField().setText("");
		repositoryField.getParamTextField().setText("");
		descriptionField.getParamTextField().setText("");
		inReadmeField.getParamTextField().setText("");
		createdField.getParamTextField().setText("");
		updatedField.getParamTextField().setText("");
		mainLanguageField.getParamTextField().setText("");
		starsNumberField.getParamTextField().setText("");
		forksNumberField.getParamTextField().setText("");
		followersNumberField.getParamTextField().setText("");
		sizeField.getParamTextField().setText("");
		licenseField.getParamTextField().setText("");
		topicsField.getParamTextField().setText("");
		topicsNumberField.getParamTextField().setText("");
		sortOptionField.getParamTextField().setText("");
		orderOptionField.getParamTextField().setText("");
		repositoriesMaxNumberField.getParamTextField().setText("");
		
		// Reseteamos el scroll
		scrollContainer.getViewport().setViewPosition(new Point(0, 0));

	}

}
