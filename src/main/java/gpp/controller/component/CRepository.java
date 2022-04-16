package gpp.controller.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gpp.GPPSystem;
import gpp.model.Repository;
import gpp.model.search.Search;
import gpp.view.VWindow;

/**
 * 
 * Clase que implementa el controlador de la pantalla de información del
 * repositorio.
 * 
 * @author Aitor Melero
 *
 */
public class CRepository implements ActionListener {

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
	public CRepository(GPPSystem gppSystem, VWindow windows) {

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
		
		if (e.getActionCommand().equals("go back")) {
			
			windows.setCard("VSearchResult");
			
		}

	}

}
