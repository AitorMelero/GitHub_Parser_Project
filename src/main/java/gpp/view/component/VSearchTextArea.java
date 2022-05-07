package gpp.view.component;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * Clase que implementa el dise�o de un text area.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearchTextArea extends JScrollPane {
	
	private JTextArea textArea;
	
	/**
	 * 
	 * Constructor.
	 * 
	 * @param text. Texto a mostrar en el contenedor.
	 */
	public VSearchTextArea(String text) {
		
		super(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textArea = new JTextArea(text, 1, 40);
		this.setViewportView(textArea);
		
	}

	/**
	 * 
	 * Devuelve �rea de texto.
	 * 
	 * @return �rea de texto.
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * 
	 * Modifica el �rea de texto.
	 * 
	 * @param textArea. �rea de texto.
	 */
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	

}
