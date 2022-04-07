package gpp.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gpp.view.window.login.VLogin;

/**
 * 
 * Clase que implementa el dise�o de la ventana principal de la app.
 * 
 * @author Aitor Melero
 *
 */
public class VWindow extends JFrame {
	
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	private JPanel cards;  // Panel sobre el que situar las pantallas
	private VLogin loginView;  // pantalla login

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	public VWindow() {
		
		// Cabecera
		this.setTitle("GitHub Parser Project");
		
		// Dise�o
		this.setSize(WIDTH, HEIGHT);
		
		// Pantallas
		loginView = new VLogin();
		cards = new JPanel(new CardLayout());
		cards.add(loginView, "VLogin");
		
		// Mostramos ventana
		CardLayout c1 = (CardLayout)(cards.getLayout());
		c1.show(cards, "VLogin");
		
		// A�adimos componentes
		this.add(cards);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
