package gpp.controller.window.login;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JOptionPane;

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
	public CLogin(GPPSystem gppSystem, VWindow windows) {

		this.gppSystem = gppSystem;
		this.windows = windows;

	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * Método que controla los eventos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String token = new String(windows.getLoginView().getTokenField().getPassword());

		if (e.getActionCommand().equals("login")) {

			if (gppSystem.login(token)) {

				windows.setCard("VSearch");

			} else {

				JOptionPane.showMessageDialog(windows.getLoginView(), "Token incorrecto. Inténtalo de nuevo.",
						"Error token", JOptionPane.ERROR_MESSAGE);

			}

		} else if (e.getActionCommand().equals("getToken")) {

			try {

				URL urlToken = new URL(
						"https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token");
				GPPSystem.openWebpage(urlToken);

			} catch (MalformedURLException e1) {

				e1.printStackTrace();

			}

		}

	}

}
