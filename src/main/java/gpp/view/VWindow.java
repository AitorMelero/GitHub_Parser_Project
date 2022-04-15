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
 * Clase que implementa el dise�o de la ventana principal de la app.
 * 
 * @author Aitor Melero
 *
 */
public class VWindow extends JFrame {

	private VLeftMenu menu; // men� lateral de la app
	private JPanel cards; // panel sobre el que situar las pantallas
	private VLogin loginView; // pantalla login
	private VSearch searchView; // pantalla de b�squeda

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	public VWindow() {

		// Cabecera
		this.setTitle("GitHub Parser Project");

		// Dise�o
		this.setSize(GPPConstant.WIDTH, GPPConstant.HEIGHT);

		// Pantallas
		menu = new VLeftMenu((int) (GPPConstant.WIDTH * 0.25), GPPConstant.HEIGHT);
		menu.setVisible(false);
		loginView = new VLogin();
		searchView = new VSearch();

		// A�adimos todas las pantallas
		cards = new JPanel(new CardLayout());
		cards.add(loginView, "VLogin");
		cards.add(searchView, "VSearch");

		// Mostramos ventana
		CardLayout c1 = (CardLayout) (cards.getLayout());
		c1.show(cards, "VLogin");

		// A�adimos componentes
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
	 * Devuelve el men� lateral de la app.
	 * 
	 * @return Men� lateral del men�.
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
	 * Devuelve la ventana de las b�squedas.
	 * 
	 * @return Ventana de las b�squedas.
	 */
	public VSearch getSearchView() {
		return searchView;
	}

	/**
	 * 
	 * Modifica la ventana de las b�squedas.
	 * 
	 * @param loginView. Nueva ventana de las b�squedas.
	 */
	public void setSearchView(VSearch searchView) {
		this.searchView = searchView;
	}

	/**************************************************************************
	 * M�TODOS
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

		// Si estamos en el login no mostramos el men� lateral
		if (nameCard.equals("VLogin")) {

			menu.setVisible(false);

		} else {

			menu.setVisible(true);

		}

	}

}
