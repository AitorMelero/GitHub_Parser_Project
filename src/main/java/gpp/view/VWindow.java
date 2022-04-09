package gpp.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gpp.constant.GPPConstant;
import gpp.view.component.VLeftMenu;
import gpp.view.window.login.VLogin;

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
		cards = new JPanel(new CardLayout());
		cards.add(loginView, "VLogin");

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

}
