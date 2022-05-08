package gpp.controller.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gpp.GPPSystem;
import gpp.model.Repository;
import gpp.model.search.Search;
import gpp.view.VWindow;

/**
 * 
 * Clase que implementa el controlador para los contenedores de búsquedas guardadas.
 * 
 * @author Aitor Melero.
 *
 */
public class CSearchContainer implements ActionListener {

	GPPSystem gppSystem; // sistema
	VWindow windows; // ventana principal

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 * @param gppSystem. Sistema.
	 * @param windows.   Ventana principal.
	 */
	public CSearchContainer(GPPSystem gppSystem, VWindow windows) {

		this.gppSystem = gppSystem;
		this.windows = windows;

	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Método que controla los eventos.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean searchFind = false;
		Search currentSearch = null;
		for (int i = 0; i < gppSystem.getSearchesSavedList().size() && !searchFind; i++) {
			
			if (gppSystem.getSearchesSavedList().get(i).getId() == Long.parseLong(e.getActionCommand())) {
				
				currentSearch = gppSystem.getSearchesSavedList().get(i);
				gppSystem.setCurrentSearch(currentSearch);
				searchFind = true;
				
			}
			
		}
		
		// Cambiamos a la pantalla de resultados
		windows.getSearchResultView().setSearchResultCurrent(currentSearch, 1);
		GPPSystem.setMenuButtonSelected(GPPSystem.BUSQUEDAS_GUARDADAS);
		windows.setCard("VSearchResult");

	}


}
