package gpp.view.window.search;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;

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
 * Clase que implementa el dise�o de la pantalla de resultados de la b�squeda.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearchResult extends JPanel {

	private JLabel title; // t�tulo
	private JPanel navigationPageContainer; // contenedor de navegaci�n de p�ginas
	private VWindowSearchButton previousPageButton; // bot�n para navegar a la p�gina anterior
	private VWindowSearchButton nextPageButton; // bot�n para navegar a la p�gina siguiente
	private JLabel repositoryNumberLabel; // etiqueta para n�mero de repositorios encontrados
	private JLabel numberPageLabel; // etiqueta que indica el n�mero de p�gina actual
	private JScrollPane resultContainerScroll; // contenedor para la lista de resultados con scroll
	private JPanel resultContainer; // contenedor con la lista de resultados
	private ActionListener resultContainerRepositoryListener; // listener para los contenedores de los repositorios

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * Constructor
	 */
	public VSearchResult() {

		// Estilo general
		this.setBackground(VColor.getWHITE_MAIN());
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(null);

		// Componentes
		// T�tulo
		title = new JLabel("");
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

		// Repositorios encontrados
		repositoryNumberLabel = new JLabel("");
		repositoryNumberLabel.setBackground(VColor.getWHITE_MAIN());
		repositoryNumberLabel.setBounds(20, 75, 200, 40);

		// P�ginas de resultados
		navigationPageContainer = new JPanel();
		navigationPageContainer.setBounds(300, 75, 200, 40);
		navigationPageContainer.setBackground(VColor.getWHITE_MAIN());
		numberPageLabel = new JLabel("0");
		previousPageButton = new VWindowSearchButton("<");
		previousPageButton.setEnabled(false);
		previousPageButton.setActionCommand("previous page");
		nextPageButton = new VWindowSearchButton(">");
		nextPageButton.setEnabled(false);
		nextPageButton.setActionCommand("next page");
		navigationPageContainer.add(previousPageButton);
		navigationPageContainer.add(numberPageLabel);
		navigationPageContainer.add(nextPageButton);

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el listener de los contenedores de los repositorios.
	 * 
	 * @return Listener de los contenedores de los repositorios.
	 */
	public ActionListener getResultContainerRepositoryListener() {
		return resultContainerRepositoryListener;
	}

	/**
	 * 
	 * Modifica el listener de los contenedores de los repositorios.
	 * 
	 * @param resultContainerRepositoryListener. Listener de los contenedores de los
	 *                                           repositorios.
	 */
	public void setResultContainerRepositoryListener(ActionListener resultContainerRepositoryListener) {
		this.resultContainerRepositoryListener = resultContainerRepositoryListener;
	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Muestra la lista de contenedores del repositorio para un n�mero de p�gina
	 * determinado.
	 * 
	 * @param currentSearch. B�squeda actual.
	 * @param page.          N�mero de p�gina a mostrar.
	 */
	public void setSearchResultCurrent(Search currentSearch, int page) {

		// Borramos el contenido de la b�squeda anterior
		// navigationPageContainer.removeAll();
		resultContainer.removeAll();
		resultContainerScroll.setViewportView(null);
		resultContainerScroll.revalidate();
		resultContainerScroll.repaint();
		this.removeAll();
		this.revalidate();
		this.repaint();

		title.setText(currentSearch.getName());
		repositoryNumberLabel.setText(currentSearch.getListRepoResult().size() + " repositorios encontrados");
		numberPageLabel.setText("P�gina " + Integer.toString(page) + " de " + currentSearch.getResult().size());

		// A�adimos componentes
		this.add(title);
		this.add(repositoryNumberLabel);
		if (page == 1) {

			previousPageButton.setEnabled(false);

			if (page != currentSearch.getResult().size()) {

				nextPageButton.setEnabled(true);

			} else {

				nextPageButton.setEnabled(false);

			}

		} else if (page == currentSearch.getResult().size()) {

			previousPageButton.setEnabled(true);
			nextPageButton.setEnabled(false);

		} else {

			previousPageButton.setEnabled(true);
			nextPageButton.setEnabled(true);

		}

		this.add(navigationPageContainer);

		// A�adimos los contenedores de todos los repositorios devueltos en la b�squeda
		Repository r;
		VRepositoryContainer repositoryContainer;
		int numPages = currentSearch.getResult().size(); // n�mero de p�ginas
		int numRepo = currentSearch.getListRepoResult().size(); // n�mero de repositorios
		int numRepoInPages = 100;

		if (page == numPages) {

			numRepoInPages = numRepo % 100;

			if (numRepoInPages == 0) {

				numRepoInPages = 100;

			}

		}

		for (int i = 0; i < numRepoInPages; i++) {

			r = currentSearch.getListRepoResult().get(100 * (page - 1) + i);

			repositoryContainer = new VRepositoryContainer(r);

			// A�adimos el listener al contenedor del repositorio
			repositoryContainer.setControllers(resultContainerRepositoryListener);

			resultContainer.add(repositoryContainer);

		}

		resultContainerScroll.setViewportView(resultContainer);
		resultContainerScroll.getViewport().setViewPosition(new Point(0, 0));
		this.add(resultContainerScroll);

	}

	/**
	 * 
	 * Agrega los listeners a todos los componentes de la pantalla que lo necesitan.
	 * 
	 * @param action. Listener.
	 */
	public void setControllers(ActionListener action) {

		previousPageButton.addActionListener(action);
		nextPageButton.addActionListener(action);

	}

}
