package gpp.view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import gpp.GPPSystem;
import gpp.constant.GPPConstant;

/**
 * 
 * Clase que implementa el men� de la izquierda.
 * 
 * @author Aitor Melero
 *
 */
public class VLeftMenu extends JPanel {

	private VButton searchButton;
	private VButton recentSearchesButton;
	private VButton userRepositoriesButton;
	private VButton userButton;
	private VButton settingsButton;

	public VLeftMenu(int width, int height) {

		this.setBackground(VColor.getGRAY_MENU());
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(new BorderLayout());

		// Creamos un contenedor para meter los botones principales del men�
		JPanel mainButtonsContainer = new JPanel();
		mainButtonsContainer.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
		mainButtonsContainer.setLayout(new GridLayout(4, 1));
		mainButtonsContainer.setBackground(VColor.getGRAY_MENU());

		// A�adimos los botones principales
		Icon searchIcon = new ImageIcon(GPPConstant.GPP_ICONS + "search.png");
		searchButton = new VButton("Buscar", searchIcon);
		searchButton.setActionCommand("buscar");
		searchButton.setButtonCode(GPPSystem.BUSCAR);
		mainButtonsContainer.add(searchButton);

		Icon recentSearchesIcon = new ImageIcon(GPPConstant.GPP_ICONS + "clock.png");
		recentSearchesButton = new VButton("B�squedas guardadas", recentSearchesIcon);
		recentSearchesButton.setActionCommand("busquedas guardadas");
		mainButtonsContainer.add(recentSearchesButton);

		Icon userRepositoriesIcon = new ImageIcon(GPPConstant.GPP_ICONS + "my_repositories.png");
		userRepositoriesButton = new VButton("Mis repositorios", userRepositoriesIcon);
		//mainButtonsContainer.add(userRepositoriesButton);

		Icon userIcon = new ImageIcon(GPPConstant.GPP_ICONS + "profile.png");
		userButton = new VButton("Mi perfil", userIcon);
		//mainButtonsContainer.add(userButton);

		// A�adimos el contenedor de los botones principales
		this.add(mainButtonsContainer, BorderLayout.NORTH);

		// Creamos un contenedor para meter el bot�n de ajustes
		JPanel settingsContainer = new JPanel();
		settingsContainer.setPreferredSize(new Dimension(width, (int) (height * 0.3 / 4)));
		settingsContainer.setLayout(new GridLayout(1, 1));

		// A�adimos el bot�n de logout
		Icon settingsIcon = new ImageIcon(GPPConstant.GPP_ICONS + "logout.png");
		settingsButton = new VButton("Cerrar sesi�n", settingsIcon);
		settingsButton.setActionCommand("logout");
		settingsContainer.add(settingsButton);

		this.add(settingsContainer, BorderLayout.SOUTH);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el bot�n de buscar del men�.
	 * 
	 * @return Bot�n de buscar del men�.
	 */
	public VButton getSearchButton() {
		return searchButton;
	}

	/**
	 * 
	 * Devuelve el bot�n de b�squedas recientes del men�.
	 * 
	 * @return Bot�n de b�squedas recientes del bot�n.
	 */
	public VButton getRecentSearchesButton() {
		return recentSearchesButton;
	}

	/**
	 * 
	 * Devuelve el bot�n de repositorios del usuario del men�.
	 * 
	 * @return Bot�n de repositorios del usuario del men�.
	 */
	public VButton getUserRepositoriesButton() {
		return userRepositoriesButton;
	}

	/**
	 * 
	 * Devuelve el bot�n del perfil del men�.
	 * 
	 * @return Devuelve el bot�n de perfil del men�.
	 */
	public VButton getUserButton() {
		return userButton;
	}

	/**
	 * 
	 * Devuelve el bot�n de ajustes de la app del men�.
	 * 
	 * @return Bot�n de ajustes de la app del men�.
	 */
	public VButton getSettingsButton() {
		return settingsButton;
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
		recentSearchesButton.addActionListener(action);
		settingsButton.addActionListener(action);

	}

}
