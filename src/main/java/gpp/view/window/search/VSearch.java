package gpp.view.window.search;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.view.component.VColor;
import gpp.view.component.VSearchButton;
import gpp.view.component.VWindowSearchButton;

/**
 * 
 * Clase que implementa el diseño de la página de búsquedas de la app.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearch extends JPanel {

	private JLabel searchTitle; // etiqueta del título de búsquedas
	private VSearchButton searchButton; // botón de buscar
	private JPanel windowButtonContainer; // contenedor para los botones de las subventanas
	private VWindowSearchButton queryWindowButton; // botón para la pantalla de la consulta
	private VWindowSearchButton filterWindowButton; // botón para la pantalla de filtros generales
	private VWindowSearchButton filterLanguageWindowButton; // botón para la pantalla de filtros por lenguaje
	private VQuery queryWindow; // ventana para los parámetros de la búsqueda

	public VSearch() {

		// Inicializamos componentes
		searchTitle = new JLabel("Buscar");

		// Título
		this.add(searchTitle);

		// Diseño general
		this.setBackground(VColor.getWHITE_MAIN());
		// BOCETO
		this.setLayout(new BoxLayout(this, (BoxLayout.Y_AXIS)));

		// BOCETO para probar búsquedas
		searchButton = new VSearchButton("Buscar");
		searchButton.setActionCommand("buscar");
		this.add(searchButton);
		windowButtonContainer = new JPanel();
		queryWindowButton = new VWindowSearchButton("¿Qué buscas?");
		filterWindowButton = new VWindowSearchButton("Filtros generales");
		filterLanguageWindowButton = new VWindowSearchButton("Filtros por lenguaje");
		windowButtonContainer.add(queryWindowButton);
		windowButtonContainer.add(filterWindowButton);
		windowButtonContainer.add(filterLanguageWindowButton);
		this.add(windowButtonContainer);
		queryWindow = new VQuery();
		this.add(queryWindow);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve la pantalla de parámetros de la consulta.
	 * 
	 * @return Ventana de parámetros de la búsqueda.
	 */
	public VQuery getQueryWindow() {
		return queryWindow;
	}

	/**
	 * 
	 * Modifica la pantalla de parámetros de la búsqueda.
	 * 
	 * @param queryWindow. Nueva pantalla de parámetros de búsqueda.
	 */
	public void setQueryWindow(VQuery queryWindow) {
		this.queryWindow = queryWindow;
	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Agrega los listeners a todos los componentes de la pantalla que lo necesitan.
	 * 
	 * @param action. Listener.
	 */
	public void setControllers(ActionListener action) {

		searchButton.addActionListener(action);

	}

}
