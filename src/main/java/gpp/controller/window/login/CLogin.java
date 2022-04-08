package gpp.controller.window.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gpp.GPPSystem;
import gpp.view.VWindow;

/**
 * 
 * Clase que implementa el controlador de la pantalla del login.
 * 
 * @author Aitor Melero.
 *
 */
public class CLogin implements ActionListener {
	
	GPPSystem gppSystem;  // sistema
	VWindow windows;  // ventana principal
	
	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	
	/**
	 * 
	 * Constructor.
	 * 
	 * @param gppSystem. Sistema.
	 * @param windows. Ventana principal.
	 */
	public CLogin(GPPSystem gppSystem, VWindow windows) {
		
		this.gppSystem = gppSystem;
		this.windows = windows;
		
	}

	/**
	 * Método que controla los eventos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String token = new String(windows.getLoginView().getTokenField().getPassword());
		
		if (e.getActionCommand().equals("login")) {
			
			gppSystem.login(token);
			
		}
		
	}

}
