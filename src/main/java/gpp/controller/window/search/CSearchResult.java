package gpp.controller.window.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gpp.GPPSystem;
import gpp.model.search.Search;
import gpp.view.VWindow;

/**
 * 
 * Clase que implementa el controlador de la pantalla del login.
 * 
 * @author Aitor Melero
 *
 */
public class CSearchResult implements ActionListener {
	
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
	public CSearchResult(GPPSystem gppSystem, VWindow windows) {

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
		
		Search s = gppSystem.getCurrentSearch();
		int pageNumber = s.getCurrentPageNumber();
		
		if (e.getActionCommand().equals("previous page")) {
			
			s.setCurrentPageNumber(pageNumber-1);
			
		} else if (e.getActionCommand().equals("next page")) {
			
			s.setCurrentPageNumber(pageNumber+1);
			
		} else if (e.getActionCommand().equals("guardar")) {
			
			gppSystem.getSearchesSavedList().add(s);
			
		}
		
		windows.getSearchResultView().setSearchResultCurrent(s, s.getCurrentPageNumber());
		
	}

}
