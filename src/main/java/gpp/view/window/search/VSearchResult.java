package gpp.view.window.search;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.model.search.Search;
import gpp.view.component.VColor;

/**
 * 
 * Clase que implementa el diseño de la pantalla de resultados de la búsqueda.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearchResult extends JPanel {
	
	private JLabel title;  // título
	
	public VSearchResult() {
		
		this.setBackground(VColor.getWHITE_MAIN());
		
	}
	
	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */
	
	/**
	 * 
	 * Cambia el diseño de la pantalla en función del resultado de la búsqueda actual.
	 * 
	 * @param currentSearch. Búsqueda actual.
	 */
	public void setSearchResultCurrent(Search currentSearch) {
		
		title = new JLabel("Resultados de \"" + currentSearch.getName() + "\"");
		
		this.add(title);
		
	}

}
