package gpp.view.component;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Clase que implementa el diseño del botón del contenedor de un repositorio.
 * 
 * @author Aitor Melero.
 *
 */
public class VRepositoryButton extends JButton {
	
	JPanel container;  // contenedor general
	JLabel repositoryTitle;  // título del repositorio
	JLabel description;  // descripción del repositorio
	JPanel extraInfo;  // contenedor de información extra
	JLabel stars;  // estrellas del repositorio
	JLabel language;  // lenguaje principal del repositorio
	JLabel license;  // licencia del repositorio
	JLabel date;  // fecha de actualización del repositorio
	
	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	
	public VRepositoryButton() {
		
		container = new JPanel();
		extraInfo = new JPanel();
		extraInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		extraInfo.setBounds(12, 87, 713, 16);
		
		repositoryTitle = new JLabel("AitorMelero/GitHub_Parser_Project");
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
		
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setBackground(VColor.getGRAY_MENU());
		this.setOpaque(true);
		
		this.setBounds(20, 144, 800, 125);
		this.add(container);
		
	}

}
