package gpp.view.component;

import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * 
 * Clase que implementa el dise�o del bot�n de buscar.
 * 
 * @author Aitor Melero
 *
 */
public class VSearchButton extends JButton {

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 * @param name. Cadena para el bot�n.
	 */
	public VSearchButton(String name) {

		super(name);
		
		// Estilo
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setBackground(VColor.getGRAY_FOCUS_MENU());
		this.setOpaque(true);

	}

}
