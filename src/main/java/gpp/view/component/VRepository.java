package gpp.view.component;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gpp.model.Repository;

/**
 * 
 * Clase que implementa el diseño de la pantalla de información de un
 * repositorio.
 * 
 * @author Aitor Melero
 *
 */
public class VRepository extends JPanel {

	private Repository repository; // repositorio
	private JLabel title; // título
	private JScrollPane infoContainerScroll; // contenedor con scroll
	private JPanel infoContainer; // contenedor con la información del repositorio
	private VSearchButton webButton; // botón para ver el repositorio en el navegador
	private VSearchButton cloneButton; // botón para clonar el repositorio
	private VSearchButton goBackButton; // botón para ir atrás
	private JLabel infoGeneralTitle; // título de información general
	private JLabel infoLanguageTitle; // título de información del lenguaje

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public VRepository() {

		// Diseño general
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setBackground(VColor.getWHITE_MAIN());
		setLayout(null);

		// Título
		title = new JLabel("Información del repositorio");
		title.setBounds(20, 11, 418, 42);
		title.setOpaque(true);
		title.setBackground(VColor.getWHITE_MAIN());
		title.setFont(new Font("Dialog", Font.ITALIC, 32));

		// Título de información general
		infoGeneralTitle = new JLabel("Información general");
		infoGeneralTitle.setBackground(VColor.getGRAY_MENU());
		infoGeneralTitle.setFont(new Font("Dialog", Font.ITALIC, 28));
		infoGeneralTitle.setForeground(VColor.getBLUE_REPOSITORY_TITLE());
		infoGeneralTitle.setBorder(new EmptyBorder(10, 30, 0, 0));

		// Título de información por lenguaje
		infoLanguageTitle = new JLabel("");
		infoLanguageTitle.setBackground(VColor.getGRAY_MENU());
		infoLanguageTitle.setFont(new Font("Dialog", Font.ITALIC, 28));
		infoLanguageTitle.setForeground(VColor.getBLUE_REPOSITORY_TITLE());
		infoLanguageTitle.setBorder(new EmptyBorder(10, 30, 0, 0));

		// Contenedor
		infoContainerScroll = new JScrollPane();
		infoContainer = new JPanel();
		infoContainerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		infoContainerScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		infoContainerScroll.setBounds(20, 144, 807, 465);
		infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));

		// Botón de buscar
		goBackButton = new VSearchButton("Volver a resultados");
		goBackButton.setActionCommand("go back");
		goBackButton.setBounds(636, 70, 191, 26);

		// Botón de buscar
		cloneButton = new VSearchButton("Clonar");
		cloneButton.setActionCommand("clone");
		cloneButton.setBounds(370, 70, 100, 26);

		// Botón de navegar a la web
		webButton = new VSearchButton("Ver en el navegador");
		webButton.setActionCommand("go web");
		webButton.setBounds(20, 70, 200, 26);

		infoContainerScroll.add(infoContainer);
		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(title);
		this.add(goBackButton);
		this.add(webButton);
		this.add(cloneButton);
		this.add(infoContainerScroll);

	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el repositorio de la pantalla.
	 * 
	 * @return Repositorio de la pantalla.
	 */
	public Repository getRepository() {
		return repository;
	}

	/**
	 * 
	 * Modifica la pantalla para otro repositorio.
	 * 
	 * @param repo. Repositorio del que mostrar información.
	 */
	public void setRepository(Repository repo) {

		// Añadimos el repositorio
		repository = repo;

		// Reseteamos el diseño
		infoContainer.removeAll();
		infoContainerScroll.setViewportView(null);
		infoContainerScroll.revalidate();
		infoContainerScroll.repaint();

		// Añadimos la información al contenedor
		infoContainer.add(infoGeneralTitle);
		infoContainer.add(addInfoField("Autor: ", repo.getOwnerName()));
		infoContainer.add(addInfoField("Nombre: ", repo.getName()));
		infoContainer.add(addInfoField("Descripción: ", repo.getDescription()));
		infoContainer.add(addInfoField("Nº de ficheros: ", repo.getFilesNumber() + ""));
		infoContainer.add(addInfoField("Número de estrellas: ", repo.getStarsNumber() + ""));
		infoContainer.add(addInfoField("Número de forks: ", repo.getForksNumber() + ""));
		// infoContainer.add(addInfoField("Número de visitas: ",
		// repo.getWatchersNumber() + ""));
		infoContainer.add(addInfoField("Licencia: ", repo.getLicense()));
		infoContainer.add(addInfoField("Fecha de creación: ", repo.getDateCreated()));
		infoContainer.add(addInfoField("Fecha de actualización: ", repo.getDateUpdated()));
		String extensionsList = "";
		for (int i = 0; i < repo.getExtensionsList().size(); i++) {

			extensionsList += repo.getExtensionsList().toArray()[i];

			if ((i + 1) != repo.getExtensionsList().size()) {

				extensionsList += ", ";

			}

		}
		VSearchFieldContainer extensionContainer = addInfoField("Extensiones: ", extensionsList);
		infoContainer.add(extensionContainer);
		// extensionContainer.getParamTextField().setMinimumSize(new Dimension(430,
		// 20));
		// extensionContainer.getParamTextField().setMaximumSize(new Dimension(1000,
		// 20));
		// extensionContainer.setPreferredSize(new Dimension(430, 20));
		String topicsList = "";
		for (int i = 0; i < repo.getTopics().size(); i++) {

			topicsList += repo.getTopics().get(i);

			if ((i + 1) != repo.getTopics().size()) {

				topicsList += ", ";

			}

		}
		infoContainer.add(addInfoField("Topics: ", topicsList));
		infoContainer.add(addInfoField("Tamaño total: ", repo.getTotalSize() + " KB"));
		infoContainer.add(addInfoField("Tamaño medio de ficheros: ", repo.getAvgSize() + " KB"));
		infoContainer.add(addInfoField("Lenguaje principal: ", repo.getMainLanguage()));

		// Añadimos información por lenguaje
		if (repo.getLanguageProperties() != null) {

			infoLanguageTitle.setText("Información sobre " + repo.getMainLanguage());
			infoContainer.add(infoLanguageTitle);

			infoContainer.add(
					addInfoField("Nº de ficheros del lenguaje principal: ", repo.getMainLanguagesFilesNumber() + ""));

			for (String k : repo.getLanguageProperties().getPropertiesVisualMap().keySet()) {

				infoContainer.add(addInfoField(k, repo.getLanguageProperties().getPropertiesVisualMap().get(k) + ""));

			}

		}

		infoContainerScroll.setViewportView(infoContainer);
		infoContainerScroll.getViewport().setViewPosition(new Point(0, 0));

	}

	/**
	 * 
	 * Agrega los listeners a todos los componentes de la pantalla que lo necesitan.
	 * 
	 * @param action. Listener.
	 */
	public void setControllers(ActionListener action) {

		goBackButton.addActionListener(action);
		webButton.addActionListener(action);
		cloneButton.addActionListener(action);
		;

	}

	/**
	 * 
	 * Añade campos de información.
	 * 
	 * @param field. Nombre del campo.
	 * @param value. Valor del campo.
	 * @return Campo con la información.
	 */
	private VSearchFieldContainer addInfoField(String field, String value) {

		VSearchFieldContainer fieldContainer = new VSearchFieldContainer(field, value);
		fieldContainer.getParamTextField().setEnabled(false);
		fieldContainer.getParamTextField().setDisabledTextColor(VColor.getBLACK_MAIN());

		return fieldContainer;

	}

}
