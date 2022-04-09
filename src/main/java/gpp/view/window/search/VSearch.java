package gpp.view.window.search;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.view.component.VColor;

/**
 * 
 * Clase que implementa el diseño de la página de búsquedas de la app.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearch extends JPanel {
	
	private JLabel searchTitle;  // etiqueta del título de búsquedas
	
	public VSearch() {
		
		// Inicializamos componentes
		searchTitle = new JLabel("Buscar");
		
		// Título
		this.add(searchTitle);
		
		// Diseño general
		this.setBackground(VColor.getWHITE_MAIN());
		
	}

}
