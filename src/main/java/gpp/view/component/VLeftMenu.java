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
 * Clase que implementa el menú de la izquierda.
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

		// Creamos un contenedor para meter los botones principales del menú
		JPanel mainButtonsContainer = new JPanel();
		mainButtonsContainer.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
		mainButtonsContainer.setLayout(new GridLayout(4, 1));
		mainButtonsContainer.setBackground(VColor.getGRAY_MENU());

		// Añadimos los botones principales
		Icon searchIcon = new ImageIcon(GPPConstant.GPP_ICONS + "search.png");
		searchButton = new VButton("Buscar", searchIcon);
		searchButton.setActionCommand("buscar");
		searchButton.setButtonCode(GPPSystem.BUSCAR);
		mainButtonsContainer.add(searchButton);

		Icon recentSearchesIcon = new ImageIcon(GPPConstant.GPP_ICONS + "clock.png");
		recentSearchesButton = new VButton("Búsquedas guardadas", recentSearchesIcon);
		recentSearchesButton.setActionCommand("busquedas guardadas");
		mainButtonsContainer.add(recentSearchesButton);

		Icon userRepositoriesIcon = new ImageIcon(GPPConstant.GPP_ICONS + "my_repositories.png");
		userRepositoriesButton = new VButton("Mis repositorios", userRepositoriesIcon);
		//mainButtonsContainer.add(userRepositoriesButton);

		Icon userIcon = new ImageIcon(GPPConstant.GPP_ICONS + "profile.png");
		userButton = new VButton("Mi perfil", userIcon);
		//mainButtonsContainer.add(userButton);

		// Añadimos el contenedor de los botones principales
		this.add(mainButtonsContainer, BorderLayout.NORTH);

		// Creamos un contenedor para meter el botón de ajustes
		JPanel settingsContainer = new JPanel();
		settingsContainer.setPreferredSize(new Dimension(width, (int) (height * 0.3 / 4)));
		settingsContainer.setLayout(new GridLayout(1, 1));

		// Añadimos el botón de logout
		Icon settingsIcon = new ImageIcon(GPPConstant.GPP_ICONS + "logout.png");
		settingsButton = new VButton("Cerrar sesión", settingsIcon);
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
	 * Devuelve el botón de buscar del menú.
	 * 
	 * @return Botón de buscar del menú.
	 */
	public VButton getSearchButton() {
		return searchButton;
	}

	/**
	 * 
	 * Devuelve el botón de búsquedas recientes del menú.
	 * 
	 * @return Botón de búsquedas recientes del botón.
	 */
	public VButton getRecentSearchesButton() {
		return recentSearchesButton;
	}

	/**
	 * 
	 * Devuelve el botón de repositorios del usuario del menú.
	 * 
	 * @return Botón de repositorios del usuario del menú.
	 */
	public VButton getUserRepositoriesButton() {
		return userRepositoriesButton;
	}

	/**
	 * 
	 * Devuelve el botón del perfil del menú.
	 * 
	 * @return Devuelve el botón de perfil del menú.
	 */
	public VButton getUserButton() {
		return userButton;
	}

	/**
	 * 
	 * Devuelve el botón de ajustes de la app del menú.
	 * 
	 * @return Botón de ajustes de la app del menú.
	 */
	public VButton getSettingsButton() {
		return settingsButton;
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
		recentSearchesButton.addActionListener(action);
		settingsButton.addActionListener(action);

	}

}
