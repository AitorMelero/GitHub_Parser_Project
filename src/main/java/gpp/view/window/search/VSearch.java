package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.view.component.VColor;
import gpp.view.component.VSearchButton;
import gpp.view.component.VWindowSearchButton;

/**
 * 
 * Clase que implementa el dise�o de la p�gina de b�squedas de la app.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearch extends JPanel {

	private JLabel searchTitle; // etiqueta del t�tulo de b�squedas
	private VSearchButton searchButton; // bot�n de buscar
	private JPanel windowButtonContainer;  // contenedor para los botones de las subventanas
	private VWindowSearchButton queryWindowButton; // bot�n para la pantalla de la consulta
	private VWindowSearchButton filterWindowButton; // bot�n para la pantalla de filtros generales
	private VWindowSearchButton filterLanguageWindowButton; // bot�n para la pantalla de filtros por lenguaje
	private VQuery queryWindow;  // ventana para los par�metros de la b�squeda

	public VSearch() {

		// Inicializamos componentes
		searchTitle = new JLabel("Buscar");

		// T�tulo
		this.add(searchTitle);

		// Dise�o general
		this.setBackground(VColor.getWHITE_MAIN());
		//BOCETO
		this.setLayout(new BoxLayout(this, (BoxLayout.Y_AXIS)));

		// BOCETO para probar b�squedas
		searchButton = new VSearchButton("Buscar");
		this.add(searchButton);
		windowButtonContainer = new JPanel();
		queryWindowButton = new VWindowSearchButton("�Qu� buscas?");
		filterWindowButton = new VWindowSearchButton("Filtros generales");
		filterLanguageWindowButton = new VWindowSearchButton("Filtros por lenguaje");
		windowButtonContainer.add(queryWindowButton);
		windowButtonContainer.add(filterWindowButton);
		windowButtonContainer.add(filterLanguageWindowButton);
		this.add(windowButtonContainer);
		queryWindow = new VQuery();
		this.add(queryWindow);
		
	}

}
