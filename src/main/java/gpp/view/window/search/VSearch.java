package gpp.view.window.search;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gpp.GPPSystem;
import gpp.view.component.VColor;
import gpp.view.component.VSearchButton;
import gpp.view.component.VWindowSearchButton;

import java.awt.CardLayout;
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
	private JPanel cards; // panel sobre el que situar las pantallas
	private VQuery queryWindow; // ventana para los par�metros de la b�squeda
	private VFilter filterWindow; // ventana para los par�metros de los filtros generales
	private VFilterLanguage filterLanguageWindow; // ventana para los par�metros de los filtros por lenguaje

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
		filterWindow = new VFilter();
		filterLanguageWindow = new VFilterLanguage();

		// A�adimos todas las pantallas
		cards = new JPanel(new CardLayout());
		cards.add(queryWindow, "VQuery");
		cards.add(filterWindow, "VFilter");
		cards.add(filterLanguageWindow, "VFilterLanguage");

		// Mostramos ventana
		CardLayout c1 = (CardLayout) (cards.getLayout());
		c1.show(cards, "VQuery");

		// Dise�o general
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setBackground(VColor.getWHITE_MAIN());
		setLayout(null);

		// T�tulo
		searchTitle.setOpaque(true);
		searchTitle.setBackground(VColor.getWHITE_MAIN());
		searchTitle.setFont(new Font("Dialog", Font.ITALIC, 32));
		// searchTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(searchTitle);

		// Bot�n de buscar
		searchButton = new VSearchButton("Buscar");
		searchButton.setBounds(752, 57, 75, 26);
		searchButton.setActionCommand("buscar");
		this.add(searchButton);

		// Botones de par�metros
		windowButtonContainer = new JPanel();
		windowButtonContainer.setLocation(20, 96);
		queryWindowButton = new VWindowSearchButton("�Qu� buscas?");
		queryWindowButton.setActionCommand("Buscar general");
		queryWindowButton.setButtonCode(GPPSystem.BUSCAR_REPO);
		filterWindowButton = new VWindowSearchButton("Filtros generales");
		filterWindowButton.setActionCommand("Filtros generales");
		filterWindowButton.setButtonCode(GPPSystem.FILTRAR_REPO);
		filterLanguageWindowButton = new VWindowSearchButton("Filtros por lenguaje");
		filterLanguageWindowButton.setActionCommand("Filtros por lenguaje");
		filterLanguageWindowButton.setButtonCode(GPPSystem.FILTRAR_LENGUAJE_REPO);
		windowButtonContainer.add(queryWindowButton);
		windowButtonContainer.add(filterWindowButton);
		windowButtonContainer.add(filterLanguageWindowButton);
		windowButtonContainer.setSize(new Dimension(407, 36));
		windowButtonContainer.setBackground(VColor.getWHITE_MAIN());
		this.add(windowButtonContainer);

		// Contenedor con par�metros
		cards.setBounds(20, 144, 807, 465);
		// this.add(queryWindow);
		this.add(cards);

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

	/**
	 * 
	 * Devuelve la ventana de los filtros generales.
	 * 
	 * @return Ventana con los filtros generales.
	 */
	public VFilter getFilterWindow() {
		return filterWindow;
	}

	/**
	 * 
	 * Modifica la ventana con los filtros generales.
	 * 
	 * @param filterWindow. Nueva ventana con los filtros generales.
	 */
	public void setFilterWindow(VFilter filterWindow) {
		this.filterWindow = filterWindow;
	}

	/**
	 * 
	 * Devuelve la ventana de los fitros por lenguaje.
	 * 
	 * @return Ventana con los filtros por lenguaje.
	 */
	public VFilterLanguage getFilterLanguageWindow() {
		return filterLanguageWindow;
	}

	/**
	 * 
	 * Modifica la ventana de los filtros por lenguaje.
	 * 
	 * @param filterLanguageWindow. Ventana de los filtros por lenguaje.
	 */
	public void setFilterLanguageWindow(VFilterLanguage filterLanguageWindow) {
		this.filterLanguageWindow = filterLanguageWindow;
	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * 
	 * 
	 * @return the queryWindowButton
	 */
	public VWindowSearchButton getQueryWindowButton() {
		return queryWindowButton;
	}

	/**
	 * @param queryWindowButton the queryWindowButton to set
	 */
	public void setQueryWindowButton(VWindowSearchButton queryWindowButton) {
		this.queryWindowButton = queryWindowButton;
	}

	/**
	 * @return the filterWindowButton
	 */
	public VWindowSearchButton getFilterWindowButton() {
		return filterWindowButton;
	}

	/**
	 * @param filterWindowButton the filterWindowButton to set
	 */
	public void setFilterWindowButton(VWindowSearchButton filterWindowButton) {
		this.filterWindowButton = filterWindowButton;
	}

	/**
	 * @return the filterLanguageWindowButton
	 */
	public VWindowSearchButton getFilterLanguageWindowButton() {
		return filterLanguageWindowButton;
	}

	/**
	 * @param filterLanguageWindowButton the filterLanguageWindowButton to set
	 */
	public void setFilterLanguageWindowButton(VWindowSearchButton filterLanguageWindowButton) {
		this.filterLanguageWindowButton = filterLanguageWindowButton;
	}

	/**
	 * 
	 * Agrega los listeners a todos los componentes de la pantalla que lo necesitan.
	 * 
	 * @param action. Listener.
	 */
	public void setControllers(ActionListener action) {

		searchButton.addActionListener(action);
		queryWindowButton.addActionListener(action);
		filterWindowButton.addActionListener(action);
		filterLanguageWindowButton.addActionListener(action);

	}

	/**
	 * 
	 * Cambia de pantalla.
	 * 
	 * @param nameCard. Nombre de la nueva pantalla a mostrar.
	 */
	public void setCard(String nameCard) {

		CardLayout c = (CardLayout) (cards.getLayout());
		c.show(cards, nameCard);

	}

}
