package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gpp.model.Repository;
import gpp.model.languageparser.java.JavaLanguageParser;
import gpp.model.languageparser.python.PythonLanguageParser;
import gpp.view.component.VColor;
import gpp.view.component.VSearchFieldContainer;
import gpp.view.window.search.language.JavaFilter;
import gpp.view.window.search.language.PythonFilter;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;

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
	private JLabel pythonTitle; // título de python
	private PythonFilter pythonFilter; // filtros para el lenguaje python
	private ArrayList<VSearchFieldContainer> fieldsParamsList; // lista de parámetros

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
		pythonFilter = new PythonFilter();

		// Creamos lista de parámetros
		fieldsParamsList = new ArrayList<VSearchFieldContainer>();

		// Añadimos los contenedores con los filtros de los lenguajes
		// JAVA
		javaTitle = new JLabel("Java");
		setTitleLanguageDesign(javaTitle);
		container.add(javaTitle);
		for (VSearchFieldContainer vc : javaFilter.getFieldsList()) {

			if (javaFilter.getFieldsListValues().get(JavaLanguageParser.LIBRARIES) == vc
					|| javaFilter.getFieldsListValues().get(JavaLanguageParser.CLASSES_NAMES) == vc
					|| javaFilter.getFieldsListValues().get(JavaLanguageParser.METHODS_NAMES) == vc
					|| javaFilter.getFieldsListValues().get(JavaLanguageParser.INTERFACES_NAMES) == vc) {
				
				vc.getParamTextField().addPlaceholder("java.io, JFrame, IActionCommand");

			} else {
				
				vc.getParamTextField().addPlaceholder("0..100, 200, >1000");
				
			}
			
			container.add(vc);
			fieldsParamsList.add(vc);

		}

		// PYTHON
		pythonTitle = new JLabel("Python");
		setTitleLanguageDesign(pythonTitle);
		container.add(pythonTitle);
		for (VSearchFieldContainer vc : pythonFilter.getFieldsList()) {

			if (pythonFilter.getFieldsListValues().get(PythonLanguageParser.LIBRARIES) == vc
					|| pythonFilter.getFieldsListValues().get(PythonLanguageParser.CLASSES_NAMES) == vc
					|| pythonFilter.getFieldsListValues().get(PythonLanguageParser.FUNCTIONS_NAMES) == vc) {
				
				vc.getParamTextField().addPlaceholder("pytorch, math, so");

			} else {
				
				vc.getParamTextField().addPlaceholder("0..100, 200, >1000");
				
			}
			
			container.add(vc);
			fieldsParamsList.add(vc);

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

		} else if (repository.getMainLanguage().toLowerCase().equals("python")) {

			isValid = pythonFilter.filterRepositoryLanguage(repository);

		}

		return isValid;

	}

	/**
	 * 
	 * Resetea todos los campos.
	 * 
	 */
	public void resetFields() {

		for (VSearchFieldContainer vs : fieldsParamsList) {

			vs.getParamTextField().setText("");

		}

		// Reseteamos el scroll
		scrollContainer.getViewport().setViewPosition(new Point(0, 0));

	}

	/**
	 * 
	 * Modifica el diseño de los títulos del lenguaje.
	 * 
	 * @param title. Título del lenguaje
	 */
	private void setTitleLanguageDesign(JLabel title) {

		title.setBackground(VColor.getGRAY_MENU());
		title.setFont(new Font("Dialog", Font.ITALIC, 32));
		title.setForeground(VColor.getBLUE_REPOSITORY_TITLE());
		title.setBorder(new EmptyBorder(10, 30, 0, 0));

	}

}
