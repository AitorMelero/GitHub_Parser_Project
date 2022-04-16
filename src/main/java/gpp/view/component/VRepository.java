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
 * Clase que implementa el dise�o de la pantalla de informaci�n de un
 * repositorio.
 * 
 * @author Aitor Melero
 *
 */
public class VRepository extends JPanel {

	private Repository repository; // repositorio
	private JLabel title; // t�tulo
	private JScrollPane infoContainerScroll; // contenedor con scroll
	private JPanel infoContainer; // contenedor con la informaci�n del repositorio
	private JButton goBackButton; // bot�n para ir atr�s

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	public VRepository() {

		title = new JLabel("Informaci�n del repositorio");
		infoContainerScroll = new JScrollPane();
		infoContainerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		infoContainer = new JPanel();
		infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));
		goBackButton = new JButton("Atr�s");
		goBackButton.setActionCommand("go back");

		infoContainerScroll.add(infoContainer);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(title);
		this.add(goBackButton);
		this.add(infoContainerScroll);

	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Modifica la pantalla para otro repositorio.
	 * 
	 * @param repo. Repositorio del que mostrar informaci�n.
	 */
	public void setRepository(Repository repo) {

		infoContainer.removeAll();
		infoContainerScroll.setViewportView(null);
		infoContainerScroll.revalidate();
		infoContainerScroll.repaint();

		// A�adimos la informaci�n al contenedor
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
