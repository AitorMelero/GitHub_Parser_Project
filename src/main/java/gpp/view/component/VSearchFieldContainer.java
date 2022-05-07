package gpp.view.component;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * 
 * Clase que implementa el diseño del contenedor con los campos de búsqueda.
 * 
 * @author Aitor Melero
 *
 */
public class VSearchFieldContainer extends JPanel {

	private VSearchParamLabel paramLabel; // etiqueta
	private VSearchTextField paramTextField; // campo de texto

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
		paramLabel.setBounds(30, 32, 356, 16);
		this.add(paramLabel);

		// Campo de texto
		paramTextField = new VSearchTextField();
		paramTextField.setText(textFieldValue);
		paramTextField.setBounds(332, 20, 430, 40);
		paramTextField.setColumns(10);
		this.add(paramTextField);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el campo de texto.
	 * 
	 * @return Campo de texto.
	 */
	public VSearchTextField getParamTextField() {
		return paramTextField;
	}
	
	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */
	
	public void changeTextFieldToTextArea() {
		
		if (paramTextField != null) {
			
			this.remove(paramTextField);
			
			// Añadimos el area de texto
			VSearchTextArea ta = new VSearchTextArea(paramTextField.getText());
			ta.setBounds(332, 20, 430, 40);
			ta.getTextArea().setColumns(10);
			ta.getTextArea().setEnabled(false);
			ta.getTextArea().setDisabledTextColor(VColor.getBLACK_MAIN());
			ta.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(VColor.getBLACK_MAIN(), 1)));
			this.add(ta);
			
			paramTextField = null;
			
		}
		
		
	}

}
