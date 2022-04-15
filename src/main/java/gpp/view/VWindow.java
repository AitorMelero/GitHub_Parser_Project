package gpp.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gpp.constant.GPPConstant;
import gpp.view.component.VLeftMenu;
import gpp.view.window.login.VLogin;
import gpp.view.window.search.VSearch;

/**
 * 
 * Clase que implementa el diseño de la ventana principal de la app.
 * 
 * @author Aitor Melero
 *
 */
public class VWindow extends JFrame {

	private VLeftMenu menu; // menú lateral de la app
	private JPanel cards; // panel sobre el que situar las pantallas
	private VLogin loginView; // pantalla login
	private VSearch searchView; // pantalla de búsqueda

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	public VWindow() {

		// Cabecera
		this.setTitle("GitHub Parser Project");

		// Diseño
		this.setSize(GPPConstant.WIDTH, GPPConstant.HEIGHT);

		// Pantallas
		menu = new VLeftMenu((int) (GPPConstant.WIDTH * 0.25), GPPConstant.HEIGHT);
		menu.setVisible(false);
		loginView = new VLogin();
		searchView = new VSearch();

		// Añadimos todas las pantallas
		cards = new JPanel(new CardLayout());
		cards.add(loginView, "VLogin");
		cards.add(searchView, "VSearch");

		// Mostramos ventana
		CardLayout c1 = (CardLayout) (cards.getLayout());
		c1.show(cards, "VLogin");

		// Añadimos componentes
		this.add(menu, BorderLayout.WEST);
		this.add(cards);

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el menú lateral de la app.
	 * 
	 * @return Menú lateral del menú.
	 */
	public VLeftMenu getMenu() {
		return menu;
	}

	/**
	 * 
	 * Devuelve el contenedor de pantallas.
	 * 
	 * @return Contenedor de pantallas.
	 */
	public JPanel getCards() {
		return cards;
	}

	/**
	 * 
	 * Modifica el contenedor de pantallas.
	 * 
	 * @param cards. Nuevo contenedor de pantallas.
	 */
	public void setCards(JPanel cards) {
		this.cards = cards;
	}

	/**
	 * 
	 * Devuelve la ventana del login.
	 * 
	 * @return Ventana del login.
	 */
	public VLogin getLoginView() {
		return loginView;
	}

	/**
	 * 
	 * Modifica la ventana del login.
	 * 
	 * @param loginView. Nueva ventana del login.
	 */
	public void setLoginView(VLogin loginView) {
		this.loginView = loginView;
	}

	/**
	 * 
	 * Devuelve la ventana de las búsquedas.
	 * 
	 * @return Ventana de las búsquedas.
	 */
	public VSearch getSearchView() {
		return searchView;
	}

	/**
	 * 
	 * Modifica la ventana de las búsquedas.
	 * 
	 * @param loginView. Nueva ventana de las búsquedas.
	 */
	public void setSearchView(VSearch searchView) {
		this.searchView = searchView;
	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Cambia de pantalla.
	 * 
	 * @param nameCard. Nombre de la nueva pantalla a mostrar.
	 */
	public void setCard(String nameCard) {

		CardLayout c = (CardLayout) (cards.getLayout());
		c.show(cards, nameCard);

		// Si estamos en el login no mostramos el menú lateral
		if (nameCard.equals("VLogin")) {

			menu.setVisible(false);

		} else {

			menu.setVisible(true);

		}

	}

}
