package gpp.view.window.search.language;

import java.util.ArrayList;

import gpp.model.Repository;
import gpp.model.languageparser.LanguageParser;
import gpp.view.component.VSearchFieldContainer;

/**
 * 
 * Clase que implementa el filtro para el lenguaje Java.
 * 
 * @author Aitor Melero.
 *
 */
public class JavaFilter extends Filter {

	private VSearchFieldContainer commentField;
	private VSearchFieldContainer importsField;
	private VSearchFieldContainer ifField;
	private VSearchFieldContainer elseField;
	private VSearchFieldContainer forField;
	private VSearchFieldContainer whileField;
	private VSearchFieldContainer continueField;
	private VSearchFieldContainer breakField;
	private VSearchFieldContainer arraysField;
	private VSearchFieldContainer lambdasField;
	private VSearchFieldContainer methodsField;
	private VSearchFieldContainer variablesField;
	private VSearchFieldContainer localVariablesField;
	private VSearchFieldContainer staticField;
	private VSearchFieldContainer publicField;
	private VSearchFieldContainer privateField;
	private VSearchFieldContainer protectedField;
	private VSearchFieldContainer abstractField;
	private VSearchFieldContainer classesField;
	private VSearchFieldContainer yieldField;
	private VSearchFieldContainer assertField;
	private VSearchFieldContainer tryField;
	private VSearchFieldContainer annotationField;
	private VSearchFieldContainer personalConstructorField;
	private VSearchFieldContainer personalInterfaceField;
	private VSearchFieldContainer implementsField;
	private VSearchFieldContainer extendsField;
	private VSearchFieldContainer throwsField;
	private VSearchFieldContainer throwField;
	private VSearchFieldContainer enumField;
	private VSearchFieldContainer finalField;
	private VSearchFieldContainer switchField;
	private VSearchFieldContainer instanceofField;
	private VSearchFieldContainer synchronizedField;

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public JavaFilter() {

		super();

		commentField = new VSearchFieldContainer("Número de comentarios", "");
		super.getFieldsList().add(commentField);
		importsField = new VSearchFieldContainer("Número de imports", "");
		super.getFieldsList().add(importsField);
		ifField = new VSearchFieldContainer("Número de if", "");
		super.getFieldsList().add(ifField);
		elseField = new VSearchFieldContainer("Número de else", "");
		super.getFieldsList().add(elseField);
		forField = new VSearchFieldContainer("Número de for", "");
		super.getFieldsList().add(forField);
		whileField = new VSearchFieldContainer("Número de while", "");
		super.getFieldsList().add(whileField);
		continueField = new VSearchFieldContainer("Número de continue", "");
		super.getFieldsList().add(continueField);
		breakField = new VSearchFieldContainer("Número de break", "");
		super.getFieldsList().add(breakField);
		arraysField = new VSearchFieldContainer("Número de arrays", "");
		super.getFieldsList().add(arraysField);
		lambdasField = new VSearchFieldContainer("Número de lambdas", "");
		super.getFieldsList().add(lambdasField);
		methodsField = new VSearchFieldContainer("Número de methods", "");
		super.getFieldsList().add(methodsField);
		variablesField = new VSearchFieldContainer("Número de variables", "");
		super.getFieldsList().add(variablesField);
		localVariablesField = new VSearchFieldContainer("Número de variables locales", "");
		super.getFieldsList().add(localVariablesField);
		staticField = new VSearchFieldContainer("Número de campos static", "");
		super.getFieldsList().add(staticField);
		publicField = new VSearchFieldContainer("Número de campos public", "");
		super.getFieldsList().add(publicField);
		privateField = new VSearchFieldContainer("Número de campos private", "");
		super.getFieldsList().add(privateField);
		protectedField = new VSearchFieldContainer("Número de campos protected", "");
		super.getFieldsList().add(protectedField);
		abstractField = new VSearchFieldContainer("Número de campos abstract", "");
		super.getFieldsList().add(abstractField);
		classesField = new VSearchFieldContainer("Número de clases", "");
		super.getFieldsList().add(classesField);
		yieldField = new VSearchFieldContainer("Número de yield", "");
		super.getFieldsList().add(yieldField);
		assertField = new VSearchFieldContainer("Número de assert", "");
		super.getFieldsList().add(assertField);
		tryField = new VSearchFieldContainer("Número de try", "");
		super.getFieldsList().add(tryField);
		annotationField = new VSearchFieldContainer("Número de annotations", "");
		super.getFieldsList().add(annotationField);
		personalConstructorField = new VSearchFieldContainer("Número de constructores personales", "");
		super.getFieldsList().add(personalConstructorField);
		personalInterfaceField = new VSearchFieldContainer("Número de interfaces personales", "");
		super.getFieldsList().add(personalInterfaceField);
		implementsField = new VSearchFieldContainer("Número de implements", "");
		super.getFieldsList().add(implementsField);
		extendsField = new VSearchFieldContainer("Número de extends", "");
		super.getFieldsList().add(extendsField);
		throwsField = new VSearchFieldContainer("Número de throws", "");
		super.getFieldsList().add(throwsField);
		throwField = new VSearchFieldContainer("Número de throw", "");
		super.getFieldsList().add(throwField);
		enumField = new VSearchFieldContainer("Número de enum", "");
		super.getFieldsList().add(enumField);
		finalField = new VSearchFieldContainer("Número de final", "");
		super.getFieldsList().add(finalField);
		switchField = new VSearchFieldContainer("Número de switch", "");
		super.getFieldsList().add(switchField);
		instanceofField = new VSearchFieldContainer("Número de instanceof", "");
		super.getFieldsList().add(instanceofField);
		synchronizedField = new VSearchFieldContainer("Número de synchronized", "");
		super.getFieldsList().add(synchronizedField);

	}

	/**************************************************************************
	 * MÉTODOS
	 * ************************************************************************
	 */

	@Override
	public boolean filterRepositoryLanguage(Repository repository) {

		LanguageParser languageProperties = repository.getLanguageProperties();
		
		// SACAR CADENAS LIMPIAS
		// COMPARAR CADENA CON VALOR LLAMANDO A MÉTODO ESTABLECIDO
		
		return false;
	}

}
