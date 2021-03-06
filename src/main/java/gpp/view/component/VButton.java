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

	private boolean isFocus; // Indica si el bot?n est? marcado
	private boolean isMouseEntered; // Indica si el rat?n est? sobre el bot?n
	private FocusListener focusListener; // Listener para focus del bot?n
	private MouseListener mouseListener; // Listener para eventos del rat?n
	private int buttonCode; // c?digo de identificaci?n del tipo de bot?n

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor para bot?n sin par?metros.
	 * 
	 */
	public VButton() {

		super();
		
		this.buttonCode = -1;

		// Damos estilo al bot?n
		this.setButtonStyle();

		// A?adimos los listener al button
		this.setButtonListeners();

	}

	/**
	 * 
	 * Constructor para bot?n solo con nombre.
	 * 
	 * @param name. Nombre del bot?n.
	 */
	public VButton(String name) {

		super(name);
		
		this.buttonCode = -1;

		// Damos estilo al bot?n
		this.setButtonStyle();

		// A?adimos los listener al button
		this.setButtonListeners();

	}

	/**
	 * 
	 * Constructor para bot?n con nombre e icono.
	 * 
	 * @param name. Nombre del bot?n.
	 * @param icon. Icono del bot?n.
	 */
	public VButton(String name, Icon icon) {

		super(name, icon);
		
		this.buttonCode = -1;

		// Damos estilo al bot?n
		this.setButtonStyle();

		// A?adimos los listener al button
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
	 * M?TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Define un estilo para el bot?n.
	 * 
	 */
	protected void setButtonStyle() {

		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		// Comprobamos si est? seleccionado el bot?n
		if (GPPSystem.getMenuButtonSelected() == this.buttonCode
				|| GPPSystem.getSearchButtonSelected() == this.buttonCode) {

			this.setBackground(VColor.getGRAY_FOCUS_MENU());
			System.out.println("COLORES BOT?N: " + GPPSystem.getMenuButtonSelected() + ", " + GPPSystem.getSearchButtonSelected() + ", " + this.buttonCode);

		} else {

			this.setBackground(VColor.getGRAY_MENU());

		}
		this.setOpaque(true);

	}

	/**
	 * 
	 * Asigna todos los listener al bot?n.
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
	 * Asignamos un focus listener al bot?n.
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

						// Comprobamos si est? seleccionado el bot?n
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
	 * Asigna un mouse listener al bot?n.
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

						// Comprobamos si est? seleccionado el bot?n
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
