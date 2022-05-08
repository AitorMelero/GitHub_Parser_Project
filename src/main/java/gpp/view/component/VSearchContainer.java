package gpp.view.component;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.constant.GPPConstant;
import gpp.model.Repository;
import gpp.model.search.Search;

/**
 * 
 * Clase que implementa el diseño del contenedor de una búsqueda.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearchContainer extends JButton {

	private Search search; // búsqueda
	private boolean isFocus; // Indica si el botón está marcado
	private boolean isMouseEntered; // Indica si el ratón está sobre el botón
	private FocusListener focusListener; // Listener para focus del botón
	private MouseListener mouseListener; // Listener para eventos del ratón
	private JPanel container; // contenedor general
	private JLabel searchTitle; // título de la búsqueda
	private JPanel extraInfo; // contenedor de información extra
	private JLabel date; // fecha de creación de la búsqueda

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 * @param search. Búsqueda del contenedor.
	 */
	public VSearchContainer(Search search) {

		this.search = search;

		this.setLayout(null);

		String dateSearch = search.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		container = new JPanel();
		container.setBounds(0, 0, 807, 125);
		container.setBackground(VColor.getGRAY_MENU());
		container.setBorder(BorderFactory.createLineBorder(VColor.getGRAY_FOCUS_MENU()));
		extraInfo = new JPanel();
		extraInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		extraInfo.setBounds(12, 50, 713, 16);
		extraInfo.setBackground(VColor.getGRAY_MENU());

		searchTitle = new JLabel(search.getName());
		searchTitle.setBounds(32, 12, 693, 27);
		searchTitle.setFont(new Font("Dialog", Font.BOLD, 22));
		searchTitle.setForeground(VColor.getBLUE_REPOSITORY_TITLE());
		container.add(searchTitle);
		Font fontInfoExtra = new Font("Dialog", Font.ITALIC, 12);
		date = new JLabel("Fecha de creación: " + dateSearch);
		date.setBounds(273, 50, 136, 16);
		date.setFont(fontInfoExtra);
		container.setLayout(null);

		extraInfo.add(date);
		container.add(extraInfo);

		// this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setBackground(VColor.getGRAY_MENU());
		this.setOpaque(true);

		// this.setBounds(20, 144, 800, 125);
		this.setMinimumSize(new Dimension(807, 100));
		this.setMaximumSize(new Dimension(807, 100));
		this.setPreferredSize(new Dimension(807, 100));
		this.add(container);
		this.setActionCommand(search.getId() + "");

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
	 * Agrega los listeners a todos los componentes de la pantalla que lo necesitan.
	 * 
	 * @param action. Listener.
	 */
	public void setControllers(ActionListener action) {

		this.addActionListener(action);

	}

	/**
	 * 
	 * Asigna todos los listener al botón.
	 * 
	 */
	private void setButtonListeners() {

		this.setButtonFocusListener();
		this.addFocusListener(focusListener);
		this.setButtonMouseListener();
		this.addMouseListener(mouseListener);

	}

	/**
	 * 
	 * Asignamos un focus listener al botón.
	 * 
	 */
	private void setButtonFocusListener() {

		if (focusListener == null) {

			focusListener = new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {

					setFocus(true);
					container.setBackground(VColor.getGRAY_FOCUS_MENU());
					extraInfo.setBackground(VColor.getGRAY_FOCUS_MENU());

				}

				@Override
				public void focusLost(FocusEvent e) {

					setFocus(false);

					if (!isMouseEntered()) {

						container.setBackground(VColor.getGRAY_MENU());
						extraInfo.setBackground(VColor.getGRAY_MENU());

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
	private void setButtonMouseListener() {

		if (mouseListener == null) {

			mouseListener = new MouseAdapter() {

				public void mouseEntered(MouseEvent evt) {

					setMouseEntered(true);
					container.setBackground(VColor.getGRAY_FOCUS_MENU());
					extraInfo.setBackground(VColor.getGRAY_FOCUS_MENU());

				}

				public void mouseExited(MouseEvent evt) {

					setMouseEntered(false);

					if (!isFocus()) {

						container.setBackground(VColor.getGRAY_MENU());
						extraInfo.setBackground(VColor.getGRAY_MENU());

					}

				}

			};

		}

	}

}
