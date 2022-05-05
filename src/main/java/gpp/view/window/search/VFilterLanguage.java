package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.model.Repository;
import gpp.view.component.VColor;
import gpp.view.component.VSearchFieldContainer;
import gpp.view.window.search.language.JavaFilter;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Font;

/**
 * 
 * Clase que implementa el diseño de los filtros generales de una búsqueda de
 * repositorios.
 * 
 * @author Aitor Melero
 *
 */
public class VFilterLanguage extends JPanel {

	private JScrollPane scrollContainer; // contenedor con scroll general
	private JPanel container; // contenedor dentro del scroll
	private JLabel javaTitle; // título de java
	private JavaFilter javaFilter; // filtros para el lenguaje java

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * Constructor
	 */
	public VFilterLanguage() {
		setLayout(new BorderLayout(0, 0));
		setBounds(20, 144, 807, 319);

		scrollContainer = new JScrollPane();
		scrollContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollContainer);

		container = new JPanel();
		scrollContainer.setViewportView(container);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		// Creamos filtros de los lenguajes
		javaFilter = new JavaFilter();

		// Añadimos los contenedores con los filtros de los lenguajes
		javaTitle = new JLabel("Java");
		javaTitle.setBackground(VColor.getGRAY_MENU());
		javaTitle.setFont(new Font("Dialog", Font.ITALIC, 32));
		javaTitle.setForeground(VColor.getBLUE_REPOSITORY_TITLE());
		javaTitle.setBorder(new EmptyBorder(10,30,0,0));
		container.add(javaTitle);
		for (VSearchFieldContainer vc : javaFilter.getFieldsList()) {

			container.add(vc);

		}

	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Filtra un repositorio por su lenguaje principal.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si se cumple los requisitos, false en caso contrario.
	 */
	public boolean filterLanguage(Repository repository) {

		boolean isValid = true;

		// Filtramos según el lenguaje correspondiente
		if (repository.getMainLanguage().toLowerCase().equals("java")) {

			isValid = javaFilter.filterRepositoryLanguage(repository);

		}

		return isValid;

	}

}
