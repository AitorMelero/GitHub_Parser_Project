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
 * Clase que implementa el dise�o de la pantalla de informaci�n de un
 * repositorio.
 * 
 * @author Aitor Melero
 *
 */
public class VRepository extends JPanel {

	private Repository repository; // repositorio
	private JLabel title; // t�tulo
	private JScrollPane infoContainerScroll; // contenedor con scroll
	private JPanel infoContainer; // contenedor con la informaci�n del repositorio
	private VSearchButton webButton; // bot�n para ver el repositorio en el navegador
	private VSearchButton cloneButton; // bot�n para clonar el repositorio
	private VSearchButton goBackButton; // bot�n para ir atr�s
	private JLabel infoGeneralTitle; // t�tulo de informaci�n general
	private JLabel infoLanguageTitle; // t�tulo de informaci�n del lenguaje

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

		// Dise�o general
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setBackground(VColor.getWHITE_MAIN());
		setLayout(null);

		// T�tulo
		title = new JLabel("Informaci�n del repositorio");
		title.setBounds(20, 11, 418, 42);
		title.setOpaque(true);
		title.setBackground(VColor.getWHITE_MAIN());
		title.setFont(new Font("Dialog", Font.ITALIC, 32));

		// T�tulo de informaci�n general
		infoGeneralTitle = new JLabel("Informaci�n general");
		infoGeneralTitle.setBackground(VColor.getGRAY_MENU());
		infoGeneralTitle.setFont(new Font("Dialog", Font.ITALIC, 28));
		infoGeneralTitle.setForeground(VColor.getBLUE_REPOSITORY_TITLE());
		infoGeneralTitle.setBorder(new EmptyBorder(10, 30, 0, 0));

		// T�tulo de informaci�n por lenguaje
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

		// Bot�n de buscar
		goBackButton = new VSearchButton("Volver a resultados");
		goBackButton.setActionCommand("go back");
		goBackButton.setBounds(636, 70, 191, 26);

		// Bot�n de buscar
		cloneButton = new VSearchButton("Clonar");
		cloneButton.setActionCommand("clone");
		cloneButton.setBounds(370, 70, 100, 26);

		// Bot�n de navegar a la web
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
	 * M�TODOS
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
	 * @param repo. Repositorio del que mostrar informaci�n.
	 */
	public void setRepository(Repository repo) {

		// A�adimos el repositorio
		repository = repo;

		// Reseteamos el dise�o
		infoContainer.removeAll();
		infoContainerScroll.setViewportView(null);
		infoContainerScroll.revalidate();
		infoContainerScroll.repaint();

		// A�adimos la informaci�n al contenedor
		infoContainer.add(infoGeneralTitle);
		infoContainer.add(addInfoField("Autor: ", repo.getOwnerName()));
		infoContainer.add(addInfoField("Nombre: ", repo.getName()));
		infoContainer.add(addInfoField("Descripci�n: ", repo.getDescription()));
		infoContainer.add(addInfoField("N� de ficheros: ", repo.getFilesNumber() + ""));
		infoContainer.add(addInfoField("N�mero de estrellas: ", repo.getStarsNumber() + ""));
		infoContainer.add(addInfoField("N�mero de forks: ", repo.getForksNumber() + ""));
		// infoContainer.add(addInfoField("N�mero de visitas: ",
		// repo.getWatchersNumber() + ""));
		infoContainer.add(addInfoField("Licencia: ", repo.getLicense()));
		infoContainer.add(addInfoField("Fecha de creaci�n: ", repo.getDateCreated()));
		infoContainer.add(addInfoField("Fecha de actualizaci�n: ", repo.getDateUpdated()));
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
		infoContainer.add(addInfoField("Tama�o total: ", repo.getTotalSize() + " KB"));
		infoContainer.add(addInfoField("Tama�o medio de ficheros: ", repo.getAvgSize() + " KB"));
		infoContainer.add(addInfoField("Lenguaje principal: ", repo.getMainLanguage()));

		// A�adimos informaci�n por lenguaje
		if (repo.getLanguageProperties() != null) {

			infoLanguageTitle.setText("Informaci�n sobre " + repo.getMainLanguage());
			infoContainer.add(infoLanguageTitle);

			infoContainer.add(
					addInfoField("N� de ficheros del lenguaje principal: ", repo.getMainLanguagesFilesNumber() + ""));

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
	 * A�ade campos de informaci�n.
	 * 
	 * @param field. Nombre del campo.
	 * @param value. Valor del campo.
	 * @return Campo con la informaci�n.
	 */
	private VSearchFieldContainer addInfoField(String field, String value) {

		VSearchFieldContainer fieldContainer = new VSearchFieldContainer(field, value);
		fieldContainer.getParamTextField().setEnabled(false);
		fieldContainer.getParamTextField().setDisabledTextColor(VColor.getBLACK_MAIN());

		return fieldContainer;

	}

}
