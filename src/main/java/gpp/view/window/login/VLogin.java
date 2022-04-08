package gpp.view.window.login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import gpp.view.component.VButton;
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
	private JPanel containerTitle;  // Contenedor para el título
	private JLabel titleGPP; // título
	private JPanel containerTokenLabel;  // Contenedor para el label del token
	private JLabel tokenLabel; // texto del label del token
	private JPanel containerTokenField;  // contenedor para el campo del token
	private JPasswordField tokenField; // campo de texto del token
	private JPanel containerButton;  // contenedor de botones
	private VButton loginButton;  // botón de iniciar sesión
	private VButton tokenButton;  // botón de redirección para obtener token

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	public VLogin() {

		// Creamos los componentes
		container = new JPanel();
		containerTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titleGPP = new JLabel("GitHub Parser Project");
		containerTokenLabel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tokenLabel = new JLabel("Introduce tu token de GitHub:");
		containerTokenField = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tokenField = new JPasswordField();
		containerButton = new JPanel();
		loginButton = new VButton("Iniciar sesión");
		tokenButton = new VButton("Obtener token de GitHub");

		// Título
		titleGPP.setOpaque(true);
		titleGPP.setBackground(VColor.getGRAY_MENU());
		titleGPP.setFont(new Font("Dialog", Font.BOLD, 42));
		containerTitle.setBackground(VColor.getGRAY_MENU());
		containerTitle.add(titleGPP);
		

		// Texto del campo del token
		tokenLabel.setOpaque(true);
		tokenLabel.setBackground(VColor.getGRAY_MENU());
		tokenLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		containerTokenLabel.setBackground(VColor.getGRAY_MENU());
		containerTokenLabel.setBorder(new EmptyBorder(50, 0, 10, 0));
		containerTokenLabel.add(tokenLabel);

		// Campo de texto del token
		tokenField.setFont(new Font("Arial", Font.PLAIN, 20));
		tokenField.setPreferredSize(new Dimension(500, 25));
		tokenField.setBackground(VColor.getWHITE_MAIN());
		tokenField.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(VColor.getBLACK_MAIN(), 1), new EmptyBorder(5, 5, 5, 5)));
		containerTokenField.setBackground(VColor.getGRAY_MENU());
		containerTokenField.add(tokenField);
		
		// Contenedor y estilos de botones
		containerButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		loginButton.setFont(new Font("Arial", Font.PLAIN, 20));
		containerButton.add(loginButton);
		// Subrayado de botón de información para obtener token
		Hashtable<TextAttribute, Object> map =
	            new Hashtable<TextAttribute, Object>();
		map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    tokenButton.setFont(tokenButton.getFont().deriveFont(map));
		containerButton.add(tokenButton);
		containerButton.setBackground(VColor.getGRAY_MENU());
		containerButton.setBorder(new EmptyBorder(20, 0, 20, 0));

		// Contenedor general
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setBackground(VColor.getGRAY_MENU());
		container.add(containerTitle);
		container.add(containerTokenLabel);
		container.add(containerTokenField);
		container.add(containerButton);
		this.add(container, BorderLayout.CENTER);

		// Estilo general
		this.setBorder(new EmptyBorder(125, 0, 100, 0));
		this.setBackground(VColor.getGRAY_MENU());
		
		// Meter fondo
		/*Icon myPicture = new ImageIcon("src/main/resources/images/login.jpg");
		JLabel picLabel = new JLabel(myPicture);
		add(picLabel);*/

	}

}
