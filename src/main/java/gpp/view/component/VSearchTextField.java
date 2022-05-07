package gpp.view.component;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * 
 * Clase que implementa el diseño de un campo de texto para los parámetros de la
 * búsqueda.
 * 
 * @author Aitor Melero
 *
 */
public class VSearchTextField extends JTextField {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public VSearchTextField() {

		this.setColumns(40);
		this.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(VColor.getBLACK_MAIN(), 1)));

	}
	
	/**
	 * 
	 * Añade un placeholder al campo de texto.
	 * 
	 * @param placeholder. Placeholder.
	 */
	public void addPlaceholder(String placeholder) {
		
		VTextPrompt ph = new VTextPrompt(placeholder, this);
		ph.changeAlpha(0.75f);
	    ph.changeStyle(Font.ITALIC);
		
	}

}
