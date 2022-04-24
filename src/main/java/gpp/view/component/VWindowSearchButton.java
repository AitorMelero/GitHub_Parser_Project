package gpp.view.component;

/**
 * 
 * Clase que implementa el dise�o de los botones de elecci�n de pantalla en
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
	 * @param name. Cadena del bot�n.
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
