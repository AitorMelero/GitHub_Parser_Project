package gpp.view.component;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.model.Repository;

/**
 * 
 * Clase que implementa el diseño del botón del contenedor de un repositorio.
 * 
 * @author Aitor Melero.
 *
 */
public class VRepositoryContainer extends JButton {

	private Repository repository;  // repositorio
	private JPanel container; // contenedor general
	private JLabel repositoryTitle; // título del repositorio
	private JLabel description; // descripción del repositorio
	private JPanel extraInfo; // contenedor de información extra
	private JLabel stars; // estrellas del repositorio
	private JLabel language; // lenguaje principal del repositorio
	private JLabel license; // licencia del repositorio
	private JLabel date; // fecha de actualización del repositorio

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	public VRepositoryContainer(Repository repository) {

		this.setLayout(null);

		container = new JPanel();
		container.setBounds(0, 0, 780, 125);
		extraInfo = new JPanel();
		extraInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		extraInfo.setBounds(12, 87, 713, 16);

		repositoryTitle = new JLabel(repository.getOwnerName() + "/" + repository.getName());
		repositoryTitle.setBounds(32, 12, 693, 16);
		description = new JLabel("Aplicación de parseo de repositorios de GitHub");
		description.setBounds(32, 51, 693, 16);
		stars = new JLabel("25.3k");
		stars.setBounds(12, 67, 31, 16);
		language = new JLabel("Java");
		language.setBounds(99, 67, 27, 16);
		license = new JLabel("MIT license");
		license.setBounds(197, 67, 64, 16);
		date = new JLabel("Actualizado: 24-04-2022");
		date.setBounds(273, 67, 136, 16);
		container.setLayout(null);

		container.add(repositoryTitle);
		container.add(description);
		extraInfo.add(stars);
		extraInfo.add(language);
		extraInfo.add(license);
		extraInfo.add(date);
		container.add(extraInfo);

		// this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setBackground(VColor.getGRAY_MENU());
		this.setOpaque(true);

		// this.setBounds(20, 144, 800, 125);
		this.setMinimumSize(new Dimension(780, 125));
		this.setMaximumSize(new Dimension(780, 125));
		this.setPreferredSize(new Dimension(780, 125));
		this.add(container);
		this.setActionCommand(repository.getOwnerName() + "/" + repository.getName());

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

		this.addActionListener(action);

	}

}
