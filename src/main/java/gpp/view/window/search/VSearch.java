package gpp.view.window.search;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gpp.view.component.VColor;
import gpp.view.component.VSearchButton;
import gpp.view.component.VWindowSearchButton;
import java.awt.Dimension;

/**
 * 
 * Clase que implementa el dise�o de la p�gina de b�squedas de la app.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearch extends JPanel {

	private JPanel searchContainer; // posicion del contenedor principal de buscar
	private JLabel searchTitle; // etiqueta del t�tulo de b�squedas
	private VSearchButton searchButton; // bot�n de buscar
	private JPanel windowButtonContainer; // contenedor para los botones de las subventanas
	private VWindowSearchButton queryWindowButton; // bot�n para la pantalla de la consulta
	private VWindowSearchButton filterWindowButton; // bot�n para la pantalla de filtros generales
	private VWindowSearchButton filterLanguageWindowButton; // bot�n para la pantalla de filtros por lenguaje
	private VQuery queryWindow; // ventana para los par�metros de la b�squeda

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * Constructor
	 */
	public VSearch() {

		// Inicializamos componentes
		searchContainer = new JPanel();
		searchTitle = new JLabel("Buscar");
		searchTitle.setBounds(20, 11, 100, 42);
		queryWindow = new VQuery();

		// Dise�o general
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setBackground(VColor.getWHITE_MAIN());
		setLayout(null);
		// this.setAlignmentX(Component.LEFT_ALIGNMENT);

		// T�tulo
		searchTitle.setOpaque(true);
		searchTitle.setBackground(VColor.getWHITE_MAIN());
		searchTitle.setFont(new Font("Dialog", Font.ITALIC, 32));
		// searchTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(searchTitle);

		// BOCETO para probar b�squedas
		searchButton = new VSearchButton("Buscar");
		searchButton.setBounds(752, 57, 75, 26);
		searchButton.setActionCommand("buscar");
		this.add(searchButton);
		windowButtonContainer = new JPanel();
		windowButtonContainer.setLocation(20, 96);
		queryWindowButton = new VWindowSearchButton("�Qu� buscas?");
		filterWindowButton = new VWindowSearchButton("Filtros generales");
		filterLanguageWindowButton = new VWindowSearchButton("Filtros por lenguaje");
		windowButtonContainer.add(queryWindowButton);
		windowButtonContainer.add(filterWindowButton);
		windowButtonContainer.add(filterLanguageWindowButton);
		windowButtonContainer.setSize(new Dimension(407, 36));
		windowButtonContainer.setBackground(VColor.getWHITE_MAIN());
		this.add(windowButtonContainer);
		queryWindow.setBounds(20, 144, 807, 319);
		this.add(queryWindow);

		// searchContainer.setAlignmentY(Component.LEFT_ALIGNMENT);
		// this.add(searchContainer, BorderLayout.WEST);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve la pantalla de par�metros de la consulta.
	 * 
	 * @return Ventana de par�metros de la b�squeda.
	 */
	public VQuery getQueryWindow() {
		return queryWindow;
	}

	/**
	 * 
	 * Modifica la pantalla de par�metros de la b�squeda.
	 * 
	 * @param queryWindow. Nueva pantalla de par�metros de b�squeda.
	 */
	public void setQueryWindow(VQuery queryWindow) {
		this.queryWindow = queryWindow;
	}

	/**************************************************************************
	 * M�TODOS
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
