package gpp.controller.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gpp.GPPSystem;
import gpp.model.Repository;
import gpp.model.search.Search;
import gpp.view.VWindow;

/**
 * 
 * Clase que implementa el controlador para los contenedores de repositorios.
 * 
 * @author Aitor Melero.
 *
 */
public class CRepositoryContainer implements ActionListener {

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
	public CRepositoryContainer(GPPSystem gppSystem, VWindow windows) {

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
		
		Search currentSearch = gppSystem.getCurrentSearch();
		Repository repo = null;
		String repoName;
		
		// Sacamos el repositorio correspondiente
		for (Repository r: currentSearch.getListRepoResult()) {
			
			repoName = r.getOwnerName() + "/" + r.getName();
			
			if (e.getActionCommand().equals(repoName)) {
				
				repo = r;
				
			}
			
		}
		
		if (repo != null) {
			
			System.out.println("REPO PULSADO: " + repo.getOwnerName() + ", " + repo.getName());
			
		}

		/*if (e.getActionCommand().equals("buscar")) {

			windows.setCard("VSearch");

		}*/

	}

}
