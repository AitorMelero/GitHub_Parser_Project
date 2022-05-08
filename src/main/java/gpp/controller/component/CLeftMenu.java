package gpp.controller.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gpp.GPPSystem;
import gpp.view.VWindow;
import gpp.view.component.VColor;
import gpp.view.window.search.VFilterLanguage;
import gpp.view.window.search.VSearch;

/**
 * 
 * Clase que implementa el controlador del menú lateral.
 * 
 * @author Aitor Melero
 *
 */
public class CLeftMenu implements ActionListener {

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
	public CLeftMenu(GPPSystem gppSystem, VWindow windows) {

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
		
		if (e.getActionCommand().equals("buscar")) {
			
			// Reseteamos y cambiamos valores
			windows.getSearchView().getQueryWindow().resetFields();
			windows.getSearchView().getFilterWindow().resetFields();
			windows.getSearchView().getFilterLanguageWindow().resetFields();
			GPPSystem.setMenuButtonSelected(GPPSystem.BUSCAR);
			windows.getMenu().getRecentSearchesButton().setBackground(VColor.getGRAY_MENU());
			GPPSystem.setSearchButtonSelected(GPPSystem.BUSCAR_REPO);
			windows.getSearchView().getQueryWindowButton().setBackground(VColor.getGRAY_FOCUS_MENU());
			windows.getSearchView().getFilterWindowButton().setBackground(VColor.getGRAY_MENU());
			windows.getSearchView().getFilterLanguageWindowButton().setBackground(VColor.getGRAY_MENU());
			windows.getSearchView().setCard("VQuery");
			windows.setCard("VSearch");
			
		} else if (e.getActionCommand().equals("busquedas guardadas")) {
			
			GPPSystem.setMenuButtonSelected(GPPSystem.BUSQUEDAS_GUARDADAS);
			windows.getMenu().getSearchButton().setBackground(VColor.getGRAY_MENU());
			int page = 1;
			if (gppSystem.getSearchesSavedList().size() == 0) {
				
				page = 0;
				
			}
			windows.getRecentSearchView().setSearchResultCurrent(gppSystem.getSearchesSavedList(), page);
			windows.setCard("VRecentSearch");
			
		} else if (e.getActionCommand().equals("logout")) {
			
			gppSystem.logout();
			windows.getLoginView().getTokenField().setText("");
			windows.setCard("VLogin");
			
		}
		
	}

}
