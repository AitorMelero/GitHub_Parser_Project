package gpp.view.component;

/**
 * 
 * Clase que implementa el diseño de los botones de elección de pantalla en
 * buscar.
 * 
 * @author Aitor Melero
 *
 */
public class VWindowSearchButton extends VButton {

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 * @param name. Cadena del botón.
	 */
	public VWindowSearchButton(String name) {

		super(name);
		
		// Estilo
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setBackground(VColor.getGRAY_MENU());
		this.setOpaque(true);
		
		// Listeners
		this.setButtonListeners();

	}

}
