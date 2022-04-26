package gpp.controller.window.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * M�todo que controla los eventos.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("buscar")) {

			// Sacamos los valores de los campos de b�squeda
			String owner = windows.getSearchView().getQueryWindow().getOwnerField().getParamTextField().getText();
			String inRepositoryName = windows.getSearchView().getQueryWindow().getInRepositoryNameField().getParamTextField().getText();
			String repository = windows.getSearchView().getQueryWindow().getRepositoryField().getParamTextField().getText();
			String description = windows.getSearchView().getQueryWindow().getDescriptionField().getParamTextField().getText();
			String inReadme = windows.getSearchView().getQueryWindow().getInReadmeField().getParamTextField().getText();

			// Creamos la b�squeda
			Search s = new Search("B�squedas prueba", gppSystem.getUser());
			Query q = s.getQuery();
			q.setOwner(owner);
			q.setInRepositoryName(inRepositoryName);
			q.setRepository(repository);
			q.setDescription(description);
			q.setInReadme(inReadme);
			q.generateQueryPath();
			
			System.out.println("CONSULTA: " + q.getPath());
			
			// Realizamos la b�squeda
			s.search();
			
			// Filtramos la b�squeda
			s.filter();
			
			// Cambiamos a la pantalla de resultados
			gppSystem.setCurrentSearch(s);
			windows.getSearchResultView().setSearchResultCurrent(s,1);
			windows.setCard("VSearchResult");

		} else if (e.getActionCommand().equals("Buscar general")) {
			
			windows.getSearchView().setCard("VQuery");
			
		} else if (e.getActionCommand().equals("Filtros generales")) {
			
			windows.getSearchView().setCard("VFilter");
			
		} else if (e.getActionCommand().equals("Filtros por lenguaje")) {
			
			windows.getSearchView().setCard("VFilterLanguage");
			
		}

	}

}
