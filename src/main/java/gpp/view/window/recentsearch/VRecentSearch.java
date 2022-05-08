package gpp.view.window.recentsearch;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gpp.model.Repository;
import gpp.model.search.Search;
import gpp.view.component.VColor;
import gpp.view.component.VRepositoryContainer;
import gpp.view.component.VSearchContainer;
import gpp.view.component.VWindowSearchButton;

/**
 * 
 * Clase que implementa el diseño de búsquedas recientes.
 * 
 * @author mele9
 *
 */
public class VRecentSearch extends JPanel {

	private JLabel title; // título
	private JPanel navigationPageContainer; // contenedor de navegación de páginas
	private VWindowSearchButton previousPageButton; // botón para navegar a la página anterior
	private VWindowSearchButton nextPageButton; // botón para navegar a la página siguiente
	private JLabel searchNumberLabel; // etiqueta para número de repositorios encontrados
	private JLabel numberPageLabel; // etiqueta que indica el número de página actual
	private JScrollPane resultContainerScroll; // contenedor para la lista de resultados con scroll
	private JPanel resultContainer; // contenedor con la lista de resultados
	private ActionListener resultContainerSearchListener; // listener para los contenedores de los repositorios

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * Constructor
	 */
	public VRecentSearch() {

		// Estilo general
		this.setBackground(VColor.getWHITE_MAIN());
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setLayout(null);

		// Componentes
		// Título
		title = new JLabel("Búsquedas guardadas");
		title.setBounds(20, 11, 500, 42);
		title.setOpaque(true);
		title.setBackground(VColor.getWHITE_MAIN());
		title.setFont(new Font("Dialog", Font.ITALIC, 32));

		// Resultados
		resultContainerScroll = new JScrollPane();
		resultContainer = new JPanel();
		resultContainerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		resultContainerScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		resultContainerScroll.setBounds(20, 144, 807, 465);
		resultContainer.setLayout(new BoxLayout(resultContainer, BoxLayout.Y_AXIS));

		// Búsquedas guardadas
		searchNumberLabel = new JLabel("0 búsquedas guardadas");
		searchNumberLabel.setBackground(VColor.getWHITE_MAIN());
		searchNumberLabel.setBounds(20, 75, 200, 40);

		// Páginas de búsquedas
		navigationPageContainer = new JPanel();
		navigationPageContainer.setBounds(300, 75, 200, 40);
		navigationPageContainer.setBackground(VColor.getWHITE_MAIN());
		numberPageLabel = new JLabel("Página 0 de 0");
		previousPageButton = new VWindowSearchButton("<");
		previousPageButton.setEnabled(false);
		previousPageButton.setActionCommand("previous page");
		nextPageButton = new VWindowSearchButton(">");
		nextPageButton.setEnabled(false);
		nextPageButton.setActionCommand("next page");
		navigationPageContainer.add(previousPageButton);
		navigationPageContainer.add(numberPageLabel);
		navigationPageContainer.add(nextPageButton);

		this.add(title);
		this.add(searchNumberLabel);
		this.add(navigationPageContainer);
		this.add(resultContainerScroll);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el listener del contenedor.
	 * 
	 * @return Listener del contenedor.
	 */
	public ActionListener getResultContainerSearchListener() {
		return resultContainerSearchListener;
	}

	/**
	 * 
	 * Modifica el listener del contenedor.
	 * 
	 * @param resultContainerSearchListener. Listener del contenedor.
	 */
	public void setResultContainerSearchListener(ActionListener resultContainerSearchListener) {
		this.resultContainerSearchListener = resultContainerSearchListener;
	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Muestra la lista de contenedores de búsquedas para un número de página
	 * determinado.
	 * 
	 * @param currentSearch. Búsqueda actual.
	 * @param page.          Número de página a mostrar.
	 */
	public void setSearchResultCurrent(ArrayList<Search> searches, int page) {

		// Borramos el contenido de la búsqueda anterior
		resultContainer.removeAll();
		resultContainerScroll.setViewportView(null);
		resultContainerScroll.revalidate();
		resultContainerScroll.repaint();
		this.removeAll();
		this.revalidate();
		this.repaint();

		title.setText("Búsquedas guardadas");
		searchNumberLabel.setText(searches.size() + " búsquedas guardadas");
		int numPages = 0;
		if (searches.size() != 0) {

			if (searches.size() % 10 != 0) {

				numPages = searches.size() / 10;

			} else {

				numPages = (searches.size() / 10) + 1;

			}

			VSearchContainer searchContainer;
			resultContainer.setLayout(new BoxLayout(resultContainer, BoxLayout.Y_AXIS));

			for (Search s : searches) {

				searchContainer = new VSearchContainer(s);

				// Añadimos el listener
				searchContainer.setControllers(resultContainerSearchListener);

				resultContainer.add(searchContainer);

			}

		} else {

			resultContainer.setLayout(new GridBagLayout());
			resultContainer.add(new JLabel("No hay búsquedas guardadas"));

		}

		numberPageLabel.setText("Página " + page + " de " + numPages);

		// Añadimos componentes
		this.add(title);
		this.add(searchNumberLabel);
		this.add(navigationPageContainer);
		resultContainerScroll.setViewportView(resultContainer);
		this.add(resultContainerScroll);

	}

	/**
	 * 
	 * Agrega los listeners a todos los componentes de la pantalla que lo necesitan.
	 * 
	 * @param action. Listener.
	 */
	public void setControllers(ActionListener action) {

		// previousPageButton.addActionListener(action);

	}

}
