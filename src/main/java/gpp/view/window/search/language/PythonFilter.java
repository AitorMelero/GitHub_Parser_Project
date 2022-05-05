package gpp.view.window.search.language;

import gpp.model.languageparser.python.PythonLanguageParser;
import gpp.view.component.VSearchFieldContainer;

/**
 * 
 * Clase que implementa el filtro para el lenguaje Python.
 * 
 * @author Aitor Melero.
 *
 */
public class PythonFilter extends Filter {

	private VSearchFieldContainer commentField;
	private VSearchFieldContainer importsField;
	private VSearchFieldContainer ifField;
	private VSearchFieldContainer elseField;
	private VSearchFieldContainer forField;
	private VSearchFieldContainer whileField;
	private VSearchFieldContainer functionsField;
	private VSearchFieldContainer globalField;
	private VSearchFieldContainer nonlocalField;
	private VSearchFieldContainer continueField;
	private VSearchFieldContainer breakField;
	private VSearchFieldContainer arraysField;
	private VSearchFieldContainer logicalExpressionsField;
	private VSearchFieldContainer lambdaField;
	private VSearchFieldContainer classesField;
	private VSearchFieldContainer yieldField;
	private VSearchFieldContainer assertField;
	private VSearchFieldContainer tryField;
	private VSearchFieldContainer decoratorsField;
	private VSearchFieldContainer dictionariesField;
	private VSearchFieldContainer importsWithFromField;
	private VSearchFieldContainer passField;
	private VSearchFieldContainer raiseField;
	private VSearchFieldContainer withField;
	private VSearchFieldContainer asyncField;

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PythonFilter() {

		super();

		commentField = new VSearchFieldContainer("N�mero de comentarios", "");
		super.getFieldsList().add(commentField);
		super.getFieldsListValues().put(PythonLanguageParser.COMMENTS, commentField);

		importsField = new VSearchFieldContainer("N�mero de imports", "");
		super.getFieldsList().add(importsField);
		super.getFieldsListValues().put(PythonLanguageParser.IMPORTS, importsField);

		ifField = new VSearchFieldContainer("N�mero de if", "");
		super.getFieldsList().add(ifField);
		super.getFieldsListValues().put(PythonLanguageParser.IF, ifField);

		elseField = new VSearchFieldContainer("N�mero de else", "");
		super.getFieldsList().add(elseField);
		super.getFieldsListValues().put(PythonLanguageParser.ELSE, elseField);

		forField = new VSearchFieldContainer("N�mero de for", "");
		super.getFieldsList().add(forField);
		super.getFieldsListValues().put(PythonLanguageParser.FOR, forField);

		whileField = new VSearchFieldContainer("N�mero de while", "");
		super.getFieldsList().add(whileField);
		super.getFieldsListValues().put(PythonLanguageParser.WHILE, whileField);

		functionsField = new VSearchFieldContainer("N�mero de funciones", "");
		super.getFieldsList().add(functionsField);
		super.getFieldsListValues().put(PythonLanguageParser.FUNCTIONS, functionsField);

		globalField = new VSearchFieldContainer("N�mero de global", "");
		super.getFieldsList().add(globalField);
		super.getFieldsListValues().put(PythonLanguageParser.GLOBAL, globalField);

		nonlocalField = new VSearchFieldContainer("N�mero de nonlocal", "");
		super.getFieldsList().add(nonlocalField);
		super.getFieldsListValues().put(PythonLanguageParser.NONLOCAL, nonlocalField);

		continueField = new VSearchFieldContainer("N�mero de continue", "");
		super.getFieldsList().add(continueField);
		super.getFieldsListValues().put(PythonLanguageParser.CONTINUE, continueField);

		breakField = new VSearchFieldContainer("N�mero de break", "");
		super.getFieldsList().add(breakField);
		super.getFieldsListValues().put(PythonLanguageParser.BREAK, breakField);

		arraysField = new VSearchFieldContainer("N�mero de arrays", "");
		super.getFieldsList().add(arraysField);
		super.getFieldsListValues().put(PythonLanguageParser.ARRAYS, arraysField);

		logicalExpressionsField = new VSearchFieldContainer("N�mero de expresiones l�gicas", "");
		super.getFieldsList().add(logicalExpressionsField);
		super.getFieldsListValues().put(PythonLanguageParser.LOGICAL_EXPRESSIONS, logicalExpressionsField);

		lambdaField = new VSearchFieldContainer("N�mero de lambdas", "");
		super.getFieldsList().add(lambdaField);
		super.getFieldsListValues().put(PythonLanguageParser.LAMBDA, lambdaField);

		classesField = new VSearchFieldContainer("N�mero de clases", "");
		super.getFieldsList().add(classesField);
		super.getFieldsListValues().put(PythonLanguageParser.CLASSES, classesField);

		yieldField = new VSearchFieldContainer("N�mero de yield", "");
		super.getFieldsList().add(yieldField);
		super.getFieldsListValues().put(PythonLanguageParser.YIELD, yieldField);

		assertField = new VSearchFieldContainer("N�mero de assert", "");
		super.getFieldsList().add(assertField);
		super.getFieldsListValues().put(PythonLanguageParser.ASSERT, assertField);

		tryField = new VSearchFieldContainer("N�mero de try", "");
		super.getFieldsList().add(tryField);
		super.getFieldsListValues().put(PythonLanguageParser.TRY, tryField);

		decoratorsField = new VSearchFieldContainer("N�mero de decorators", "");
		super.getFieldsList().add(decoratorsField);
		super.getFieldsListValues().put(PythonLanguageParser.DECORATORS, decoratorsField);

		dictionariesField = new VSearchFieldContainer("N�mero de diccionarios", "");
		super.getFieldsList().add(dictionariesField);
		super.getFieldsListValues().put(PythonLanguageParser.DICTIONARIES, dictionariesField);

		importsWithFromField = new VSearchFieldContainer("N�mero de imports con from", "");
		super.getFieldsList().add(importsWithFromField);
		super.getFieldsListValues().put(PythonLanguageParser.IMPORTS_WITH_FROM, importsWithFromField);

		passField = new VSearchFieldContainer("N�mero de pass", "");
		super.getFieldsList().add(passField);
		super.getFieldsListValues().put(PythonLanguageParser.PASS, passField);

		raiseField = new VSearchFieldContainer("N�mero de raise", "");
		super.getFieldsList().add(raiseField);
		super.getFieldsListValues().put(PythonLanguageParser.RAISE, raiseField);

		withField = new VSearchFieldContainer("N�mero de with", "");
		super.getFieldsList().add(withField);
		super.getFieldsListValues().put(PythonLanguageParser.WITH, withField);

		asyncField = new VSearchFieldContainer("N�mero de async", "");
		super.getFieldsList().add(asyncField);
		super.getFieldsListValues().put(PythonLanguageParser.ASYNC, asyncField);

	}

}
