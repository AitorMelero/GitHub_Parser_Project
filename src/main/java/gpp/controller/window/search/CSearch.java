package gpp.controller.window.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JOptionPane;

import gpp.GPPSystem;
import gpp.model.Repository;
import gpp.model.search.Filter;
import gpp.model.search.Query;
import gpp.model.search.Search;
import gpp.view.VWindow;
import gpp.view.component.VColor;
import gpp.view.component.VSearchProgressBar;
import gpp.view.window.search.VFilterLanguage;

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
	 * M?TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * M?todo que controla los eventos.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("buscar")) {

			// Pedimos al usuario que introduzca el nombre de la consulta
			String searchName = JOptionPane.showInputDialog(windows, "Debes introducir un nombre para la consulta",
					"Nombre de la consulta", JOptionPane.QUESTION_MESSAGE);

			if (searchName != null && !searchName.replace(" ", "").equals("")) {

				// Sacamos los valores de los campos de b?squeda
				String owner = windows.getSearchView().getQueryWindow().getOwnerField().getParamTextField().getText();
				String inRepositoryName = windows.getSearchView().getQueryWindow().getInRepositoryNameField()
						.getParamTextField().getText();
				String repository = windows.getSearchView().getQueryWindow().getRepositoryField().getParamTextField()
						.getText();
				String description = windows.getSearchView().getQueryWindow().getDescriptionField().getParamTextField()
						.getText();
				String inReadme = windows.getSearchView().getQueryWindow().getInReadmeField().getParamTextField()
						.getText();
				String created = windows.getSearchView().getQueryWindow().getCreatedField().getParamTextField()
						.getText();
				String updated = windows.getSearchView().getQueryWindow().getUpdatedField().getParamTextField()
						.getText();
				String mainLanguage = windows.getSearchView().getQueryWindow().getMainLanguageField()
						.getParamTextField().getText();
				String starsNumber = windows.getSearchView().getQueryWindow().getStarsNumberField().getParamTextField()
						.getText();
				String forksNumber = windows.getSearchView().getQueryWindow().getForksNumberField().getParamTextField()
						.getText();
				String followersNumber = windows.getSearchView().getQueryWindow().getFollowersNumberField()
						.getParamTextField().getText();
				String size = windows.getSearchView().getQueryWindow().getSizeField().getParamTextField().getText();
				String license = windows.getSearchView().getQueryWindow().getLicenseField().getParamTextField()
						.getText();
				String topics = windows.getSearchView().getQueryWindow().getTopicsField().getParamTextField().getText();
				String topicsNumber = windows.getSearchView().getQueryWindow().getTopicsNumberField()
						.getParamTextField().getText();
				String sortOption = windows.getSearchView().getQueryWindow().getSortOptionField().getParamTextField()
						.getText();
				String orderOption = windows.getSearchView().getQueryWindow().getOrderOptionField().getParamTextField()
						.getText();
				String repositoriesMaxNumber = windows.getSearchView().getQueryWindow().getRepositoriesMaxNumberField()
						.getParamTextField().getText();

				// Sacamos los valores de los filtros generales
				String ownerFilter = windows.getSearchView().getFilterWindow().getOwnerField().getParamTextField()
						.getText();
				String inRepositoryNameFilter = windows.getSearchView().getFilterWindow().getInRepositoryNameField()
						.getParamTextField().getText();
				String descriptionFilter = windows.getSearchView().getFilterWindow().getDescriptionField()
						.getParamTextField().getText();
				String createdDateFilter = windows.getSearchView().getFilterWindow().getCreatedDateField()
						.getParamTextField().getText();
				String updatedDateFilter = windows.getSearchView().getFilterWindow().getUpdatedDateField()
						.getParamTextField().getText();
				String mainLanguageFilter = windows.getSearchView().getFilterWindow().getMainLanguageField()
						.getParamTextField().getText();
				String starsNumberFilter = windows.getSearchView().getFilterWindow().getStarsNumberField()
						.getParamTextField().getText();
				String forksNumberFilter = windows.getSearchView().getFilterWindow().getForksNumberField()
						.getParamTextField().getText();
				String sizeFilter = windows.getSearchView().getFilterWindow().getSizeField().getParamTextField()
						.getText();
				String licenseFilter = windows.getSearchView().getFilterWindow().getLicenseField().getParamTextField()
						.getText();
				String topicsFilter = windows.getSearchView().getFilterWindow().getTopicsField().getParamTextField()
						.getText();
				String topicsNumberFilter = windows.getSearchView().getFilterWindow().getTopicsNumberField()
						.getParamTextField().getText();
				String filesNumberFilter = windows.getSearchView().getFilterWindow().getFilesNumberField()
						.getParamTextField().getText();
				String avgSizeFilter = windows.getSearchView().getFilterWindow().getAvgSizeField().getParamTextField()
						.getText();
				String extensionsFilter = windows.getSearchView().getFilterWindow().getExtensionsField()
						.getParamTextField().getText();

				// Creamos la b?squeda
				Search s = new Search(searchName, GPPSystem.getUser());
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
				q.setFollowersNumber(followersNumber);
				q.setSize(size);
				q.setLicense(license);
				q.setTopics(topics);
				q.setTopicsNumber(topicsNumber);
				q.setSortOption(sortOption);
				q.setOrderOption(orderOption);
				q.setRepositoriesMaxNumber(repositoriesMaxNumber);
				q.generateQueryPath();

				// Creamos el filtro
				Filter f = s.getFilter();
				f.setOwner(ownerFilter);
				f.setInRepositoryName(inRepositoryNameFilter);
				f.setDescription(descriptionFilter);
				f.setCreatedDate(createdDateFilter);
				f.setUpdatedDate(updatedDateFilter);
				f.setMainLanguage(mainLanguageFilter);
				f.setStarsNumber(starsNumberFilter);
				f.setForksNumber(forksNumberFilter);
				f.setSize(sizeFilter);
				f.setLicense(licenseFilter);
				f.setTopics(topicsFilter);
				f.setTopicsNumber(topicsNumberFilter);
				f.setFilesNumber(filesNumberFilter);
				f.setAvgSize(avgSizeFilter);
				f.setExtensions(extensionsFilter);

				// Realizamos la b?squeda
				s.search();

				if (s.getListRepoResult().size() != 0) {
					
					// Panel con barra de progreso
					VSearchProgressBar searchProgressBar = new VSearchProgressBar(windows, s.getListRepoResult().size(), 0);

					// Tarea ejecutada en paralelo para el an?lisis de resultados
					ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
					Future<Search> submit = newCachedThreadPool.submit(new Callable<Search>() {
					    @Override
					    public Search call() {
					    	
					    	if (GPPSystem.isGlobalSemaphoreTasks()) {
					    		
					    		s.filter(searchProgressBar);

								if (s.getListRepoResult().size() != 0) {

									// Filtramos la b?squeda por lenguaje
									VFilterLanguage filterLanguage = windows.getSearchView().getFilterLanguageWindow();
									ArrayList<Repository> repositoryFilterLanguage = new ArrayList<Repository>();
									for (Repository repo : s.getListRepoResult()) {
										
										// Se cancela la tarea
										if (!GPPSystem.isGlobalSemaphoreTasks()) {
											
											return null;
											
										}

										if (filterLanguage.filterLanguage(repo)) {

											repositoryFilterLanguage.add(repo);

										}

									}
									
									// Se cancela la tarea
									if (!GPPSystem.isGlobalSemaphoreTasks()) {
										
										return null;
										
									}
									
									s.setListRepoResult(repositoryFilterLanguage);

								}
								
								// Se cancela la tarea
								if (!GPPSystem.isGlobalSemaphoreTasks()) {
									
									return null;
									
								}
								
								searchProgressBar.getDialog().dispose();
								
								GPPSystem.setGlobalSemaphoreTasks(false);
								
								// Si no hay resultados mostramos la info al usuario
								if (s.getListRepoResult().size() == 0) {

									JOptionPane.showMessageDialog(windows, "No coincide ning?n repositorio con la consulta",
											"No hay resultados", JOptionPane.INFORMATION_MESSAGE);

								} else {

									// Cambiamos a la pantalla de resultados
									gppSystem.setCurrentSearch(s);
									windows.getSearchResultView().setSearchResultCurrent(s, 1);
									windows.setCard("VSearchResult");

								}
					    		
					    	}
					    	
							return s;
					    }
					});
					
					GPPSystem.setGlobalSemaphoreTasks(true);
					
					searchProgressBar.showDialog(true);
					
					// Si se llega aqu? es que el usuario ha cancelado el an?lisis
					GPPSystem.setGlobalSemaphoreTasks(false);

				} else {
					
					JOptionPane.showMessageDialog(windows, "No coincide ning?n repositorio con la consulta",
							"No hay resultados", JOptionPane.INFORMATION_MESSAGE);
					
				}

			}

		} else if (e.getActionCommand().equals("Buscar general")) {

			GPPSystem.setSearchButtonSelected(GPPSystem.BUSCAR_REPO);
			windows.getSearchView().getFilterWindowButton().setBackground(VColor.getGRAY_MENU());
			windows.getSearchView().getFilterLanguageWindowButton().setBackground(VColor.getGRAY_MENU());
			windows.getSearchView().setCard("VQuery");

		} else if (e.getActionCommand().equals("Filtros generales")) {

			GPPSystem.setSearchButtonSelected(GPPSystem.FILTRAR_REPO);
			windows.getSearchView().getQueryWindowButton().setBackground(VColor.getGRAY_MENU());
			windows.getSearchView().getFilterLanguageWindowButton().setBackground(VColor.getGRAY_MENU());
			windows.getSearchView().setCard("VFilter");

		} else if (e.getActionCommand().equals("Filtros por lenguaje")) {

			GPPSystem.setSearchButtonSelected(GPPSystem.FILTRAR_LENGUAJE_REPO);
			windows.getSearchView().getQueryWindowButton().setBackground(VColor.getGRAY_MENU());
			windows.getSearchView().getFilterWindowButton().setBackground(VColor.getGRAY_MENU());
			windows.getSearchView().setCard("VFilterLanguage");

		}

	}

}
