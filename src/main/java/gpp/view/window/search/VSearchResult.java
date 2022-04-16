package gpp.view.window.search;

import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import gpp.model.Repository;
import gpp.model.search.Search;
import gpp.view.component.VColor;
import gpp.view.component.VRepositoryContainer;

/**
 * 
 * Clase que implementa el diseño de la pantalla de resultados de la búsqueda.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearchResult extends JPanel {

	private JLabel title; // título
	private JPanel navigationPageContainer; // contenedor de navegación de páginas
	private JButton previousPageButton; // botón para navegar a la página anterior
	private JButton nextPageButton; // botón para navegar a la página siguiente
	private JLabel numberPageLabel; // etiqueta que indica el número de página actual
	private JScrollPane resultContainerScroll; // contenedor para la lista de resultados con scroll
	private JPanel resultContainer; // contenedor con la lista de resultados
	private ActionListener resultContainerRepositoryListener; // listener para los contenedores de los repositorios

	public VSearchResult() {

		this.setBackground(VColor.getWHITE_MAIN());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		resultContainerScroll = new JScrollPane();
		resultContainer = new JPanel();
		resultContainerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		resultContainer.setLayout(new BoxLayout(resultContainer, BoxLayout.Y_AXIS));
		navigationPageContainer = new JPanel();
		previousPageButton = new JButton("<");
		previousPageButton.setActionCommand("previous page");
		nextPageButton = new JButton(">");
		nextPageButton.setActionCommand("next page");

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el listener de los contenedores de los repositorios.
	 * 
	 * @return Listener de los contenedores de los repositorios.
	 */
	public ActionListener getResultContainerRepositoryListener() {
		return resultContainerRepositoryListener;
	}

	/**
	 * 
	 * Modifica el listener de los contenedores de los repositorios.
	 * 
	 * @param resultContainerRepositoryListener. Listener de los contenedores de los
	 *                                           repositorios.
	 */
	public void setResultContainerRepositoryListener(ActionListener resultContainerRepositoryListener) {
		this.resultContainerRepositoryListener = resultContainerRepositoryListener;
	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Muestra la lista de contenedores del repositorio para un número de página
	 * determinado.
	 * 
	 * @param currentSearch. Búsqueda actual.
	 * @param page.          Número de página a mostrar.
	 */
	public void setSearchResultCurrent(Search currentSearch, int page) {

		// Borramos el contenido de la búsqueda anterior
		navigationPageContainer.removeAll();
		resultContainer.removeAll();
		resultContainerScroll.setViewportView(null);
		resultContainerScroll.revalidate();
		resultContainerScroll.repaint();
		this.removeAll();
		this.revalidate();
		this.repaint();

		title = new JLabel("Resultados de \"" + currentSearch.getName() + "\"");
		numberPageLabel = new JLabel(Integer.toString(page));

		// Añadimos componentes
		this.add(title);
		if (page == 1) {

			navigationPageContainer.add(numberPageLabel);

			if (page != currentSearch.getResult().size()) {

				navigationPageContainer.add(nextPageButton);

			}

		} else if (page == currentSearch.getResult().size()) {

			navigationPageContainer.add(previousPageButton);
			navigationPageContainer.add(numberPageLabel);

		} else {

			navigationPageContainer.add(previousPageButton);
			navigationPageContainer.add(numberPageLabel);
			navigationPageContainer.add(nextPageButton);

		}

		this.add(navigationPageContainer);

		// Añadimos los contenedores de todos los repositorios devueltos en la búsqueda
		Repository r;
		VRepositoryContainer repositoryContainer;
		int numPages = currentSearch.getResult().size(); // número de páginas
		int numRepo = currentSearch.getListRepoResult().size(); // número de repositorios
		int numRepoInPages = 100;

		if (page == numPages) {

			numRepoInPages = numRepo % 100;

			if (numRepoInPages == 0) {

				numRepoInPages = 100;

			}

		}

		for (int i = 0; i < numRepoInPages; i++) {

			r = currentSearch.getListRepoResult().get(100 * (page - 1) + i);

			repositoryContainer = new VRepositoryContainer(r);
			
			// Añadimos el listener al contenedor del repositorio
			repositoryContainer.setControllers(resultContainerRepositoryListener);

			resultContainer.add(repositoryContainer);

		}

		resultContainerScroll.setViewportView(resultContainer);
		resultContainerScroll.getViewport().setViewPosition(new Point(0, 0));
		this.add(resultContainerScroll);

	}

	/**
	 * 
	 * Agrega los listeners a todos los componentes de la pantalla que lo necesitan.
	 * 
	 * @param action. Listener.
	 */
	public void setControllers(ActionListener action) {

		previousPageButton.addActionListener(action);
		nextPageButton.addActionListener(action);

	}

}
