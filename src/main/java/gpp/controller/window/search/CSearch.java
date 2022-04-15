package gpp.controller.window.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gpp.GPPSystem;
import gpp.model.github.api.caller.GitHubAPICaller;
import gpp.model.search.Query;
import gpp.model.search.Search;
import gpp.view.VWindow;

/**
 * 
 * Clase que implementa el controlador de la pantalla del login.
 * 
 * @author Aitor Melero
 *
 */
public class CSearch implements ActionListener {

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
	public CSearch(GPPSystem gppSystem, VWindow windows) {

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

			// Sacamos los valores de los campos de búsqueda
			String owner = windows.getSearchView().getQueryWindow().getOwner().getText();
			String inRepositoryName = windows.getSearchView().getQueryWindow().getInRepositoryName().getText();

			// Creamos la búsqueda
			Search s = new Search("Búsquedas prueba");
			Query q = s.getQuery();
			q.setOwner(owner);
			q.setInRepositoryName(inRepositoryName);
			q.generateQueryPath();

			System.out.println("RESULTADO: " + GitHubAPICaller.searchRepositories(gppSystem.getUser().getToken(),
					q.getPath(), "best-match", "desc", 1, 1));

		}

	}

}
