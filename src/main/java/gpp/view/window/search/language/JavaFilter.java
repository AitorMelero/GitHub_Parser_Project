package gpp.view.window.search.language;

import gpp.model.languageparser.java.JavaLanguageParser;
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
	private VSearchFieldContainer librariesField;
	private VSearchFieldContainer classesNamesField;
	private VSearchFieldContainer methodsNamesField;
	private VSearchFieldContainer interfacesNamesField;

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
		super.getFieldsListValues().put(JavaLanguageParser.COMMENTS, commentField);
		importsField = new VSearchFieldContainer("N�mero de imports", "");
		super.getFieldsList().add(importsField);
		super.getFieldsListValues().put(JavaLanguageParser.IMPORTS, importsField);
		ifField = new VSearchFieldContainer("N�mero de if", "");
		super.getFieldsList().add(ifField);
		super.getFieldsListValues().put(JavaLanguageParser.IF, ifField);
		elseField = new VSearchFieldContainer("N�mero de else", "");
		super.getFieldsList().add(elseField);
		super.getFieldsListValues().put(JavaLanguageParser.ELSE, elseField);
		forField = new VSearchFieldContainer("N�mero de for", "");
		super.getFieldsList().add(forField);
		super.getFieldsListValues().put(JavaLanguageParser.FOR, forField);
		whileField = new VSearchFieldContainer("N�mero de while", "");
		super.getFieldsList().add(whileField);
		super.getFieldsListValues().put(JavaLanguageParser.WHILE, whileField);
		continueField = new VSearchFieldContainer("N�mero de continue", "");
		super.getFieldsList().add(continueField);
		super.getFieldsListValues().put(JavaLanguageParser.CONTINUE, continueField);
		breakField = new VSearchFieldContainer("N�mero de break", "");
		super.getFieldsList().add(breakField);
		super.getFieldsListValues().put(JavaLanguageParser.BREAK, breakField);
		arraysField = new VSearchFieldContainer("N�mero de arrays", "");
		super.getFieldsList().add(arraysField);
		super.getFieldsListValues().put(JavaLanguageParser.ARRAYS, arraysField);
		lambdasField = new VSearchFieldContainer("N�mero de lambdas", "");
		super.getFieldsList().add(lambdasField);
		super.getFieldsListValues().put(JavaLanguageParser.LAMBDAS, lambdasField);
		methodsField = new VSearchFieldContainer("N�mero de methods", "");
		super.getFieldsList().add(methodsField);
		super.getFieldsListValues().put(JavaLanguageParser.METHODS, methodsField);
		variablesField = new VSearchFieldContainer("N�mero de variables", "");
		super.getFieldsList().add(variablesField);
		super.getFieldsListValues().put(JavaLanguageParser.VARIABLES, variablesField);
		localVariablesField = new VSearchFieldContainer("N�mero de variables locales", "");
		super.getFieldsList().add(localVariablesField);
		super.getFieldsListValues().put(JavaLanguageParser.LOCAL_VARIABLES, localVariablesField);
		staticField = new VSearchFieldContainer("N�mero de campos static", "");
		super.getFieldsList().add(staticField);
		super.getFieldsListValues().put(JavaLanguageParser.STATIC, staticField);
		publicField = new VSearchFieldContainer("N�mero de campos public", "");
		super.getFieldsList().add(publicField);
		super.getFieldsListValues().put(JavaLanguageParser.PUBLIC, publicField);
		privateField = new VSearchFieldContainer("N�mero de campos private", "");
		super.getFieldsList().add(privateField);
		super.getFieldsListValues().put(JavaLanguageParser.PRIVATE, privateField);
		protectedField = new VSearchFieldContainer("N�mero de campos protected", "");
		super.getFieldsList().add(protectedField);
		super.getFieldsListValues().put(JavaLanguageParser.PROTECTED, protectedField);
		abstractField = new VSearchFieldContainer("N�mero de campos abstract", "");
		super.getFieldsList().add(abstractField);
		super.getFieldsListValues().put(JavaLanguageParser.ABSTRACT, abstractField);
		classesField = new VSearchFieldContainer("N�mero de clases", "");
		super.getFieldsList().add(classesField);
		super.getFieldsListValues().put(JavaLanguageParser.CLASSES, classesField);
		yieldField = new VSearchFieldContainer("N�mero de yield", "");
		super.getFieldsList().add(yieldField);
		super.getFieldsListValues().put(JavaLanguageParser.YIELD, yieldField);
		assertField = new VSearchFieldContainer("N�mero de assert", "");
		super.getFieldsList().add(assertField);
		super.getFieldsListValues().put(JavaLanguageParser.ASSERT, assertField);
		tryField = new VSearchFieldContainer("N�mero de try", "");
		super.getFieldsList().add(tryField);
		super.getFieldsListValues().put(JavaLanguageParser.TRY, tryField);
		annotationField = new VSearchFieldContainer("N�mero de annotations", "");
		super.getFieldsList().add(annotationField);
		super.getFieldsListValues().put(JavaLanguageParser.ANNOTATION, annotationField);
		personalConstructorField = new VSearchFieldContainer("N�mero de constructores personales", "");
		super.getFieldsList().add(personalConstructorField);
		super.getFieldsListValues().put(JavaLanguageParser.PERSONAL_CONSTRUCTOR, personalConstructorField);
		personalInterfaceField = new VSearchFieldContainer("N�mero de interfaces personales", "");
		super.getFieldsList().add(personalInterfaceField);
		super.getFieldsListValues().put(JavaLanguageParser.PERSONAL_INTERFACE, personalInterfaceField);
		implementsField = new VSearchFieldContainer("N�mero de implements", "");
		super.getFieldsList().add(implementsField);
		super.getFieldsListValues().put(JavaLanguageParser.IMPLEMENTS, implementsField);
		extendsField = new VSearchFieldContainer("N�mero de extends", "");
		super.getFieldsList().add(extendsField);
		super.getFieldsListValues().put(JavaLanguageParser.EXTENDS, extendsField);
		throwsField = new VSearchFieldContainer("N�mero de throws", "");
		super.getFieldsList().add(throwsField);
		super.getFieldsListValues().put(JavaLanguageParser.THROWS, throwsField);
		throwField = new VSearchFieldContainer("N�mero de throw", "");
		super.getFieldsList().add(throwField);
		super.getFieldsListValues().put(JavaLanguageParser.THROW, throwField);
		enumField = new VSearchFieldContainer("N�mero de enum", "");
		super.getFieldsList().add(enumField);
		super.getFieldsListValues().put(JavaLanguageParser.ENUM, enumField);
		finalField = new VSearchFieldContainer("N�mero de final", "");
		super.getFieldsList().add(finalField);
		super.getFieldsListValues().put(JavaLanguageParser.FINAL, finalField);
		switchField = new VSearchFieldContainer("N�mero de switch", "");
		super.getFieldsList().add(switchField);
		super.getFieldsListValues().put(JavaLanguageParser.SWITCH, switchField);
		instanceofField = new VSearchFieldContainer("N�mero de instanceof", "");
		super.getFieldsList().add(instanceofField);
		super.getFieldsListValues().put(JavaLanguageParser.INSTANCEOF, instanceofField);
		synchronizedField = new VSearchFieldContainer("N�mero de synchronized", "");
		super.getFieldsList().add(synchronizedField);
		super.getFieldsListValues().put(JavaLanguageParser.SYNCHRONIZED, synchronizedField);
		librariesField = new VSearchFieldContainer("Librer�as usadas", "");
		super.getFieldsList().add(librariesField);
		super.getFieldsListValues().put(JavaLanguageParser.LIBRARIES, librariesField);
		classesNamesField = new VSearchFieldContainer("Clases usadas", "");
		super.getFieldsList().add(classesNamesField);
		super.getFieldsListValues().put(JavaLanguageParser.CLASSES_NAMES, classesNamesField);
		methodsNamesField = new VSearchFieldContainer("M�todos usados", "");
		super.getFieldsList().add(methodsNamesField);
		super.getFieldsListValues().put(JavaLanguageParser.METHODS_NAMES, methodsNamesField);
		interfacesNamesField = new VSearchFieldContainer("Interfaces usadas", "");
		super.getFieldsList().add(interfacesNamesField);
		super.getFieldsListValues().put(JavaLanguageParser.INTERFACES_NAMES, interfacesNamesField);

	}

}
