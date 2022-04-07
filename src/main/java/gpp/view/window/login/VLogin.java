package gpp.view.window.login;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import gpp.view.component.VColor;

/**
 * 
 * Clase que implementa la pantalla del login.
 * 
 * @author Aitor Melero
 *
 */
public class VLogin extends JPanel {

	private JPanel container; // Contenedor general
	private JLabel titleGPP; // título
	private JLabel tokenLabel; // texto del label del token
	private JPasswordField tokenField; // campo de texto del token
	private JPanel containerButton;  // contenedor de botones
	private JButton loginButton;  // botón de iniciar sesión
	private JButton tokenButton;  // botón de redirección para obtener token

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	public VLogin() {

		// Creamos los componentes
		container = new JPanel();
		titleGPP = new JLabel("GitHub Parser Project");
		tokenLabel = new JLabel("Introduce tu token de GitHub:");
		tokenField = new JPasswordField();
		containerButton = new JPanel();
		loginButton = new JButton("Iniciar sesión");
		tokenButton = new JButton("¿Cómo obtengo un token de GitHub?");

		// Título
		titleGPP.setOpaque(true);
		titleGPP.setBackground(VColor.getGRAY_MENU());
		titleGPP.setFont(new Font("Dialog", Font.BOLD, 42));

		// Texto del campo del token
		tokenLabel.setOpaque(true);
		tokenLabel.setBackground(VColor.getGRAY_MENU());
		tokenLabel.setBorder(new EmptyBorder(50, 0, 10, 0));
		tokenLabel.setFont(new Font("Arial", Font.PLAIN, 22));

		// Campo de texto del token
		tokenField.setFont(new Font("Arial", Font.PLAIN, 20));
		tokenField.setBackground(VColor.getWHITE_MAIN());
		tokenField.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(VColor.getBLACK_MAIN(), 1), new EmptyBorder(5, 5, 5, 5)));
		
		// Contenedor de botones
		containerButton.setLayout(new BoxLayout(containerButton, BoxLayout.Y_AXIS));
		containerButton.add(loginButton, BorderLayout.CENTER);
		containerButton.add(tokenButton, BorderLayout.CENTER);
		//containerButton.setBorder(new EmptyBorder(20, 20, 20, 20));

		// Contenedor general
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setBackground(VColor.getGRAY_MENU());
		container.add(titleGPP);
		container.add(tokenLabel);
		container.add(tokenField);
		container.add(containerButton);
		this.add(container, BorderLayout.CENTER);

		// Estilo general
		this.setBorder(new EmptyBorder(60, 40, 60, 40));
		this.setBackground(VColor.getGRAY_MENU());

	}

}
