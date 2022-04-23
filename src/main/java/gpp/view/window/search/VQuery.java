package gpp.view.window.search;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gpp.view.component.VColor;
import gpp.view.component.VSearchFieldContainer;
import gpp.view.component.VSearchParamLabel;
import gpp.view.component.VSearchTextField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

/**
 * 
 * Clase que implementa el diseño de los parámetros de una búsqueda de
 * repositorios.
 * 
 * @author Aitor Melero
 *
 */
public class VQuery extends JPanel {

	JScrollPane scrollContainer;  // contenedor con scroll general
	JPanel container;  // contenedor dentro del scroll
	JPanel ownerContainer; // contenedor para autores
	VSearchParamLabel ownerLabel; // etiqueta para autores
	VSearchTextField owner; // campo de texto para autores
	JPanel inRepositoryNameContainer; // contenedor para cadenas en el nombre del repositorio
	VSearchParamLabel inRepositoryNameLabel; // etiqueta para cadenas en el nombre del repositorio
	VSearchTextField inRepositoryName; // campo de texto para cadenas en el nombre del repositorio
	private JTextField textField_1;
	private JTextField textField_2;
	
	private VSearchFieldContainer ownerField;
	private VSearchFieldContainer inRepositoryNameField;

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	
	/*public VQuery() {
		
		// Estilos generales
		this.setBackground(VColor.getWHITE_MAIN());
		//setLayout(null);
		scrollContainer = new JScrollPane();
		scrollContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollContainer.setBorder(BorderFactory.createEmptyBorder());
		scrollContainer.setBounds(0, 5, 802, 200);
		container = new JPanel();
		container.setLayout(new GridLayout(10, 1));
		
		// Construimos los campos de los parámetros
		int yPosition = 0;
		createContainerField(yPosition, ownerContainer, ownerLabel, "Propietarios del repositorio: ", owner);
		yPosition += 60;
		createContainerField(yPosition, inRepositoryNameContainer, inRepositoryNameLabel, "Palabras del nombre del repositorio: ", inRepositoryName);
		yPosition += 60;
		createContainerField(yPosition, ownerContainer, ownerLabel, "Propietarios del repositorio: ", owner);
		yPosition += 60;
		createContainerField(yPosition, inRepositoryNameContainer, inRepositoryNameLabel, "Palabras del nombre del repositorio: ", inRepositoryName);
		yPosition += 60;
		createContainerField(yPosition, ownerContainer, ownerLabel, "Propietarios del repositorio: ", owner);
		yPosition += 60;
		createContainerField(yPosition, inRepositoryNameContainer, inRepositoryNameLabel, "Palabras del nombre del repositorio: ", inRepositoryName);
		yPosition += 60;
		createContainerField(yPosition, ownerContainer, ownerLabel, "Propietarios del repositorio: ", owner);
		yPosition += 60;
		createContainerField(yPosition, inRepositoryNameContainer, inRepositoryNameLabel, "Palabras del nombre del repositorio: ", inRepositoryName);
		yPosition += 60;
		createContainerField(yPosition, ownerContainer, ownerLabel, "Propietarios del repositorio: ", owner);
		yPosition += 60;
		createContainerField(yPosition, inRepositoryNameContainer, inRepositoryNameLabel, "Palabras del nombre del repositorio: ", inRepositoryName);
		setLayout(null);
		
		scrollContainer.setViewportView(container);
		this.add(scrollContainer);

	}*/
	
	/*public VQuery() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(804, 440));
		//panel_1.setBounds(0, 0, 804, 440);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Autores del repositorio");
		lblNewLabel.setBounds(30, 22, 356, 16);
		panel_1.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(332, 20, 430, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		//panel_2.setBounds(0, 440, 804, 440);
		panel_2.setPreferredSize(new Dimension(804, 440));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel2 = new JLabel("Cadenas del nombre del repositorio");
		lblNewLabel2.setBounds(30, 22, 356, 16);
		panel_2.add(lblNewLabel2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(332, 20, 430, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		
		
	}*/
	
	public VQuery() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		ownerField = new VSearchFieldContainer("Autores del repositorio", "");
		panel.add(ownerField);
		
		inRepositoryNameField = new VSearchFieldContainer("En el repositorio", "");
		panel.add(inRepositoryNameField);
		
	}
	
	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el campo de texto de los propietarios del repositorio.
	 * 
	 * @return Campo de texto de propietarios del repositorio.
	 */
	public VSearchTextField getOwner() {
		return owner;
	}

	/**
	 * 
	 * Modifica el campo de texto de los propietarios del repositorio.
	 * 
	 * @param owner. Nuevo campo de texto de los propietarios del repositorio.
	 */
	public void setOwner(VSearchTextField owner) {
		this.owner = owner;
	}

	/**
	 * 
	 * Devuelve el campo de texto de las cadenas que aparecen en el nombre del
	 * repositorio.
	 * 
	 * @return Campo de texto de las cadenas que aparecen en el nombre del
	 *         repositorio.
	 */
	public VSearchTextField getInRepositoryName() {
		return inRepositoryName;
	}

	/**
	 * 
	 * Modifica el campo de texto de las cadenas que aparecen en el nombre del
	 * repositorio.
	 * 
	 * @param inRepositoryName. Nuevo campo de texto de las cadenas que aparecen en
	 *                          el nombre del repositorio.
	 */
	public void setInRepositoryName(VSearchTextField inRepositoryName) {
		this.inRepositoryName = inRepositoryName;
	}
	
	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */
	
	private void createContainerField(int yPosition, JPanel container, VSearchParamLabel labelContainer, String labelString, VSearchTextField textField) {
		
		container = new JPanel();
		container.setSize(693, 61);
		container.setLayout(null);
		//container.setLayout(null);
		
		labelContainer = new VSearchParamLabel(labelString);
		labelContainer.setBounds(0, 0, 382, 20);
		//labelContainer.setBounds(10, 22, 304, 14);
		container.add(labelContainer);
		
		textField = new VSearchTextField();
		textField.setBounds(444, 0, 358, 20);
		//textField.setBounds(350, 19, 326, 20);
		container.add(textField);
		
		this.container.add(container);
		
	}
}
