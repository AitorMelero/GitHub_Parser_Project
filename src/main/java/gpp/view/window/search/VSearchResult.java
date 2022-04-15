package gpp.view.window.search;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.model.search.Search;
import gpp.view.component.VColor;

/**
 * 
 * Clase que implementa el dise�o de la pantalla de resultados de la b�squeda.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearchResult extends JPanel {
	
	private JLabel title;  // t�tulo
	
	public VSearchResult() {
		
		this.setBackground(VColor.getWHITE_MAIN());
		
	}
	
	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */
	
	/**
	 * 
	 * Cambia el dise�o de la pantalla en funci�n del resultado de la b�squeda actual.
	 * 
	 * @param currentSearch. B�squeda actual.
	 */
	public void setSearchResultCurrent(Search currentSearch) {
		
		title = new JLabel("Resultados de \"" + currentSearch.getName() + "\"");
		
		this.add(title);
		
	}

}
