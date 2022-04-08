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

	private boolean isFocus; // Indica si el botón está marcado
	private boolean isMouseEntered; // Indica si el ratón está sobre el botón
	private FocusListener focusListener; // Listener para focus del botón
	private MouseListener mouseListener; // Listener para eventos del ratón

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor para botón solo con nombre.
	 * 
	 * @param name. Nombre del botón.
	 */
	public VButton(String name) {

		super(name);

		// Damos estilo al botón
		this.setButtonStyle();

		// Añadimos los listener al button
		this.setButtonListeners();

	}

	/**
	 * 
	 * Constructor para botón con nombre e icono.
	 * 
	 * @param name. Nombre del botón.
	 * @param icon. Icono del botón.
	 */
	public VButton(String name, Icon icon) {

		super(name, icon);

		// Damos estilo al botón
		this.setButtonStyle();

		// Añadimos los listener al button
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
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Define un estilo para el botón.
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
	 * Asigna todos los listener al botón.
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
	 * Asignamos un focus listener al botón.
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
	 * Asigna un mouse listener al botón.
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
