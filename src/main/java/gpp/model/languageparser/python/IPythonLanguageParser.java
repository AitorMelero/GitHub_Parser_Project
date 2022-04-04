package gpp.model.languageparser.python;

/**
 * 
 * Definición de acciones comunes para parsear código en Python.
 * 
 * @author Aitor Melero
 *
 */
public interface IPythonLanguageParser {

	/**
	 * 
	 * Indica si el código hace uso de funciones.
	 * 
	 * @return True si el código hace uso de funciones, false en caso contrario.
	 */
	boolean useFunctions();

	/**
	 * 
	 * Indica el número de funciones del código.
	 * 
	 * @return Número de funciones del código.
	 */
	int getNumberFunctions();

	/**
	 * 
	 * Indica si el código hace uso de global.
	 * 
	 * @return True si el código hace uso de global, false en caso contrario.
	 */
	boolean useGlobal();

	/**
	 * 
	 * Indica el número de global del código.
	 * 
	 * @return Número de global del código.
	 */
	int getNumberGlobal();

	/**
	 * 
	 * Indica si el código hace uso de nonlocal.
	 * 
	 * @return True si el código hace uso de nonlocal, false en caso contrario.
	 */
	boolean useNonLocal();

	/**
	 * 
	 * Indica el número de nonlocal del código.
	 * 
	 * @return Número de nonlocal del código.
	 */
	int getNumberNonLocal();

	/**
	 * 
	 * Indica si el código hace uso de expresiones lógicas.
	 * 
	 * @return True si el código hace uso de expresiones lógicas.
	 */
	boolean useLogicalExpressions();

	/**
	 * 
	 * Indica el número de veces que el código hace uso de expresiones lógicas.
	 * 
	 * @return Número de veces que el código hace uso de expresiones lógicas.
	 */
	int getNumberLogicalExpressions();

	/**
	 * 
	 * Indica si el código hace uso de clases.
	 * 
	 * @return True si el código hace uso de clases, false en caso contrario.
	 */
	boolean useClasses();

	/**
	 * 
	 * Indica el número de clases del código.
	 * 
	 * @return Número de clases del código.
	 */
	int getNumberClasses();

	/**
	 * 
	 * Indica si el código hace uso de yield.
	 * 
	 * @return True si el código hace uso de yield, false en caso contrario.
	 */
	boolean useYield();

	/**
	 * 
	 * Indica el número de yield del código.
	 * 
	 * @return Número de yield del código.
	 */
	int getNumberYield();

	/**
	 * 
	 * Indica si el código hace uso de assert.
	 * 
	 * @return True si el código hace uso de assert, false en caso contrario.
	 */
	boolean useAssert();

	/**
	 * 
	 * Indica el número de asserts del código.
	 * 
	 * @return Número de asserts del código.
	 */
	int getNumberAssert();

	/**
	 * 
	 * Indica si el código hace uso de try.
	 * 
	 * @return True si el código hace uso de try, false en caso contrario.
	 */
	boolean useTry();

	/**
	 * 
	 * Indica el número de try del código.
	 * 
	 * @return Número de try del código.
	 */
	int getNumberTry();

	/**
	 * 
	 * Indica si el código hace uso de decorators.
	 * 
	 * @return True si el código hace uso de decorators, false en caso contrario.
	 */
	boolean useDecorators();

	/**
	 * 
	 * Indica el número de decorators del código.
	 * 
	 * @return Número de decorators del código.
	 */
	int getNumberDecorators();

	/**
	 * 
	 * Indica si el código hace uso de diccionarios.
	 * 
	 * @return True si el código hace uso de diccionarios, false en caso contrario.
	 */
	boolean useDictionaries();

	/**
	 * 
	 * Indica el número de diccionarios del código.
	 * 
	 * @return Número de diccionarios del código.
	 */
	int getNumberDictionaries();

	/**
	 * 
	 * Indica si el código hace uso de imports con from.
	 * 
	 * @return True si el código hace uso de imports con from, false en caso
	 *         contrario.
	 */
	boolean useImportsWithFrom();

	/**
	 * 
	 * Indica el número de imports con from del código.
	 * 
	 * @return Número de imports con from del código.
	 */
	int getNumberImportsWithFrom();

	/**
	 * 
	 * Indica si el código hace uso de pass.
	 * 
	 * @return True si el código hace uso de pass, false en caso contrario.
	 */
	boolean usePass();

	/**
	 * 
	 * Indica el número de pass del código.
	 * 
	 * @return Número de pass del código.
	 */
	int getNumberPass();

	/**
	 * 
	 * Indica si el código hace uso de raise.
	 * 
	 * @return True si el código hace uso de raise, false en caso contrario.
	 */
	boolean useRaise();

	/**
	 * 
	 * Indica el número de raise del código.
	 * 
	 * @return Número de raise del código.
	 */
	int getNumberRaise();

	/**
	 * 
	 * Indica si el código hace uso de with.
	 * 
	 * @return True si el código hace uso de with, false en caso contrario.
	 */
	boolean useWith();

	/**
	 * 
	 * Indica el número de with del código.
	 * 
	 * @return Número de with del código.
	 */
	int getNumberWith();

	/**
	 * 
	 * Indica si el código hace uso de async.
	 * 
	 * @return True si el código hace uso de assync, false en caso contrario.
	 */
	boolean useAsync();

	/**
	 * 
	 * Indica el número de assync del código.
	 * 
	 * @return Número de assync del código.
	 */
	int getNumberAsync();

}
