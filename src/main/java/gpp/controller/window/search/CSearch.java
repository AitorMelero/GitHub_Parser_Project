package gpp.controller.window.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gpp.GPPSystem;
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
			String owner = windows.getSearchView().getQueryWindow().getOwnerField().getParamTextField().getText();
			String inRepositoryName = windows.getSearchView().getQueryWindow().getInRepositoryNameField()
					.getParamTextField().getText();
			String repository = windows.getSearchView().getQueryWindow().getRepositoryField().getParamTextField()
					.getText();
			String description = windows.getSearchView().getQueryWindow().getDescriptionField().getParamTextField()
					.getText();
			String inReadme = windows.getSearchView().getQueryWindow().getInReadmeField().getParamTextField().getText();
			String created = windows.getSearchView().getQueryWindow().getCreatedField().getParamTextField().getText();
			String updated = windows.getSearchView().getQueryWindow().getUpdatedField().getParamTextField().getText();
			String mainLanguage = windows.getSearchView().getQueryWindow().getMainLanguageField().getParamTextField()
					.getText();
			String starsNumber = windows.getSearchView().getQueryWindow().getStarsNumberField().getParamTextField()
					.getText();
			String forksNumber = windows.getSearchView().getQueryWindow().getForksNumberField().getParamTextField()
					.getText();

			// Creamos la búsqueda
			Search s = new Search("Búsquedas prueba", GPPSystem.getUser());
			Query q = s.getQuery();
			q.setOwner(owner);
			q.setInRepositoryName(inRepositoryName);
			q.setRepository(repository);
			q.setDescription(description);
			q.setInReadme(inReadme);
			q.setCreatedDate(created);
			q.setUpdatedDate(updated);
			q.setMainLanguage(mainLanguage);
			q.setStarsNumber(starsNumber);
			q.setForksNumber(forksNumber);
			q.generateQueryPath();

			System.out.println("CONSULTA: " + q.getPath());

			// Realizamos la búsqueda
			s.search();

			// Filtramos la búsqueda
			s.filter();

			// Cambiamos a la pantalla de resultados
			gppSystem.setCurrentSearch(s);
			windows.getSearchResultView().setSearchResultCurrent(s, 1);
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
