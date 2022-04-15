package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private JScrollPane resultContainerScroll;  // contenedor para la lista de resultados con scroll
	private JPanel resultContainer;  // contenedor con la lista de resultados

	public VSearchResult() {

		this.setBackground(VColor.getWHITE_MAIN());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		resultContainerScroll = new JScrollPane();
		resultContainer = new JPanel();
		resultContainerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		resultContainer.setLayout(new BoxLayout(resultContainer, BoxLayout.Y_AXIS));

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
		resultContainer.removeAll();
		resultContainerScroll.setViewportView(null);
		this.removeAll();

		title = new JLabel("Resultados de \"" + currentSearch.getName() + "\"");

		this.add(title);

		// Añadimos los contenedores de todos los repositorios devueltos en la búsqueda
		Repository r;
		VRepositoryContainer repositoryContainer;
		int numPages = currentSearch.getResult().size();  // número de páginas
		int numRepo = currentSearch.getListRepoResult().size();  // número de repositorios
		int numRepoInPages = 100;
		
		if (page == numPages) {
			
			numRepoInPages = numRepo % 101;
			
		}
		
		for (int i = 0; i < numRepoInPages; i++) {
			
			r = currentSearch.getListRepoResult().get(100*(page-1)+i);
			
			repositoryContainer = new VRepositoryContainer(r);
			
			resultContainer.add(repositoryContainer);
			
		}
		
		resultContainerScroll.setViewportView(resultContainer);
		this.add(resultContainerScroll);

	}

}
