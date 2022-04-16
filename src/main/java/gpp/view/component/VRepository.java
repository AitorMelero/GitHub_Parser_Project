package gpp.view.component;

import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gpp.model.Repository;

/**
 * 
 * Clase que implementa el diseño de la pantalla de información de un
 * repositorio.
 * 
 * @author Aitor Melero
 *
 */
public class VRepository extends JPanel {

	private Repository repository; // repositorio
	private JLabel title; // título
	private JScrollPane infoContainerScroll; // contenedor con scroll
	private JPanel infoContainer; // contenedor con la información del repositorio
	private JButton goBackButton; // botón para ir atrás

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	public VRepository() {

		title = new JLabel("Información del repositorio");
		infoContainerScroll = new JScrollPane();
		infoContainerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		infoContainer = new JPanel();
		infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));
		goBackButton = new JButton("Atrás");
		goBackButton.setActionCommand("go back");

		infoContainerScroll.add(infoContainer);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(title);
		this.add(goBackButton);
		this.add(infoContainerScroll);

	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Modifica la pantalla para otro repositorio.
	 * 
	 * @param repo. Repositorio del que mostrar información.
	 */
	public void setRepository(Repository repo) {

		infoContainer.removeAll();
		infoContainerScroll.setViewportView(null);
		infoContainerScroll.revalidate();
		infoContainerScroll.repaint();

		// Añadimos la información al contenedor
		JLabel owner = new JLabel("Autor: " + repo.getOwnerName());
		infoContainer.add(owner);
		JLabel name = new JLabel("Nombre: " + repo.getName());
		infoContainer.add(name);

		infoContainerScroll.setViewportView(infoContainer);
		infoContainerScroll.getViewport().setViewPosition(new Point(0, 0));

	}

	/**
	 * 
	 * Agrega los listeners a todos los componentes de la pantalla que lo necesitan.
	 * 
	 * @param action. Listener.
	 */
	public void setControllers(ActionListener action) {

		goBackButton.addActionListener(action);

	}

}
