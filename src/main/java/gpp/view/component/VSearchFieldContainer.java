package gpp.view.component;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * 
 * Clase que implementa el diseño del contenedor con los campos de búsqueda.
 * 
 * @author Aitor Melero
 *
 */
public class VSearchFieldContainer extends JPanel {

	VSearchParamLabel paramLabel;  // etiqueta
	VSearchTextField paramTextField;  // campo de texto
	
	
	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	
	public VSearchFieldContainer(String labelValue, String textFieldValue) {
		
		// Diseño general
		this.setPreferredSize(new Dimension(804, 62));
		this.setLayout(null);
		
		// Etiqueta
		paramLabel = new VSearchParamLabel(labelValue);
		paramLabel.setBounds(30, 22, 356, 16);
		this.add(paramLabel);
		
		// Campo de texto
		paramTextField = new VSearchTextField();
		paramTextField.setBounds(332, 20, 430, 20);
		paramTextField.setColumns(10);
		this.add(paramTextField);
		
	}
	
}
