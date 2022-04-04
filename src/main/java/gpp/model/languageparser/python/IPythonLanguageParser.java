package gpp.model.languageparser.python;

/**
 * 
 * Definici�n de acciones comunes para parsear c�digo en Python.
 * 
 * @author Aitor Melero
 *
 */
public interface IPythonLanguageParser {

	/**
	 * 
	 * Indica si el c�digo hace uso de funciones.
	 * 
	 * @return True si el c�digo hace uso de funciones, false en caso contrario.
	 */
	boolean useFunctions();

	/**
	 * 
	 * Indica el n�mero de funciones del c�digo.
	 * 
	 * @return N�mero de funciones del c�digo.
	 */
	int getNumberFunctions();

	/**
	 * 
	 * Indica si el c�digo hace uso de global.
	 * 
	 * @return True si el c�digo hace uso de global, false en caso contrario.
	 */
	boolean useGlobal();

	/**
	 * 
	 * Indica el n�mero de global del c�digo.
	 * 
	 * @return N�mero de global del c�digo.
	 */
	int getNumberGlobal();

	/**
	 * 
	 * Indica si el c�digo hace uso de nonlocal.
	 * 
	 * @return True si el c�digo hace uso de nonlocal, false en caso contrario.
	 */
	boolean useNonLocal();

	/**
	 * 
	 * Indica el n�mero de nonlocal del c�digo.
	 * 
	 * @return N�mero de nonlocal del c�digo.
	 */
	int getNumberNonLocal();

	/**
	 * 
	 * Indica si el c�digo hace uso de expresiones l�gicas.
	 * 
	 * @return True si el c�digo hace uso de expresiones l�gicas.
	 */
	boolean useLogicalExpressions();

	/**
	 * 
	 * Indica el n�mero de veces que el c�digo hace uso de expresiones l�gicas.
	 * 
	 * @return N�mero de veces que el c�digo hace uso de expresiones l�gicas.
	 */
	int getNumberLogicalExpressions();

	/**
	 * 
	 * Indica si el c�digo hace uso de clases.
	 * 
	 * @return True si el c�digo hace uso de clases, false en caso contrario.
	 */
	boolean useClasses();

	/**
	 * 
	 * Indica el n�mero de clases del c�digo.
	 * 
	 * @return N�mero de clases del c�digo.
	 */
	int getNumberClasses();

	/**
	 * 
	 * Indica si el c�digo hace uso de yield.
	 * 
	 * @return True si el c�digo hace uso de yield, false en caso contrario.
	 */
	boolean useYield();

	/**
	 * 
	 * Indica el n�mero de yield del c�digo.
	 * 
	 * @return N�mero de yield del c�digo.
	 */
	int getNumberYield();

	/**
	 * 
	 * Indica si el c�digo hace uso de assert.
	 * 
	 * @return True si el c�digo hace uso de assert, false en caso contrario.
	 */
	boolean useAssert();

	/**
	 * 
	 * Indica el n�mero de asserts del c�digo.
	 * 
	 * @return N�mero de asserts del c�digo.
	 */
	int getNumberAssert();

	/**
	 * 
	 * Indica si el c�digo hace uso de try.
	 * 
	 * @return True si el c�digo hace uso de try, false en caso contrario.
	 */
	boolean useTry();

	/**
	 * 
	 * Indica el n�mero de try del c�digo.
	 * 
	 * @return N�mero de try del c�digo.
	 */
	int getNumberTry();

	/**
	 * 
	 * Indica si el c�digo hace uso de decorators.
	 * 
	 * @return True si el c�digo hace uso de decorators, false en caso contrario.
	 */
	boolean useDecorators();

	/**
	 * 
	 * Indica el n�mero de decorators del c�digo.
	 * 
	 * @return N�mero de decorators del c�digo.
	 */
	int getNumberDecorators();

	/**
	 * 
	 * Indica si el c�digo hace uso de diccionarios.
	 * 
	 * @return True si el c�digo hace uso de diccionarios, false en caso contrario.
	 */
	boolean useDictionaries();

	/**
	 * 
	 * Indica el n�mero de diccionarios del c�digo.
	 * 
	 * @return N�mero de diccionarios del c�digo.
	 */
	int getNumberDictionaries();

	/**
	 * 
	 * Indica si el c�digo hace uso de imports con from.
	 * 
	 * @return True si el c�digo hace uso de imports con from, false en caso
	 *         contrario.
	 */
	boolean useImportsWithFrom();

	/**
	 * 
	 * Indica el n�mero de imports con from del c�digo.
	 * 
	 * @return N�mero de imports con from del c�digo.
	 */
	int getNumberImportsWithFrom();

	/**
	 * 
	 * Indica si el c�digo hace uso de pass.
	 * 
	 * @return True si el c�digo hace uso de pass, false en caso contrario.
	 */
	boolean usePass();

	/**
	 * 
	 * Indica el n�mero de pass del c�digo.
	 * 
	 * @return N�mero de pass del c�digo.
	 */
	int getNumberPass();

	/**
	 * 
	 * Indica si el c�digo hace uso de raise.
	 * 
	 * @return True si el c�digo hace uso de raise, false en caso contrario.
	 */
	boolean useRaise();

	/**
	 * 
	 * Indica el n�mero de raise del c�digo.
	 * 
	 * @return N�mero de raise del c�digo.
	 */
	int getNumberRaise();

	/**
	 * 
	 * Indica si el c�digo hace uso de with.
	 * 
	 * @return True si el c�digo hace uso de with, false en caso contrario.
	 */
	boolean useWith();

	/**
	 * 
	 * Indica el n�mero de with del c�digo.
	 * 
	 * @return N�mero de with del c�digo.
	 */
	int getNumberWith();

	/**
	 * 
	 * Indica si el c�digo hace uso de async.
	 * 
	 * @return True si el c�digo hace uso de assync, false en caso contrario.
	 */
	boolean useAsync();

	/**
	 * 
	 * Indica el n�mero de assync del c�digo.
	 * 
	 * @return N�mero de assync del c�digo.
	 */
	int getNumberAsync();

}
