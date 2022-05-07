package gpp.view.component;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import gpp.GPPSystem;

public class VButton extends JButton {

	private boolean isFocus; // Indica si el botón está marcado
	private boolean isMouseEntered; // Indica si el ratón está sobre el botón
	private FocusListener focusListener; // Listener para focus del botón
	private MouseListener mouseListener; // Listener para eventos del ratón
	private int buttonCode; // código de identificación del tipo de botón

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor para botón sin parámetros.
	 * 
	 */
	public VButton() {

		super();
		
		this.buttonCode = -1;

		// Damos estilo al botón
		this.setButtonStyle();

		// Añadimos los listener al button
		this.setButtonListeners();

	}

	/**
	 * 
	 * Constructor para botón solo con nombre.
	 * 
	 * @param name. Nombre del botón.
	 */
	public VButton(String name) {

		super(name);
		
		this.buttonCode = -1;

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
		
		this.buttonCode = -1;

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

	public int getButtonCode() {
		return buttonCode;
	}

	public void setButtonCode(int buttonCode) {
		this.buttonCode = buttonCode;
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
	protected void setButtonStyle() {

		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		// Comprobamos si está seleccionado el botón
		if (GPPSystem.getMenuButtonSelected() == this.buttonCode
				|| GPPSystem.getSearchButtonSelected() == this.buttonCode) {

			this.setBackground(VColor.getGRAY_FOCUS_MENU());
			System.out.println("COLORES BOTÓN: " + GPPSystem.getMenuButtonSelected() + ", " + GPPSystem.getSearchButtonSelected() + ", " + this.buttonCode);

		} else {

			this.setBackground(VColor.getGRAY_MENU());

		}
		this.setOpaque(true);

	}

	/**
	 * 
	 * Asigna todos los listener al botón.
	 * 
	 */
	protected void setButtonListeners() {

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
	protected void setLeftMenuButtonFocusListener() {

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

						// Comprobamos si está seleccionado el botón
						if (GPPSystem.getMenuButtonSelected() == buttonCode
								|| GPPSystem.getSearchButtonSelected() == buttonCode) {

							setBackground(VColor.getGRAY_FOCUS_MENU());

						} else {

							setBackground(VColor.getGRAY_MENU());

						}

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
	protected void setLeftMenuButtonMouseListener() {

		if (mouseListener == null) {

			mouseListener = new MouseAdapter() {

				public void mouseEntered(MouseEvent evt) {

					setMouseEntered(true);
					setBackground(VColor.getGRAY_FOCUS_MENU());

				}

				public void mouseExited(MouseEvent evt) {

					setMouseEntered(false);

					if (!isFocus()) {

						// Comprobamos si está seleccionado el botón
						if (GPPSystem.getMenuButtonSelected() == buttonCode
								|| GPPSystem.getSearchButtonSelected() == buttonCode) {

							setBackground(VColor.getGRAY_FOCUS_MENU());

						} else {

							setBackground(VColor.getGRAY_MENU());

						}

					}

				}

			};

		}

	}

}
