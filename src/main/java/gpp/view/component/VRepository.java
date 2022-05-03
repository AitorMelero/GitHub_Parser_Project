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
	private VSearchButton goBackButton; // botón para ir atrás

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
		goBackButton.setBounds(636, 57, 191, 26);

		infoContainerScroll.add(infoContainer);
		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(title);
		this.add(goBackButton);
		this.add(infoContainerScroll);

	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Modifica la pantalla para otro repositorio.
	 * 
	 * @param repo. Repositorio del que mostrar información.
	 */
	public void setRepository(Repository repo) {

		infoContainer.removeAll();
		infoContainerScroll.setViewportView(null);
		infoContainerScroll.revalidate();
		infoContainerScroll.repaint();

		// Añadimos la información al contenedor
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
		for (String k: repo.getLanguageProperties().getPropertiesVisualMap().keySet()) {
			
			infoContainer.add(addInfoField(k, repo.getLanguageProperties().getPropertiesVisualMap().get(k) + ""));
			
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
