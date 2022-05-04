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

		commentField = new VSearchFieldContainer("N�mero de comentarios", "");
		super.getFieldsList().add(commentField);
		importsField = new VSearchFieldContainer("N�mero de imports", "");
		super.getFieldsList().add(importsField);
		ifField = new VSearchFieldContainer("N�mero de if", "");
		super.getFieldsList().add(ifField);
		elseField = new VSearchFieldContainer("N�mero de else", "");
		super.getFieldsList().add(elseField);
		forField = new VSearchFieldContainer("N�mero de for", "");
		super.getFieldsList().add(forField);
		whileField = new VSearchFieldContainer("N�mero de while", "");
		super.getFieldsList().add(whileField);
		continueField = new VSearchFieldContainer("N�mero de continue", "");
		super.getFieldsList().add(continueField);
		breakField = new VSearchFieldContainer("N�mero de break", "");
		super.getFieldsList().add(breakField);
		arraysField = new VSearchFieldContainer("N�mero de arrays", "");
		super.getFieldsList().add(arraysField);
		lambdasField = new VSearchFieldContainer("N�mero de lambdas", "");
		super.getFieldsList().add(lambdasField);
		methodsField = new VSearchFieldContainer("N�mero de methods", "");
		super.getFieldsList().add(methodsField);
		variablesField = new VSearchFieldContainer("N�mero de variables", "");
		super.getFieldsList().add(variablesField);
		localVariablesField = new VSearchFieldContainer("N�mero de variables locales", "");
		super.getFieldsList().add(localVariablesField);
		staticField = new VSearchFieldContainer("N�mero de campos static", "");
		super.getFieldsList().add(staticField);
		publicField = new VSearchFieldContainer("N�mero de campos public", "");
		super.getFieldsList().add(publicField);
		privateField = new VSearchFieldContainer("N�mero de campos private", "");
		super.getFieldsList().add(privateField);
		protectedField = new VSearchFieldContainer("N�mero de campos protected", "");
		super.getFieldsList().add(protectedField);
		abstractField = new VSearchFieldContainer("N�mero de campos abstract", "");
		super.getFieldsList().add(abstractField);
		classesField = new VSearchFieldContainer("N�mero de clases", "");
		super.getFieldsList().add(classesField);
		yieldField = new VSearchFieldContainer("N�mero de yield", "");
		super.getFieldsList().add(yieldField);
		assertField = new VSearchFieldContainer("N�mero de assert", "");
		super.getFieldsList().add(assertField);
		tryField = new VSearchFieldContainer("N�mero de try", "");
		super.getFieldsList().add(tryField);
		annotationField = new VSearchFieldContainer("N�mero de annotations", "");
		super.getFieldsList().add(annotationField);
		personalConstructorField = new VSearchFieldContainer("N�mero de constructores personales", "");
		super.getFieldsList().add(personalConstructorField);
		personalInterfaceField = new VSearchFieldContainer("N�mero de interfaces personales", "");
		super.getFieldsList().add(personalInterfaceField);
		implementsField = new VSearchFieldContainer("N�mero de implements", "");
		super.getFieldsList().add(implementsField);
		extendsField = new VSearchFieldContainer("N�mero de extends", "");
		super.getFieldsList().add(extendsField);
		throwsField = new VSearchFieldContainer("N�mero de throws", "");
		super.getFieldsList().add(throwsField);
		throwField = new VSearchFieldContainer("N�mero de throw", "");
		super.getFieldsList().add(throwField);
		enumField = new VSearchFieldContainer("N�mero de enum", "");
		super.getFieldsList().add(enumField);
		finalField = new VSearchFieldContainer("N�mero de final", "");
		super.getFieldsList().add(finalField);
		switchField = new VSearchFieldContainer("N�mero de switch", "");
		super.getFieldsList().add(switchField);
		instanceofField = new VSearchFieldContainer("N�mero de instanceof", "");
		super.getFieldsList().add(instanceofField);
		synchronizedField = new VSearchFieldContainer("N�mero de synchronized", "");
		super.getFieldsList().add(synchronizedField);

	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	@Override
	public boolean filterRepositoryLanguage(Repository repository) {

		LanguageParser languageProperties = repository.getLanguageProperties();
		
		// SACAR CADENAS LIMPIAS
		// COMPARAR CADENA CON VALOR LLAMANDO A M�TODO ESTABLECIDO
		
		return false;
	}

}
