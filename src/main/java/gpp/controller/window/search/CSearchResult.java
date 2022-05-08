package gpp.controller.window.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
			
			boolean searchFind = false;
			for (int i = 0; i < gppSystem.getSearchesSavedList().size() && !searchFind; i++) {
				
				if (s.getId() == gppSystem.getSearchesSavedList().get(i).getId()) {
					
					searchFind = true;
					
				}
				
			}
			
			if (!searchFind) {
				
				gppSystem.getSearchesSavedList().add(s);
				
			} 
			
			JOptionPane.showMessageDialog(windows, "Ya tienes guardados los resultados", "Guardado", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		windows.getSearchResultView().setSearchResultCurrent(s, s.getCurrentPageNumber());
		
	}

}
