package gpp.view.window.search;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.view.component.VColor;

/**
 * 
 * Clase que implementa el dise�o de la p�gina de b�squedas de la app.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearch extends JPanel {
	
	private JLabel searchTitle;  // etiqueta del t�tulo de b�squedas
	
	public VSearch() {
		
		// Inicializamos componentes
		searchTitle = new JLabel("Buscar");
		
		// T�tulo
		this.add(searchTitle);
		
		// Dise�o general
		this.setBackground(VColor.getWHITE_MAIN());
		
	}

}
