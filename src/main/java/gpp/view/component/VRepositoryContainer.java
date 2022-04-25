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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.constant.GPPConstant;
import gpp.model.Repository;

/**
 * 
 * Clase que implementa el diseño del botón del contenedor de un repositorio.
 * 
 * @author Aitor Melero.
 *
 */
public class VRepositoryContainer extends JButton {

	private Repository repository; // repositorio
	private boolean isFocus; // Indica si el botón está marcado
	private boolean isMouseEntered; // Indica si el ratón está sobre el botón
	private FocusListener focusListener; // Listener para focus del botón
	private MouseListener mouseListener; // Listener para eventos del ratón
	private JPanel container; // contenedor general
	private JLabel repositoryTitle; // título del repositorio
	private JLabel description; // descripción del repositorio
	private JPanel extraInfo; // contenedor de información extra
	private JLabel stars; // estrellas del repositorio
	private JLabel language; // lenguaje principal del repositorio
	private JLabel license; // licencia del repositorio
	private JLabel date; // fecha de actualización del repositorio

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	public VRepositoryContainer(Repository repository) {

		this.setLayout(null);

		// Sacamos datos del repositorio
		String descriptionString = repository.getDescription();
		String starsString = "0";
		long numberStars = repository.getStarsNumber();
		DecimalFormat df1 = new DecimalFormat("#.#");
		DecimalFormat df2 = new DecimalFormat("#");
		if (numberStars >= 100000) {
			double number = numberStars / 1000.0;
			starsString = df2.format(number) + "k";
		} else if (numberStars >= 1000) {
			double number = numberStars / 1000.0;
			starsString = df1.format(number) + "k";
		} else {
			starsString = numberStars + "";
		}
		String licenseString = repository.getLicense();
		String dateUpdated = repository.getDateUpdated();

		container = new JPanel();
		container.setBounds(0, 0, 790, 125);
		container.setBackground(VColor.getGRAY_MENU());
		container.setBorder(BorderFactory.createLineBorder(VColor.getGRAY_FOCUS_MENU()));
		extraInfo = new JPanel();
		extraInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		extraInfo.setBounds(12, 87, 713, 16);
		extraInfo.setBackground(VColor.getGRAY_MENU());

		repositoryTitle = new JLabel(repository.getOwnerName() + "/" + repository.getName());
		repositoryTitle.setBounds(32, 12, 693, 27);
		repositoryTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		repositoryTitle.setForeground(VColor.getBLUE_REPOSITORY_TITLE());
		description = new JLabel(descriptionString);
		description.setBounds(32, 51, 693, 16);
		Font fontInfoExtra = new Font("Dialog", Font.ITALIC, 12);
		stars = new JLabel(starsString, new ImageIcon(GPPConstant.GPP_ICONS + "star.png"), LEFT);
		stars.setBounds(12, 67, 31, 16);
		stars.setFont(fontInfoExtra);
		language = new JLabel(repository.getMainLanguage());
		language.setBounds(99, 67, 27, 16);
		language.setFont(fontInfoExtra);
		license = new JLabel(licenseString);
		license.setBounds(197, 67, 64, 16);
		license.setFont(fontInfoExtra);
		date = new JLabel("Actualizado el " + dateUpdated);
		date.setBounds(273, 67, 136, 16);
		date.setFont(fontInfoExtra);
		container.setLayout(null);

		container.add(repositoryTitle);
		container.add(description);
		extraInfo.add(stars);
		extraInfo.add(language);
		extraInfo.add(license);
		extraInfo.add(date);
		container.add(extraInfo);

		// this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setBackground(VColor.getGRAY_MENU());
		this.setOpaque(true);

		// this.setBounds(20, 144, 800, 125);
		this.setMinimumSize(new Dimension(790, 125));
		this.setMaximumSize(new Dimension(790, 125));
		this.setPreferredSize(new Dimension(790, 125));
		this.add(container);
		this.setActionCommand(repository.getOwnerName() + "/" + repository.getName());

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
