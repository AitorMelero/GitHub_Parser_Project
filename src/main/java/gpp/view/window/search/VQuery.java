package gpp.view.window.search;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gpp.view.component.VColor;
import gpp.view.component.VSearchParamLabel;
import gpp.view.component.VSearchTextField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;

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
	JPanel ownerContainer; // contenedor para autores
	VSearchParamLabel ownerLabel; // etiqueta para autores
	VSearchTextField owner; // campo de texto para autores
	JPanel inRepositoryNameContainer; // contenedor para cadenas en el nombre del repositorio
	VSearchParamLabel inRepositoryNameLabel; // etiqueta para cadenas en el nombre del repositorio
	VSearchTextField inRepositoryName; // campo de texto para cadenas en el nombre del repositorio

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	
	public VQuery() {
		
		// Estilos generales
		this.setBackground(VColor.getWHITE_MAIN());
		setLayout(null);
		scrollContainer = new JScrollPane();
		scrollContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollContainer.setBorder(BorderFactory.createEmptyBorder());
		scrollContainer.setBounds(0, 11, 824, 465);
		scrollContainer.setLayout(null);
		
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
		
		this.add(scrollContainer);

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
		container.setBounds(0, yPosition, 693, 61);
		container.setLayout(null);
		
		labelContainer = new VSearchParamLabel(labelString);
		labelContainer.setBounds(10, 22, 304, 14);
		container.add(labelContainer);
		
		textField = new VSearchTextField();
		textField.setBounds(350, 19, 326, 20);
		container.add(textField);
		
		scrollContainer.add(container);
		
	}
}
