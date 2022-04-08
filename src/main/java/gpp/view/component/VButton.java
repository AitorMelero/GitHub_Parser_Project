package gpp.view.component;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VButton extends JButton {

	private boolean isFocus; // Indica si el bot�n est� marcado
	private boolean isMouseEntered; // Indica si el rat�n est� sobre el bot�n
	private FocusListener focusListener; // Listener para focus del bot�n
	private MouseListener mouseListener; // Listener para eventos del rat�n

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor para bot�n solo con nombre.
	 * 
	 * @param name. Nombre del bot�n.
	 */
	public VButton(String name) {

		super(name);

		// Damos estilo al bot�n
		this.setButtonStyle();

		// A�adimos los listener al button
		this.setButtonListeners();

	}

	/**
	 * 
	 * Constructor para bot�n con nombre e icono.
	 * 
	 * @param name. Nombre del bot�n.
	 * @param icon. Icono del bot�n.
	 */
	public VButton(String name, Icon icon) {

		super(name, icon);

		// Damos estilo al bot�n
		this.setButtonStyle();

		// A�adimos los listener al button
		this.setButtonListeners();

	}

	/**************************************************************************
	 * GETTERS AND SETTERS
	 * ************************************************************************
	 */

	private boolean isFocus() {
		return isFocus;
	}

	private void setFocus(boolean isFocus) {
		this.isFocus = isFocus;
	}

	private boolean isMouseEntered() {
		return isMouseEntered;
	}

	private void setMouseEntered(boolean isMouseEntered) {
		this.isMouseEntered = isMouseEntered;
	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Define un estilo para el bot�n.
	 * 
	 */
	private void setButtonStyle() {

		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setBackground(VColor.getGRAY_MENU());
		this.setOpaque(true);

	}

	/**
	 * 
	 * Asigna todos los listener al bot�n.
	 * 
	 */
	private void setButtonListeners() {

		this.setLeftMenuButtonFocusListener();
		this.addFocusListener(focusListener);
		this.setLeftMenuButtonMouseListener();
		this.addMouseListener(mouseListener);

	}

	/**
	 * 
	 * Asignamos un focus listener al bot�n.
	 * 
	 */
	private void setLeftMenuButtonFocusListener() {

		if (focusListener == null) {

			focusListener = new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {

					setFocus(true);
					setBackground(VColor.getGRAY_FOCUS_MENU());

				}

				@Override
				public void focusLost(FocusEvent e) {

					setFocus(false);

					if (!isMouseEntered()) {

						setBackground(VColor.getGRAY_MENU());

					}

				}

			};

		}

	}

	/**
	 * 
	 * Asigna un mouse listener al bot�n.
	 * 
	 */
	private void setLeftMenuButtonMouseListener() {

		if (mouseListener == null) {

			mouseListener = new MouseAdapter() {

				public void mouseEntered(MouseEvent evt) {

					setMouseEntered(true);
					setBackground(VColor.getGRAY_FOCUS_MENU());

				}

				public void mouseExited(MouseEvent evt) {

					setMouseEntered(false);

					if (!isFocus()) {

						setBackground(VColor.getGRAY_MENU());

					}

				}

			};

		}

	}

}
