package gpp.view.window.recentsearch;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gpp.model.Repository;
import gpp.model.search.Search;
import gpp.view.component.VColor;
import gpp.view.component.VRepositoryContainer;
import gpp.view.component.VWindowSearchButton;

/**
 * 
 * Clase que implementa el dise�o de b�squedas recientes.
 * 
 * @author mele9
 *
 */
public class VRecentSearch extends JPanel {

	private JLabel title; // t�tulo
	private JPanel navigationPageContainer; // contenedor de navegaci�n de p�ginas
	private VWindowSearchButton previousPageButton; // bot�n para navegar a la p�gina anterior
	private VWindowSearchButton nextPageButton; // bot�n para navegar a la p�gina siguiente
	private JLabel searchNumberLabel; // etiqueta para n�mero de repositorios encontrados
	private JLabel numberPageLabel; // etiqueta que indica el n�mero de p�gina actual
	private JScrollPane resultContainerScroll; // contenedor para la lista de resultados con scroll
	private JPanel resultContainer; // contenedor con la lista de resultados
	private ActionListener resultContainerSearchListener; // listener para los contenedores de los repositorios

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * Constructor
	 */
	public VRecentSearch() {

		// Estilo general
		this.setBackground(VColor.getWHITE_MAIN());
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setLayout(null);

		// Componentes
		// T�tulo
		title = new JLabel("B�squedas guardadas");
		title.setBounds(20, 11, 500, 42);
		title.setOpaque(true);
		title.setBackground(VColor.getWHITE_MAIN());
		title.setFont(new Font("Dialog", Font.ITALIC, 32));

		// Resultados
		resultContainerScroll = new JScrollPane();
		resultContainer = new JPanel();
		resultContainerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		resultContainerScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		resultContainerScroll.setBounds(20, 144, 807, 465);
		resultContainer.setLayout(new BoxLayout(resultContainer, BoxLayout.Y_AXIS));

		// B�squedas guardadas
		searchNumberLabel = new JLabel("0 b�squedas guardadas");
		searchNumberLabel.setBackground(VColor.getWHITE_MAIN());
		searchNumberLabel.setBounds(20, 75, 200, 40);

		// P�ginas de b�squedas
		navigationPageContainer = new JPanel();
		navigationPageContainer.setBounds(300, 75, 200, 40);
		navigationPageContainer.setBackground(VColor.getWHITE_MAIN());
		numberPageLabel = new JLabel("P�gina 0 de 0");
		previousPageButton = new VWindowSearchButton("<");
		previousPageButton.setEnabled(false);
		previousPageButton.setActionCommand("previous page");
		nextPageButton = new VWindowSearchButton(">");
		nextPageButton.setEnabled(false);
		nextPageButton.setActionCommand("next page");
		navigationPageContainer.add(previousPageButton);
		navigationPageContainer.add(numberPageLabel);
		navigationPageContainer.add(nextPageButton);
		
		this.add(title);
		this.add(searchNumberLabel);
		this.add(navigationPageContainer);
		this.add(resultContainerScroll);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */


	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Muestra la lista de contenedores de b�squedas para un n�mero de p�gina
	 * determinado.
	 * 
	 * @param currentSearch. B�squeda actual.
	 * @param page.          N�mero de p�gina a mostrar.
	 */
	public void setSearchResultCurrent(ArrayList<Search> searches, int page) {

		

	}

	/**
	 * 
	 * Agrega los listeners a todos los componentes de la pantalla que lo necesitan.
	 * 
	 * @param action. Listener.
	 */
	public void setControllers(ActionListener action) {

		//previousPageButton.addActionListener(action);

	}

}
